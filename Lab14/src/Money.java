
public class Money {
   private int dollars;
   private int cents;
   
   public Money() {
      dollars = 0;
      cents = 0;
   }
   
   public Money(int d, int c) {
      dollars = d;
      cents = c;
      while (cents > 100) {
         dollars++;
         cents = cents - 100;
      }
   }
   
   public int getDollars() {
      return dollars;
   }
   public int getCents() {
      return cents;
   }
   public void setDollars(int d) {
      dollars = d;
   }
   public void setCents(int c) {
      cents = c;
      while (cents > 100) {
         dollars++;
         cents = cents - 100;
      }
   }
   
   public String toString() {
      String line = "$" + dollars + ".";
      if (cents < 10) line += ("0" + cents);
      else line += cents;
      return line;
   }
   
   public int compareTo(Money other) {
      return toString().compareTo(other.toString());
   }
   
   public boolean equals(Object other) {
      return (other != null &&
              getClass() == other.getClass() &&
              toString().equals(((Money) other).toString()));
   }
   
   public void add(Money m) {
      dollars = dollars + m.dollars;
      cents = cents + m.cents;
      while (cents > 100) {
         dollars++;
         cents = cents - 100;
      }
   }
   
   public static void main(String[] args) {
      Money m1, m2;
      m1 = new Money(4,87);
      m2 = new Money(5,243);
      m1.add(m2);
      System.out.println(m1.toString());
   }
}
