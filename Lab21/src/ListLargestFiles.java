import java.io.File;

import javax.swing.JFileChooser;
   
   

   public class ListLargestFiles {
      static File largest_file;
      static long largest_file_size = -1;
      
      public static void main(String[] args) {
         JFileChooser fd = new JFileChooser();
//         mode - the type of files to be displayed:
//             * JFileChooser.FILES_ONLY
//             * JFileChooser.DIRECTORIES_ONLY
//             * JFileChooser.FILES_AND_DIRECTORIES 
         fd.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
         fd.showOpenDialog(null);
         File f = fd.getSelectedFile();
         listFiles(f);
         System.err.println("The largest file found was: " + largest_file.getName() + "\nIts size was: " + largest_file_size);

     }
      
      public static void listFiles(File f) {
         File files[] = f.listFiles();
         
         for (int i = 1; i< files.length; i++) {
             
             if (files[i].length() > largest_file_size) {
                largest_file_size = files[i].length();
                largest_file = files[i];
             }
             if (files[i].isDirectory()) listFiles(files[i]);
         }
         
     }
}
