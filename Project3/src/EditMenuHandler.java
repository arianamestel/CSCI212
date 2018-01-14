import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class EditMenuHandler implements ActionListener {

   DateGUI dategui;
   TextArea sorted;
   TextArea unsorted;
   
   public EditMenuHandler (DateGUI dg, TextArea s, TextArea us) { // constructor
      dategui = dg;
      sorted = s;
      unsorted = us;
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      String menuName = e.getActionCommand();
      // if insert is clicked it will open a JOption pane that will let the user input a date
      // which will be added to the gui in the sorted and unsorted lists
      if (menuName.equals("Insert")) {
         String s = JOptionPane.showInputDialog(null, "Enter a new date: ");
         Date212 date = new Date212(s);
         DateGUI.printInsertToGUI(date, sorted, unsorted);
      }
   }

}
