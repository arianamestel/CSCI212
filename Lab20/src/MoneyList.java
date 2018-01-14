
public class MoneyList {
   private MoneyNode first = new MoneyNode(null);
   private MoneyNode last = first;
   private int length = 0;
   
   public int getLength() {
      return length;
   }
   
   public void append(Money d) {
      MoneyNode n = new MoneyNode(d);
      last.next = n;
      last = n;
      length++;
   }
   
   public void prepend(Money d) {
      MoneyNode n = new MoneyNode(d);
      n.next = first.next;
      first.next = n;
      length++;
   }
   
   public String toString() {
      MoneyNode p = first.next;
      String returnString = "";
      while (p != null) {
          returnString += p.data + " ";
          p = p.next;
      }
      return returnString;
   }
   
   public boolean equals(Object other) {
      if (other == null || getClass() != other.getClass()
              || length != ((MoneyList) other).length)
          return false;

      MoneyNode nodeThis = first;
      MoneyNode nodeOther = ((MoneyList) other).first;
      while (nodeThis != null) {
          // Since the two linked lists are the same length,
          // they should reach null on the same iteration.

          if (nodeThis.data != nodeOther.data)
              return false;

          nodeThis = nodeThis.next;
          nodeOther = nodeOther.next;
      } // while

      return true;
  } // method equals
   
   public String getValue() {
      int dollar = 0, cent = 0;
      MoneyNode cur = this.first.next;
      while(cur != null) {
          if(cur.data instanceof Bill) {
              dollar += ((Bill) cur.data).getValue();
          } else if (cur.data instanceof Coin) {
              cent += ((Coin) cur.data).getValue();
          }
          cur = cur.next;
      }
      dollar += cent / 100;
      cent = cent % 100;
      if (cent < 10) {
          return dollar + ".0" + cent;
      } else {
          return dollar + "." + cent;
      }
  }
}
