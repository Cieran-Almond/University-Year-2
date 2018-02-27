package exampleGame;



import javax.swing.*;
import java.awt.*;

/**
 * Created by ca16873 on 30/11/2017.
 */
public class DrawShapes extends JFrame {
    //shapes objects.
    Square square;
    Circle circle;
    Rectangle rectangle;
    Triangle triangle;
    //Pie pie;

    //main initalises new frame to draw shapes to.
    public static void main(String[] args) {
        //frame with drawcacl components
        DrawShapes frame = new DrawShapes();
        //allows frame to close on X
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        //disable resizing
        frame.setResizable(false);
    }
    //drawshapes method calls individual shape methods and draws them with supplied values.
    public DrawShapes(){
        square = new Square(2, 2, 50, 30);
        circle = new Circle(50, 50, 50, 20);
        rectangle = new Rectangle(20, 20, 60, 60, 12);
        triangle = new Triangle (40, 40, 40, 2);
        //pie = new Pie ();

        //size of canvas panel.
        JPanel bPanel = new Canvas(this);
        bPanel.setPreferredSize(new Dimension(600, 600));
    }

    //abstract shape class that other classes with extend to get parameters.
    public abstract class Shape {
        int posX;
        int posY;
        int rotation;

        abstract void paint(Graphics g);
    }
    //rectangle shape class with own parameters and method (constructor) and paint override with supplied constructor args.
    class Rectangle extends Shape {

        int sideLong;
        int sideShort;

        public Rectangle(int x, int y, int sideLong, int sideShort, int rotation) {

            this.posX = x;
            this.posY = y;
            this.sideLong = sideLong;
            this.sideShort = sideShort;
            this.rotation = rotation;
        }
        @Override
        void paint(Graphics g) {
            g.fillRect(super.posX, super.posY, sideShort, sideLong);
        }
    }

    //square shape class with own parameters and method (constructor) and paint override with supplied constructor args.
    class Square extends Shape {

        int sideLength;

        public Square(int x, int y, int sideLength, int rotation) {

            this.posX = x;
            this.posY = y;
            this.sideLength = sideLength;
            this.rotation = rotation;
        }
        @Override
        void paint(Graphics g) {
            g.fillRect(super.posX, super.posY, sideLength, sideLength);
        }
    }

    //circle shape class with own parameters and method (constructor) and paint override with supplied constructor args.
    class Circle extends Shape {

        int radius;

        public Circle(int x, int y, int radius, int rotation) {
            this.radius = radius;
            this.posX = x;
            this.posY = y;
            this.rotation = rotation;
        }

        @Override
        void paint(Graphics g) {
            g.drawOval(super.posX, super.posY, radius * 2, radius * 2);
        }
    }
        //triangle shape class with own parameters and method (constructor) and paint override with supplied constructor args.
        class Triangle extends Shape {
        int posZ;

            public Triangle(int x, int y, int z, int rotation){
                this.posX = x;
                this.posY = y;
                this.posZ = z;
                this.rotation = rotation;
            }


            @Override
            void paint(Graphics g) {
                g.drawPolygon(new int[]{10,20,30}, new int[]{100,20,100}, 3);
            }
        }

        /*class Pie extends Shape {
            double value;

            public Pie (double value)

        }

        */

    //canvas class calls paint method of each shape to draw to canvas, gotten via thisApp.
    class Canvas extends JPanel{
        DrawShapes thisApp;

        public Canvas(DrawShapes thisApp) {this.thisApp = thisApp;}

        @Override
        public void paintComponent(Graphics g){
            thisApp.circle.paint(g);
            thisApp.square.paint(g);
            thisApp.rectangle.paint(g);
            thisApp.triangle.paint(g);
            //thisApp.pie.paint(g);
        }
    }
}

