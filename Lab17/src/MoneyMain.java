
public class MoneyMain {
   
   static String[] dataSource =  {"B5", "Q", "Q", "B20", "Q", "D", "N", "P", "Q", "D", "N"};
   static Money[] wallet = new Money[dataSource.length];
   
   public static void main (String[] args) {
            
      for (int i=0;i<dataSource.length;i++){
         char dataItem = dataSource[i].charAt(0);
         if (dataItem == 'B') {
            int billValue= Integer.parseInt(dataSource[i].substring(1,dataSource[i].length()));
            wallet[i]= new Bill(billValue);
         }   
         else if (dataItem == 'Q')
               wallet[i]=new Quarter();
         else if (dataItem == 'P')
            wallet[i] = new Penny();
         else if (dataItem == 'D') 
            wallet[i] = new Dime();
         else if (dataItem == 'N') 
            wallet[i] = new Nickle();
         
         }
      printWallet();
      System.out.println(sumWallet());
   }
   public static void printWallet () {
      for (int i=0;i<wallet.length;i++)
            System.out.println(wallet[i]);
   }
   
   public static String sumWallet() {
      int dollars = 0;
      int cents = 0;
      String sum;
      for (int i = 0; i < wallet.length; i++) {
         if (wallet[i] instanceof Bill) {
            dollars += ((Bill) wallet[i]).getValue();
         }
         else {
            cents += ((Coin) wallet[i]).getValue();
            while (cents > 100) {
               cents -= 100;
               dollars++;
            }
         }
      }
      if (cents < 10) sum = ("$ " + dollars + ".0" + cents);
      else sum = ("$ " + dollars + "." + cents);
      return sum;
   }
}