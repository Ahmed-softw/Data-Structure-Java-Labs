package datast;

// 1. Renamed to MyDLLNode to avoid "already defined" conflict
class MyDLLNode { 
    public int info;
    public String name;
    public double cgpa;
    public MyDLLNode next;
    public MyDLLNode previous;

    public MyDLLNode() { }

    public MyDLLNode(int i, String nm, double g) {
        info = i;
        name = nm;
        cgpa = g;
    }
}

class myDLL {
    protected MyDLLNode head, tail;

    public myDLL() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addToHead(int el, String nm, double g) {
        MyDLLNode newNode = new MyDLLNode(el, nm, g);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode; 
            head = newNode;
        }
    }

    public void addToTail(int el, String nm, double g) {
        MyDLLNode newNode = new MyDLLNode(el, nm, g);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public boolean addBefore(int el, String nm, double g, int target) {
        if (isEmpty()) return false;

        MyDLLNode tmp = head;
        while (tmp != null && tmp.info != target) {
            tmp = tmp.next;
        }

        if (tmp == null) {
            System.out.println("Target not found");
            return false;
        }

        if (tmp == head) {
            addToHead(el, nm, g);
        } else {
            MyDLLNode newNode = new MyDLLNode(el, nm, g);
            newNode.next = tmp;
            newNode.previous = tmp.previous;
            tmp.previous.next = newNode;
            tmp.previous = newNode;
        }
        return true;
    }

    public int deleteFromHead() {
        if (head == null) return -1;
        int el = head.info;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
        return el;
    }

    public int deleteFromTail() {
        if (head == null) return -1;
        int el = tail.info;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        return el;
    }

    public boolean delete(int el) {
        if (head == null) return false;

        MyDLLNode tmp = head;
        while (tmp != null && tmp.info != el) {
            tmp = tmp.next;
        }

        if (tmp == null) return false; 

        if (tmp == head) {
            deleteFromHead();
        } else if (tmp == tail) {
            deleteFromTail();
        } else {
            tmp.previous.next = tmp.next;
            tmp.next.previous = tmp.previous;
        }
        return true;
    }

    public void printAll() {
        System.out.print("null");
        for (MyDLLNode tmp = head; tmp != null; tmp = tmp.next)
            System.out.print(" <- " + tmp.info + " " + tmp.name + " " + tmp.cgpa + " -> ");
        System.out.println("null");
    }

    public void printAllReverse() {
        System.out.print("null");
        for (MyDLLNode tmp = tail; tmp != null; tmp = tmp.previous)
            System.out.print(" <- " + tmp.info + " " + tmp.name + " " + tmp.cgpa + " -> ");
        System.out.println("null");
    }

    public boolean isInList(int el) {
        MyDLLNode tmp = head;
        while (tmp != null && tmp.info != el)
            tmp = tmp.next;
        return tmp != null;
    }
}

public class DoublyLinkedlist {
    public static void main(String[] args) {
        myDLL L1 = new myDLL();
        System.out.println("Empty ? " + L1.isEmpty());
        L1.addToTail(2019, "Zain", 2.50);
        L1.addToHead(2020, "Ahmed", 2.75);
        L1.addToTail(2022, "Majid", 2.95);
        L1.addToHead(2021, "Khalid", 2.90);
        L1.printAll();

        int x = 2020;
        System.out.println("Found " + x + " " + L1.isInList(x));
        System.out.println("addBefore " + x);
        L1.addBefore(2023, "Hamid", 2.00, x);
        L1.printAll();

        System.out.println("Delete from tail");
        L1.deleteFromTail();
        L1.printAll();

        System.out.println("Delete " + x);
        L1.delete(x);
        L1.printAll();

        System.out.println("Print in Reverse ");
        L1.printAllReverse(); 
    }
}
