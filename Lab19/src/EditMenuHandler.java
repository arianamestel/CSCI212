import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class EditMenuHandler implements ActionListener {
   JFrame jframe;
   public EditMenuHandler(JFrame jf) {
      jframe = jf;
   }
   
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      if (menuName.equals("Find")) 
         JOptionPane.showMessageDialog(null, "You clicked Find");
      else if (menuName.equals("Replace")) 
         JOptionPane.showMessageDialog(null, "You clicked Replace");
   }
}
