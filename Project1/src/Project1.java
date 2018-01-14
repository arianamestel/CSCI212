import java.util.StringTokenizer;

public class Project1 {
   static DateGUI myGUI;
   
   public static void main(String[] args) {
      DateGUI.printDatesToGUI(myGUI, readFile(args[0]));
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
   
   
} // close project1
