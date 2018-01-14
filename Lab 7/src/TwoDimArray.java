public class TwoDimArray {

    public static int[][] myArray = {{1,2,3},{4,5,6},{7,8,9}};
    
    public static void main(String[] args) {
        myArray = readFile(args[0]);
        printArray(myArray);
        printArrayEven(myArray);
    }
    private static void printArray (int[][] theArray) {
        for (int i=0; i<theArray.length; i++) {
            for (int j=0; j<theArray[i].length;j++)
                display(theArray[i][j]);
            System.out.println();
        }
    }
    private static void display (int num){
        System.out.print(num+" ");
    }
    private static void printArrayEven(int[][] theArray){
        for (int r = 0; r < theArray.length; r++) {
           for (int c = 0; c < theArray[r].length; c++) {
              if (theArray[r][c] % 2 == 0) display(theArray[r][c]);
              else System.out.print("* ");
           }
           System.out.println();
        }
    }
    
    public static int[][] readFile(String filename) {
       TextFileInput in = new TextFileInput(filename);
       int row = Integer.parseInt(in.readLine());
       int col = Integer.parseInt(in.readLine());
       int[][] newArray = new int[row][col];
       for (int r = 0; r < row; r++) {
          for (int c = 0; c < col; c++) {
             newArray[r][c] = Integer.parseInt(in.readLine());
          }
       }
       return newArray;
    }
}