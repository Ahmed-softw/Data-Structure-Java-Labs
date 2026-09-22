package datast;

class Node { /////// Implementation of Singly Linked List
public int info;
public String name;
public double cgpa;
public Node next;
public Node previous;
public Node() { }
public Node(int i, String nm, double g) {
info = i; name=nm; cgpa=g;
}
} //////////////////////////////////////////////
class mySLList {
protected Node head, tail;
public mySLList() { head = tail = null; }
public boolean isEmpty() { return head == null; }
public void addToHead(int el, String nm, double g) {
Node newNode = new Node(el, nm, g);
if (head == null) // empty
tail = head = newNode;
else {
newNode.next = head;
head = newNode;
}
} ////////////////////////////////////
public void addToTail(int el, String nm, double g) {
Node newNode = new Node(el, nm, g);
newNode.next = null;
if (head == null) // empty
head = tail = newNode;
else {
tail.next = newNode;
tail = newNode;
}
}
public boolean addBefore(int el, String nm, double g, int target) {
if (head.info == target) { //target is 1st node, add before it
Node newNode = new Node(el, nm, g);
newNode.next = head;
head = newNode;
}
else { // find the predecessor of target
Node tmp = head;
while (tmp.next != null && tmp.next.info != target)
tmp = tmp.next; // check next node
if (tmp.next == null) { // not present
System.out.println("Target not found");
return false;
}
else { //tmp is before target
Node newNode = new Node(el, nm, g);
newNode.next = tmp.next;
tmp.next = newNode;
}
}
return true;
} ////////////////////////////////////
public int deleteFromHead() { // delete head and return info;
if(head == null) // empty
return -1;
int el = head.info;
if (head == tail) // if only one node on the list;
head = tail = null;
else head = head.next;
return el;
} ////////////////////////////////////
public int deleteFromTail() { // delete tail and return info;
if(head == null) // empty
return -1;
int el = tail.info;
if (head == tail) // if only one node on the list;
head = tail = null;
else { // if many nodes, find predecessor of tail
Node tmp = head;
while (tmp.next != tail)
tmp = tmp.next;
tail = tmp; // predecessor of tail becomes tail
tail.next = null;
}
return el;
} ////////////////////////////////////
public boolean delete(int el) { // delete target node with el;
if (head == null) //empty
return false;
if (head == tail && el == head.info) // one node, target
head = tail = null;
else if (el == head.info) // if more nodes, target is head
head = head.next;
else { // if many nodes in the list, el not head
Node prev = head, tmp = head.next;
while ( tmp != null && tmp.info != el) {
	prev = prev.next;
	tmp = tmp.next;
	}
	if (tmp != null) { // if el was found;
	prev.next = tmp.next;
	if (tmp == tail) // if el is in last node;
	tail = prev;
	}
	else return false;
	}
	return true;
	} ////////////////////////////////////
	public void printAll() {
	for (Node tmp = head; tmp != null; tmp = tmp.next)
	System.out.print(tmp.info + " " + tmp.name + " "+
	tmp.cgpa + " -> ");
	System.out.println("null");
	} ////////////////////////////////////
	public boolean isInList(int el) {
	Node tmp = head;
	while (tmp != null && tmp.info != el)
	tmp = tmp.next;
	return tmp != null;
	} ////////////////////////////////////
	}
	///////////////////////////////////////////////
	public class SinglyLinkedList {
	public static void main(String[] args) {
	mySLList L1 = new mySLList();
	System.out.println("Empty ? " + L1.isEmpty());
	L1.addToTail(2019, "Zain", 2.50);
	L1.addToHead(2020, "Ahmed", 2.75);
	L1.addToTail(2022, "Majid", 2.95);
	L1.addToHead(2021, "Khalid", 2.90);
	L1.printAll();
	int x=2020;
	System.out.println("Found "+ x + " " + L1.isInList(x));
	System.out.println("addBefore " + x);
	L1.addBefore(2023, "Hamid", 2.00, x);
	L1.printAll();
	System.out.println("Delete from tail");
	L1.deleteFromTail();
	L1.printAll();
	System.out.println("Delete " + x);
	L1.delete(x);
	L1.printAll();
	}
	}

 ////////////////////////////////////