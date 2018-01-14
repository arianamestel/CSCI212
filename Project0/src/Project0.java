// Ariana Mestel Lab section: 11b

import javax.swing.*;

class Project0 {
   public static void main(String[] args) {
      // loop that will keep going until the user inputs the word stop
      while (true) {
         String inputSentence;
         inputSentence = JOptionPane.showInputDialog(null, "Please enter a sentence:");
         // if user inputs stop then exit program
         if (inputSentence.equalsIgnoreCase("stop")) System.exit(1);
         int len = inputSentence.length();
         // counter for upper and lower case e
         int lower = 0;
         int upper = 0;
         // goes though the length of the sentence and tests if
         // it is either a lower or upper case e by using the charAt method. 
         // if so then it will add to the appropriate counter
         for (int i = 0; i < len; i++) {
            if (inputSentence.charAt(i) == 'e') lower++;
            if (inputSentence.charAt(i) == 'E') upper++;
         } // close for loop
         // shows message dialog of the results
         JOptionPane.showMessageDialog(null, "Number of lower case e's: " + lower +
                                       "\n" + "Number of upper case e's: " + upper);
      } // close while loop
   } // close main
} // close class
