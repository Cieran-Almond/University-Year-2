package exampleGame;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.*;
/**
 * Created by ca16873 on 30/11/2017.
 */
public class Game extends JPanel implements KeyListener, ActionListener {
	//game objects
	private int height, width;
	private Timer t = new Timer(5, this);
	private boolean first;
	
	private HashSet<String> keys = new HashSet<String>();
	
	//make new pads for player, ai of size 10x40
	private final int SPEED = 1;
	private int padH = 10, padW = 40;
	private int bottomPadX, topPadX;
	private int inset = 10;
	
	//make new ball of size 20 and velocity 1 on x and y pos
	private double ballX, ballY, velX = 1, velY = 1, ballSize = 20;
	
	//score for top and bottom player
	public  int scoreTop, scoreBottom;

	//game instance start
	public Game() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		first = true;
		t.setInitialDelay(100);
		t.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		height = getHeight();
		width = getWidth();

		//initial positioning
		if (first) {
			bottomPadX = width / 2 - padW / 2;
			topPadX = bottomPadX;
			ballX = width / 2 - ballSize / 2;
			ballY = height / 2 - ballSize / 2;
			first = false;
		}
		
		//bottom pad fill with graphics (not using shapes)
		Rectangle2D bottomPad = new Rectangle(bottomPadX, height - padH - inset, padW, padH);
		g2d.fill(bottomPad);
		
		//top pad fill with graphics (not using shapes)
		Rectangle2D topPad = new Rectangle(topPadX, inset, padW, padH);
		g2d.fill(topPad);
		
		//ballnfill with graphics (not using shapes)
		Ellipse2D ball = new Ellipse2D.Double(ballX, ballY, ballSize, ballSize);
		g2d.fill(ball);
		
		//scores that are displayed in middle of JFrame
		String scoreB = "Bottom: " + new Integer(scoreBottom).toString();
		String scoreT = "Top: " + new Integer(scoreTop).toString();
		g2d.drawString(scoreB, 10, height / 2);
		g2d.drawString(scoreT, width - 50, height / 2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//side walls.
		if (ballX < 0 || ballX > width - ballSize) {
			velX = -velX;
		}
		//top and side walls.

		//increment score bottom
		if (ballY < 0) {
			velY = -velY;
			++ scoreBottom;
		}
		//increment score top
		if (ballY + ballSize > height) {
			velY = -velY;
			++ scoreTop;
		}
		//bottom pad movement
		if (ballY + ballSize >= height - padH - inset && velY > 0)
			if (ballX + ballSize >= bottomPadX && ballX <= bottomPadX + padW)
				velY = -velY;

		//top pad movement
		if (ballY <= padH + inset && velY < 0)
			if (ballX + ballSize >= topPadX && ballX <= topPadX + padW)
				velY = -velY;

		ballX += velX;
		ballY += velY;
		
		//on key press move pad for bottom pad + bottompad less than width - padw.
		if (keys.size() == 1) {
			if (keys.contains("LEFT")) {
				bottomPadX -= (bottomPadX > 0) ? SPEED : 0;
			}
			else if (keys.contains("RIGHT")) {
				bottomPadX += (bottomPadX < width - padW) ? SPEED : 0;
			}
			else if(keys.contains("Enter")){
				PassScores(scoreBottom , scoreTop);
				
			}
		}
		
		//AI(mirrors movements) move left and right depending on if balls position is bigger or smaller
		double delta = ballX - topPadX;
		if (delta > 0) {
			topPadX += (topPadX < width - padW) ? SPEED : 0;
		}

		else if (delta < 0) {
			topPadX -= (topPadX > 0) ? SPEED : 0;
		}
		
		repaint();
	}
	//key typed
	@Override
	public void keyTyped(KeyEvent e) {}
	//key pressed swith, get key
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case KeyEvent.VK_LEFT:
			keys.add("LEFT");
			break;
		case KeyEvent.VK_RIGHT:
			keys.add("RIGHT");
			break;
		case KeyEvent.VK_ENTER:
			keys.add("Enter");
		}
	}
	//key released, remove keypress (for paint components)
	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case KeyEvent.VK_LEFT:
			keys.remove("LEFT");
			break;
		case KeyEvent.VK_RIGHT:
			keys.remove("RIGHT");
			break;
		}
	}
	//passes score to file for each pad, and does top 10
	public void PassScores(int SB , int ST){
		Scores ss=new Scores();
		ss.WriteToFile(SB , ST);
		ss.update();
		ss.top10();
		
	}
}