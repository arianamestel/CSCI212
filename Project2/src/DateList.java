
public abstract class  DateList {
   
   protected DateNode first = new DateNode(null);
   protected DateNode last = first;
   protected int length = 0;
   
   public DateList() {
     
   }
   
   public int getLength() {
      // returns length of DateList
      return length;
   }
   
   public void append(Date212 d) {
      // adds a DateNode to the end of the DateLists
      DateNode n = new DateNode(d);
      last.next = n;
      last = n;
      n.next = null;
      length++;
   }
   
}
