import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;





public class CE203_2017_Ex2 {


    //main method with constructor
    public static void main(String[] args) {
        CE203_2017_Ex2 thisApp = new CE203_2017_Ex2();
    }

    //objects specific to initaliseComponents
    JFrame frame;
    JPanel south, center, north, main;
    JTextField userInput;
    JButton addWord, findLetter, findWord, removeLastWord, removeAllWord, clearList;
    JLabel text;
    LinkedList<String> validInput;

    CE203_2017_Ex2() {
        // Create the components
        initialiseComponents();
    }

    public void initialiseComponents() {
        // Create Frame
        // disable resizable
        // give frame a close operation
        // sets to visible
        frame = new JFrame("Exercise 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        //create text field with 20 columns
        userInput = new JTextField(20);
        //create linked list to check valid input
        validInput = new LinkedList<>();
        //create new instances of panels for later button layouts
        main = new JPanel(new BorderLayout());
        south = new JPanel();
        north = new JPanel();
        center = new JPanel();
        //create buttons for each task
        addWord = new JButton("Add Word");
        findLetter = new JButton("Find a word with a specified letter");
        findWord = new JButton("Find a word and number of occurances");
        removeLastWord = new JButton("Remove last word");
        removeAllWord = new JButton("Remove all occurances of a word");
        clearList = new JButton("Clear the list");
        //add buttons to actionlisteners
        addWord.addActionListener(new AddWordButtonHandler(this));
        findLetter.addActionListener(new FindLetterButtonHandler(this));
        findWord.addActionListener(new FindWordButtonHandler(this));
        removeLastWord.addActionListener(new RemoveLastWordButtonHandler(this));
        removeAllWord.addActionListener(new RemoveAllWordButtonHandler(this));
        clearList.addActionListener(new ClearListButtonHandler(this));
        //create text field that displays information from buttons
        text = new JLabel("Result");
        //add the panels to their respective areas
        main.add(south, BorderLayout.SOUTH);
        main.add(center, BorderLayout.CENTER);
        main.add(north, BorderLayout.NORTH);
        // add components to their panels
        north.add(addWord);
        north.add(findLetter);
        north.add(findWord);
        north.add(removeLastWord);
        north.add(removeAllWord);
        north.add(clearList);
        south.add(userInput);
        center.add(text);

        // Add main panel to the frame
        frame.add(main);
        // Pack frame so it fits all the buttons in a good format
        frame.pack();
    }


    class AddWordButtonHandler implements ActionListener {

        CE203_2017_Ex2 thisApp;
        //gets ex2 components via app

        //constructor thisApp
        public AddWordButtonHandler(CE203_2017_Ex2 thisApp) {
            this.thisApp = thisApp;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //set word to values of userinput
            String word = thisApp.userInput.getText();
            //checks first character to see if digit, prints appropriate error message
            if (Character.isDigit(word.charAt(0))) {
                thisApp.text.setText("Invalid input - First character must be a letter.");
            }
            //checks if first character is - , prints appropriate error message
            else if (String.valueOf(word.charAt(0)).equals("-")) {
                thisApp.text.setText("Invalid input - First character must be a letter.");
            } else if (!uses(word)) {
                thisApp.text.setText("Word does not contain valid characters.");
            }
            //after checks, assumes first letter is word, and add to list
            else {
                thisApp.text.setText("Word " + word + " was added to the list.");
                thisApp.validInput.add(word);
            }
        }
    }

    public boolean uses(String word) {
        //sets them to lowercase
        word = word.toLowerCase();
        //uses regex to check the correct input
        for (int i = 0; i < word.length(); i++) {
            if (word.matches("[a-z][0-9][-]"))
                return false;
        }
        return true;

    }

    class FindLetterButtonHandler implements ActionListener {

        CE203_2017_Ex2 thisApp;
        //gets ex2 components via app

        //constructor thisApp

        public FindLetterButtonHandler(CE203_2017_Ex2 thisApp) {
            this.thisApp = thisApp;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //gets first character in lowercase to compare to other words added, call it letter
            String letter = String.valueOf(thisApp.userInput.getText().charAt(0)).toLowerCase();
            //create empty string to store equals letters
            String myString = "";
            //checks if first value got (letter) is the same as other words characters at the last position
            for (String word : thisApp.validInput) {
                if (String.valueOf(word.charAt(word.length() - 1)).equals(letter)) {
                    //add same words to myString
                    myString += word + " ";
                }
            }
            //print appropriate message if string is empty
            if (myString.isEmpty()) {
                thisApp.text.setText("No words found ending with the letter '" + letter + "'.");
            }
            //prints words found with myString
            else {
                thisApp.text.setText("Found words: " + myString);
            }
        }
    }

    class FindWordButtonHandler implements ActionListener {

        CE203_2017_Ex2 thisApp;
        //gets ex2 components via app

        //constructor thisApp

        public FindWordButtonHandler(CE203_2017_Ex2 app) {
            this.thisApp = app;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //sets user input to thisWord
            String thisWord = thisApp.userInput.getText();
            //empty string to store same words
            String myString = "";
            //count for index position
            int count = 0;
            //use .equals to compare words, if they are the same, get position (i), and iterates count after each loop
            for (int i = 0; i < thisApp.validInput.size(); i++) {
                if (thisApp.validInput.get(i).toLowerCase().equals(thisWord)) {
                    myString += i + " ";
                    count++;
                }
            }
            //print appropriate message if no words match
            if (myString.isEmpty()) {
                thisApp.text.setText("No words found that match '" + thisWord + "'.");
            }
            //print words that are the same, occurances and position
            else {
                thisApp.text.setText("Found words " + "[" + count + "]: " + myString);
            }
        }
    }

    class RemoveLastWordButtonHandler implements ActionListener {

        CE203_2017_Ex2 thisApp;
        //gets ex2 components via app

        //constructor thisApp

        public RemoveLastWordButtonHandler(CE203_2017_Ex2 thisApp) {
            this.thisApp = thisApp;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String word = thisApp.userInput.getText().toLowerCase();
            //boolean to check if word has been removed
            boolean removed = false;
            //iterates backwards through size of the list from pos -1
            for (int i = thisApp.validInput.size() - 1; i > 0; i--) {
                //get last occurance in lowercase
                String w = thisApp.validInput.get(i).toLowerCase();
                //removes word, sets boolean to true and breaks to ensure only last occurance will be removed
                if (word.equals(w)) {
                    thisApp.text.setText("Last occurence of the word '" + word + "' has been removed.");
                    thisApp.validInput.remove(i);
                    removed = true;
                    break;
                }
                if (removed == false) {
                    thisApp.text.setText("There are no occurrences of the word '" + word + "' in the list.");
                }
            }
        }
    }

    class RemoveAllWordButtonHandler implements ActionListener {

        CE203_2017_Ex2 thisApp;
        //gets ex2 components via app

        //constructor thisApp

        public RemoveAllWordButtonHandler(CE203_2017_Ex2 thisApp) {
            this.thisApp = thisApp;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        /*
        tried using a comparator but could never get it to work

         */
            String word = thisApp.userInput.getText().toLowerCase();
            //set the input to an iterator
            Iterator<String> iter = thisApp.validInput.iterator();
            //goes through every value of the iterator, sets the string to lowercase and removes all words in that case
            while (iter.hasNext()) {
                String str = iter.next().toLowerCase();
                if (word.equals(str)) {
                    iter.remove();
                }
            }
            //print appropriate message
            thisApp.text.setText("All occurrences of '" + word + "' have been removed.");
        }
    }

    class ClearListButtonHandler implements ActionListener {

        CE203_2017_Ex2 thisApp;

        public ClearListButtonHandler(CE203_2017_Ex2 thisApp) {
            this.thisApp = thisApp;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //checks if empty, settext to message if emppty
            if (thisApp.validInput.isEmpty()) {
                thisApp.text.setText("The list is already empty.");
            } else {
                //if not empty, clear list and settext to message
                thisApp.text.setText("List has been cleared.");
                thisApp.validInput.clear();
            }
        }
    }
}



