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
      myGUI.createEditMenuBar(menuBar, sorted, unsorted);
       
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
   
   public void createEditMenuBar(JMenuBar menuBar, TextArea sorted, TextArea unsorted) {
      // creates an edit menuBar
      JMenu editMenu = new JMenu("Edit");
      // EditMenuHandler will pass the sorted and unsorted text areas so it
      // can append the value once a date is inserted
      EditMenuHandler emh = new EditMenuHandler(this, sorted, unsorted);
      JMenuItem item1= new JMenuItem("Insert");
      item1.addActionListener(emh);
      editMenu.add(item1);
      setJMenuBar(menuBar);
      menuBar.add(editMenu);
      
   }
   
   
   // create static datelists so the dates in each list will be saved
   static SortedDateList sdl = new SortedDateList();
   static UnsortedDateList udl = new UnsortedDateList();
   
   public static void printFileToGUI(String[] list, DateGUI dg, TextArea sorted, TextArea unsorted) {
    // goes through a list of dates and will add them to sorted and unsorted linked lists
    for (int i = 0; i < list.length; i++) {
       sdl.add(new Date212(list[i]));
       udl.add(new Date212(list[i]));  
    }
    // resets and appends the linked list onto the sorted textarea on the gui
    sorted.setText("Sorted Dates: " + "\n\n");
    DateNode pointer1 = sdl.first.next;
    while (pointer1 != null) {
       sorted.append((pointer1.data).toString(pointer1.data) + "\n");
       pointer1 = pointer1.next;
    }
 // resets and appends the linked list onto the unsorted textarea on the gui
    unsorted.setText("Unsorted Dates: \n\n");
    DateNode pointer2 = udl.first.next;
    while (pointer2 != null) {
       unsorted.append((pointer2.data).toString(pointer2.data) + "\n");
       pointer2 = pointer2.next;
    }
   }
   
   
   public static void printInsertToGUI(Date212 date, TextArea sorted, TextArea unsorted) {
      // will insert a given date and add them to the sorted and unsorted linked lists
      
      // adds the given date to static sorted date list, resets the textarea and appends each date to sorted textarea
      sdl.add(date);
      sorted.setText("Sorted Dates: " + "\n\n");
      DateNode pointer1 = sdl.first.next;
      while (pointer1 != null) {
         sorted.append((pointer1.data).toString(pointer1.data) + "\n");
         pointer1 = pointer1.next;
      }
      
      // adds the given date to static unsorted date list, resets the textarea and appends each date to unsorted textarea 
      udl.add(date);
      unsorted.setText("Sorted Dates: " + "\n\n");
      DateNode pointer2 = udl.first.next;
      while (pointer2 != null) {
         unsorted.append((pointer2.data).toString(pointer2.data) + "\n");
         pointer2 = pointer2.next;
      }
     
   }
   
   

   
}
