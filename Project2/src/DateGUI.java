import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DateGUI extends JFrame{
   
   public static DateGUI initiateGUI(DateGUI myGUI) {
      // initiate an empty gui with a menu bar that will let the user
      // choose a file to read dates from
      myGUI = new DateGUI();
      myGUI.setSize(400, 400);
      myGUI.setLocation(100, 100);
      myGUI.setLayout(new GridLayout(1, 2));
      myGUI.setTitle("Dates");
      myGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
      Container myContentPane = myGUI.getContentPane();
      TextArea sorted = new TextArea();
      TextArea unsorted = new TextArea();
      myContentPane.add(sorted);
      myContentPane.add(unsorted);
      sorted.append("Sorted Dates:" +"\n\n");
      unsorted.append("Unsorted Dates:" + "\n\n");
      
      JMenuBar menuBar = new JMenuBar();
      // createFileMenuBar will pass the sorted and unsorted text areas so it
      // can append the values once a file is picked
      myGUI.createFileMenuBar(menuBar, sorted, unsorted);
       
      myGUI.setVisible(true);
      return myGUI;
   }
   
   public void createFileMenuBar(JMenuBar menuBar, TextArea sorted, TextArea unsorted) {
      // creates a file menuBar
      JMenuItem item1;
      JMenu fileMenu = new JMenu("File");
      
      // FileMenuHandler will pass the sorted and unsorted text areas so it
      // can append the values once a file is picked
      FileMenuHandler fmh = new FileMenuHandler(this, sorted, unsorted);
      item1 = new JMenuItem("Open");
      item1.addActionListener(fmh);
      fileMenu.add(item1);
      fileMenu.addSeparator();
      JMenuItem item2 = new JMenuItem("Quit");
      item2.addActionListener(fmh);
      fileMenu.add(item2);
      
      setJMenuBar(menuBar);
      menuBar.add(fileMenu);
   }
   
   

   
   
   public static void printFileToGUI(String[] list, DateGUI dg, TextArea sorted, TextArea unsorted) {
    // goes through a list of dates and will add them to sorted and unsorted linked lists
    SortedDateList mySortedDateList = new SortedDateList();
    UnsortedDateList myUnsortedDateList = new UnsortedDateList();
    for (int i = 0; i < list.length; i++) {
       mySortedDateList.add(new Date212(list[i]));
       myUnsortedDateList.add(new Date212(list[i]));  
    }
    // appends the linked list onto the sorted textarea on the gui
    DateNode pointer1 = mySortedDateList.first.next;
    while (pointer1 != null) {
       sorted.append((pointer1.data).toString(pointer1.data) + "\n");
       pointer1 = pointer1.next;
    }
 // appends the linked list onto the unsorted textarea on the gui
    DateNode pointer2 = myUnsortedDateList.first.next;
    while (pointer2 != null) {
       unsorted.append((pointer2.data).toString(pointer2.data) + "\n");
       pointer2 = pointer2.next;
    }
   }
   
   

   
}
