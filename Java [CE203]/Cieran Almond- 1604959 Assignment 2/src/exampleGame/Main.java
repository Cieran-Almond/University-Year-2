package exampleGame;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
/**
 * Created by ca16873 on 30/11/2017.
 */
public class Main {

	//main function initalises new JFrame, title, size of pane, and new instance of game.
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Cieran Almond 1604959");
		Game g = new Game();
		frame.setContentPane(g);
		frame.setSize(300, 700);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//square grid that holds 20x20 empty grid in the JFrame
		 /*
         class SquareGrid extends JFrame {

                private static final int Rows = 20;
                private static final int Columns = 20;
                private List<JFrame> grid = new ArrayList<>();
         }
		*/
		/*
		class Handler {

			public void arrowKey(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
					case KeyEvent.VK_UP:
						//up key pressed
						break;
					case KeyEvent.VK_DOWN:
						//down key pressed
						break;
					case KeyEvent.VK_LEFT:
						//left key pressed
						break;
					case KeyEvent.VK_RIGHT:
						//right key pressed
						break;

				}
			}
		}
		*/
		/*
		class handler2 {
			public void mouseClick (MouseEvent e){

			}

			public void mouseReleased(MouseEvent e) {

   			}

			public void mouseEntered(MouseEvent e) {

    		}

    		public void mouseExited(MouseEvent e) {

    		}

    		public void mouseClicked(MouseEvent e) {

    		}
		}
	*/
	}

}
