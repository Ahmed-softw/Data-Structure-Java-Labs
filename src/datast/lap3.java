package datast;
import java.io.*;
import java.util.*;
public class lap3 {
public static void main(String[] ar) {
ArrayList list1 = new ArrayList();
list1.add(new Integer(4));
list1.add(new Integer(5));
list1.add(new Integer(6));
list1.add(new Integer(4));
ArrayList list2 = new ArrayList(4);
list2.add(new Integer(3));
list2.add(new Integer(4));
list2.add(new Character('a'));
list2.add(new Double(1.1));
System.out.println(list1);
System.out.println(list2);
list1.removeAll(list2);
// difference: [4, 5, 6, 4] , [3, 4, a, 1.1] ==> [5, 6]
System.out.println(list1);
list1.add(0,new Integer(4));
list1.add(new Integer(4));
list1.retainAll(list2);
// intersection: [4, 5, 6, 4] , [3, 4, a, 1.1] ==> [4, 4]
System.out.println(list1);
list1.add(1,new Integer(5));
list1.add(2,new Integer(6));
list1.addAll(list2);
// union: [4, 5, 6, 4], [3, 4, a, 1.1]==>

System.out.println(list1);
List list3 = list1.subList(2,5);
System.out.println(list3); // [6, 4, 3]
list1.set(3,new Integer(10)); // update list1 and list3
System.out.println(list1); // [4, 5, 6, 10, 3, 4, a, 1.1]
System.out.println(list3); // [6, 10, 3]
list3.clear();
System.out.println(list1); // [4, 5, 4, a, 1.1]
System.out.println(list3); // []
}
}