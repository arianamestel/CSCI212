import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;


public class FileMenuHandler implements ActionListener {
   DateGUI dategui;
   TextArea sorted;
   TextArea unsorted;
   
   public FileMenuHandler (DateGUI dg, TextArea s, TextArea us) { // constructor
      dategui = dg;
      sorted = s;
      unsorted = us;
   }
   
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      // if open is clicked, it will open a file menu
      if (menuName.equals("Open"))
         openFile(dategui);
      else if (menuName.equals("Quit"))
         // if quit is clicked, the program will end
          System.exit(0); 
      
   } //actionPerformed
   
   public void openFile(DateGUI dg) {
      JFileChooser chooser = new JFileChooser();
      chooser.showOpenDialog(null);
      String filename = (chooser.getSelectedFile()).getName();
      // it will read the chosen file and send it to print it onto the gui
      DateGUI.printFileToGUI(readFile(filename), dg, sorted, unsorted);    
   }
   
   public static String[] readFile(String filename) {
      // method will read an inputed file and use the
      // StringTokenizer class to read all the dates
      int counter = 0;
      int tokenCounter = 0;
      TextFileInput in = new TextFileInput(filename);
      String line = in.readLine();
      while (line != null) { 
         // counts the amount tokens in file
         StringTokenizer token = new StringTokenizer(line, ",");
         tokenCounter += token.countTokens();
         line = in.readLine();
      } // close while
      
      String[] dates = new String[tokenCounter];
      TextFileInput file = new TextFileInput(filename);
      String line2 = file.readLine();
      
      while (line2 != null) { 
         // takes each token on a given line and puts it in a string array
         StringTokenizer token2 = new StringTokenizer(line2, ",");
         while (token2.hasMoreTokens()) {
            dates[counter++] = token2.nextToken();
         } // close while
         line2 = file.readLine();
      } // close while
      
      return dates;
   } // close readFile
   
}