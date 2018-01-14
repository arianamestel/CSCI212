class TwoDimention {
   public static void main (String[] args) {
      for (int r = 0; r < fillArray(args[0]).length; r++) {
        for (int c = 0; c < fillArray(args[0])[r].length; c++) {
          System.out.print(fillArray(args[0])[r][c] + " ");
        }
        System.out.println();
      } 
   } 
   
   public static int[][] fillArray(String filename) {
      String line;
      TextFileInput in = new TextFileInput(filename);
      // the first two lines are the amount of rows 
      // and columns in the array. They are converted 
      // from a string to an integer
      line = in.readLine();
      int row = Integer.parseInt(line);
      line = in.readLine();
      int col = Integer.parseInt(line);
      // set the array to the values read in from the file
      int[][] newArray = new int[row][col];
      // nested for loop to assign each line from the 
      // file to the next space in the array
      for (int r = 0; r < row; r++) {
         for (int c = 0; c < col; c++) {
            line = in.readLine();
            newArray[r][c] = Integer.parseInt(line);
         } // close col loop
      }  // close row loop
      in.close();
      return newArray;
   }  // close method
}  // close class
