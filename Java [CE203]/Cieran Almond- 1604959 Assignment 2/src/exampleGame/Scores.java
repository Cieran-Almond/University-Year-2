package exampleGame;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Created by ca16873 on 30/11/2017.
 */
public class Scores {
    //class for writing scores to a text file
   public  int scoreBottom , scoreTop;
   File scorefile;

    static List<String> scores = new ArrayList<>();
	
    Scores() {
    	     scorefile = new File( "scores.txt" );
      
    	}
    //add scores to file if scorefile!= null, otherwise catch filenotfound exception
    public void update() {
        Scanner sc;
        try {
            sc = new Scanner(scorefile);
        }
        catch (Exception e) {
            sc = null;
            System.out.println( "File not found." );
        }
        if (sc != null)  {
            while (sc.hasNext()) {
                scores.add(sc.next());
            } 
        	
        }
       
        
    }
    //use buffered reader or file reader?


    //writes score for each player, if file doesnt exist, create new file and use filewriter to write to file
   public void WriteToFile(int b , int t ){
	   
	   scoreBottom=b;
       scoreTop=t;
	   
	   try { 
	          
           if(!scorefile.exists()) {
              scorefile.createNewFile();
           } 
           FileWriter fileWritter = new FileWriter(scorefile.getName(),true);
           BufferedWriter bw = new BufferedWriter(fileWritter);
           String s=Integer.toString(scoreTop);
           bw.write(s);
           bw.close();
           System.out.println("Done");
        } catch(IOException e){
           e.printStackTrace();
        }
	   
   }

   //gets the top10 scores, sorts them, converts int to string so it can be displayed.
    public void top10() {
        List<Integer> scoreInts = new ArrayList<>();
        if (!scores.isEmpty()) {
            for (String score : scores) {
                scoreInts.add(Integer.valueOf( score.split(" - " )[1]));
            }
            Collections.sort(scores);
            int i = 0;
            JPanel topScore=new JPanel();
            topScore.setVisible(true);
            JTextArea textArea=new JTextArea(10 ,1);
            for( i = 0; i <=10; i--){
            	int s=scoreInts.get(i);
            	String t = Integer.toString(s);
            	if(i==0){
            	textArea.insert(t ,0);
            	}
            	else{}
            	textArea.append(t);

            }
        }
    }
}

/*
    Time - score

    1
 */


