import java.util.*;

public class TwoDimArray {
    
    public static void main(String[] args) {
        int[][] myArray;
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
       String line = in.readLine();
       StringTokenizer rowCol = new StringTokenizer(line, ",");
       int row = Integer.parseInt(rowCol.nextToken());
       int col = Integer.parseInt(rowCol.nextToken());
       int[][] newArray = new int[row][col];
       for (int r = 0; r < row; r++) {
          line = in.readLine();
          StringTokenizer myTokens = new StringTokenizer(line, ",");
          for (int c = 0; c < col; c++) {
             newArray[r][c] = Integer.parseInt(myTokens.nextToken()); 
          }
       }
       return newArray;
    }
}