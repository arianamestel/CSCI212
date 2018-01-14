
public class SortedDateList extends DateList {
   
   public SortedDateList() {
      // uses the constructor from the super class
      super();
   }
   
   public void add(Date212 d) {
      DateNode current = first;
      DateNode pointer = first.next;
      DateNode date = new DateNode(d);
      
      if (length == 0) {
         // if there is nothing in the linked list, just append
         append(d);
         return;
      }
      else if (Integer.parseInt(d.getDate212()) >= Integer.parseInt((last.data).getDate212())) {
         // if d is the the biggest date so far, just append
         append(d);
      }
      else {
         while (Integer.parseInt(d.getDate212()) >= Integer.parseInt((pointer.data).getDate212())) {
            //while d is bigger than the pointer, go to the next pointer and move current
            current = pointer;
            pointer = pointer.next;
         }
         // set d to be in between current and pointer
         current.next = date;
         current.next.next = pointer;
         length++;
      }
   }
}
