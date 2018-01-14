import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.Arrays;
import javax.swing.JFrame;

public class DateGUI extends JFrame { 
   // DateGUI will inherit the abilities of a JFrame
   
   public static int[] sortDates(String[] list) {
      // method that will sort the dates given by a String array
      
      int[] sortedDates = new int[list.length];
      for (int i = 0; i < list.length; i++) {
         // convert the strings into ints so they could be sorted
         sortedDates[i] = Integer.parseInt(list[i]);
      } // close for loop
      
      // use the Array method to sort the dates from youngest to oldest
      Arrays.sort(sortedDates);
      return sortedDates;
   }

   public static void printDatesToGUI(DateGUI myGUI, String[] list) {
      // method that will initialize a GUI and display the 
      // string of dates on one side, and the dates converted 
      // by the toString() method on the other
      myGUI = new DateGUI();
      myGUI.setSize(400, 400);
      myGUI.setLocation(100, 100);
      myGUI.setLayout(new GridLayout(1, 2));
      myGUI.setTitle("Dates");
      myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container myContentPane = myGUI.getContentPane();
      TextArea myDates = new TextArea();
      TextArea mySubscripts = new TextArea();
      myContentPane.add(mySubscripts);
      myContentPane.add(myDates);
      
      // new array that will have the sorted dates
      String[] sorted = new String[list.length];
      for (int i = 0; i < list.length; i++)
         sorted[i] = String.valueOf(sortDates(list)[i]);
      
      // add the sorted dates to the left side of the GUI
      for (int i = 0; i < list.length; i++) 
         mySubscripts.append(sorted[i] + "\n");
      
      // add the sorted dates that are converted by 
      // the toString method to the right side of the GUI 
      for (int i = 0; i < list.length; i++) {
         Date212 date = new Date212(sorted[i]);
         myDates.append(date.toString(date) + "\n");
      }
      
      myGUI.setVisible(true);
   } // close printDatesToGUI

} // close DateGUI
