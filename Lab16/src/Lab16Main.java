public class Lab16Main {

    public static void main(String[] args) {

        String[] dataSource = { "cat", "bat", "rat", "sat", "hat", "fat" };
        // generate empty lists
        LinkedList myList1 = new LinkedList();
        LinkedList myList2 = new LinkedList();
        LinkedList myList3 = new LinkedList();
        LinkedList myList4 = new LinkedList();
        LinkedList myList5 = new LinkedList();
        LinkedList myList6 = new LinkedList();

        // print out the empty lists
        System.out.println("Here is myList1: " + myList1);
        System.out.println("Here is myList2: " + myList2);
        System.out.println("Here is myList3: " + myList3);
        System.out.println("Here is myList4: " + myList4);
        System.out.println("Here is myList5: " + myList5);
        System.out.println("Here is myList6: " + myList6);

        // fill list 1 and list 2 using append and print it.
        for (int i = 0; i < dataSource.length; i++) {
            myList1.append(dataSource[i]);
            myList2.append(dataSource[i]);
        }
        System.out.println("Here is myList1: " + myList1);
        System.out.println("Here is myList2: " + myList2);
        System.out.println("myList1 equal myList2: " + myList1.equals(myList2));
        
        // fill list 3 and list 4 using preprend and print it
        for (int i = 0; i < dataSource.length; i++) {
            myList3.prepend(dataSource[i]);
            myList4.prepend(dataSource[i]);
        }
        System.out.println("Here is myList3: " + myList3);
        System.out.println("Here is myList4: " + myList4);
        System.out.println("myList3 equal myList4: " + myList3.equals(myList4));

        // fill list 5 and list 6 using append and preprend to create
        // a palindrome
        for (int i = 0; i < dataSource.length; i++) {
            myList5.append(dataSource[i]);
            myList5.prepend(dataSource[i]);
            myList6.append(dataSource[i]);
            myList6.prepend(dataSource[i]);
        }
        System.out.println("Here is myList5: " + myList5);
        System.out.println("Here is myList6: " + myList6);
        System.out.println("myList5 equal myList6: " + myList5.equals(myList6));
        
        System.out.println("myList1 equal myList3: " + myList1.equals(myList3));
    }
}