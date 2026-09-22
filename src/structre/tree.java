package structre;
import java.util.*;
public class tree{
public static void main(String[] args) {
TreeMap tree = new TreeMap();
String key = null, value = null;
System.out.println("Adding three keys and values into the tree.");
for(int i=0; i<3; i++){
if (i==0) { key ="345"; value="Bob"; }
if (i==1) { key ="123"; value="Mary"; }
if (i==2) { key="999"; value="Sue"; }
if (!tree.containsKey(key)) {
System.out.println("Adding node - key: " + key + " value: " + value);
tree.put(key, value);
}
else System.out.println("Generated duplicate key: " + key);
}
System.out.println("\n In order traversal of tree:");
displayInOrder(tree);
System.out.println("\nSize of tree before removing nodes: " + tree.size());
System.out.println("\nRetrieving a value from the tree:");
value = (String)tree.get("123");
if(value != null)
System.out.println("Found key: " + key + " value: " + value);
System.out.println("\nRemoving a node from the tree:");
if(tree.containsKey("123")){
System.out.println("Removing key: " + key);
tree.remove("123");
}
System.out.println("\n In order traversal of tree:");
displayInOrder(tree);
System.out.println("\nSize of tree after removing nodes: " + tree.size());
} //end main
private static void displayInOrder(TreeMap tree) {
Set keys = tree.keySet();
Iterator ii = keys.iterator();
while(ii.hasNext()) {
String key = (String)ii.next();
String value = (String)tree.get(key);
System.out.println("key: " + key + "\tvalue: " + value);
}
}
}