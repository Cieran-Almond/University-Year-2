import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ca16873 on 31/10/2017.
 */
public class CE203_2017_Ex1 {
    //objects specific to initaliseComponents
    JFrame frame;
    JPanel south, center, north, main;
    JTextField R, G, B;
    JButton applyButton, resetButton;
    JLabel text;


    //main method with constructor
    public static void main( String[] args ) {
        CE203_2017_Ex1 app = new CE203_2017_Ex1();
    }

    CE203_2017_Ex1() {
        // Create the components
        initialiseComponents();
    }

    public void initialiseComponents() {
        // Create Frame
        // disable resizable
        // give frame a close operation
        // sets to visible
        frame = new JFrame("Exericse 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        // create text fields
        R = new JTextField(3);
        G = new JTextField(3);
        B = new JTextField(3);

        // Create jpanels
        main = new JPanel(new BorderLayout());
        south = new JPanel();
        north = new JPanel();
        center = new JPanel();

        // Create buttons
        applyButton = new JButton("Apply");
        resetButton = new JButton("Reset");

        // Add button handlers
        applyButton.addActionListener(new ApplyButtonHandler(this));
        resetButton.addActionListener(new ResetButtonHandler(this));

        // Initialise Label
        text = new JLabel("CE203 Assignment 1, submitted by: Cieran Almond - 1604959");
        text.setForeground(new Color(0,0,255));

        // Add panels to areas
        main.add(south, BorderLayout.SOUTH);
        main.add(center, BorderLayout.CENTER);
        main.add(north, BorderLayout.NORTH);

        // add components to their panels
        south.add(new JLabel("R:"));
        south.add(R );
        south.add(new JLabel("G:"));
        south.add(G );
        south.add(new JLabel(" B:"));
        south.add(B );
        south.add(applyButton);
        center.add(text);
        north.add(resetButton);

        // Add main panel to the frame
        frame.add(main);
        // Pack frame so it fits all the buttons in a good format
        frame.pack();
    }


    class ApplyButtonHandler implements ActionListener {

        CE203_2017_Ex1 app;
        int R, G, B;

        //gets ex1 components via app

        //constructor thisApp
        public ApplyButtonHandler(CE203_2017_Ex1 app) {
            this.app = app;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        /*try catch exceptions to catch invalid input, (high values, strings and empty values)
         and reset text upon these exceptions

        */

            try {
                //parse int value to R from gettext
                this.R = Integer.parseInt(app.R.getText());
                //checks values and sets text field to appropriate values
                if (this.R > 255) {
                    app.R.setText("255");
                    this.R = 255;
                }
                if (this.R < 0) {
                    app.R.setText("200");
                    this.R = 200;
                }
            } catch (Exception ex) {
                this.R = 0;
                //set text to excepton to message
                app.text.setText("Invalid input - Please enter an integer for each field.");
                //resets text field
                app.R.setText("");
            }

            try {
                //parse int value to G from gettext
                this.G = Integer.parseInt(app.G.getText());
                //checks values and sets text field to appropriate values
                if (this.G > 255) {
                    app.G.setText("255");
                    this.G = 255;
                }
                if (this.G < 0) {
                    app.G.setText("200");
                    this.G = 200;
                }
            } catch (Exception ex) {

                this.G = 0;
                //set text on exception to message
                app.text.setText("Invalid input - Please enter an integer for each field.");
                //resets text field
                app.G.setText("");
            }

            try {
                //parse int value to B from gettext
                this.B = Integer.parseInt(app.B.getText());
                //checks values and sets text field to appropriate values
                if (this.B > 255) {
                    app.B.setText("255");
                    this.B = 255;
                }
                if (this.B < 0) {
                    app.B.setText("200");
                    this.B = 200;
                }
            } catch (Exception ex) {
                this.B = 0;
                //set text on exception to message
                app.text.setText("Invalid input - Please enter an integer for each field.");
                //resets text field
                app.B.setText("");
            }
            //sets RGB value colours
            app.text.setForeground(new Color(R, G, B));
        }
    }
        class ResetButtonHandler implements ActionListener {

            CE203_2017_Ex1 app;

            //gets objects from ce203 via app.

            public ResetButtonHandler(CE203_2017_Ex1 app) {
                this.app = app;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                app.text.setForeground( new Color( 0, 0, 255 ) );
                //reset text colour to default colour
                app.text.setText( "CE203 Assignment 1, submitted by: Cieran Almond - 1604959" );
                //reset all fields to empty
                app.R.setText("");
                app.G.setText("");
                app.B.setText("");
            }
        }
}



