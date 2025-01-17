class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Insert at the end (O(1))
    public void insert(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode; // Empty list case
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Insert at the beginning (O(1))
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode; // Empty list case
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Delete the first node (O(1))
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = tail = null; // Only one node case
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Delete the last node (O(1))
    public void deleteLast() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        if (tail.prev == null) {
            head = tail = null; // Only one node case
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Display the list from start to end (O(n))
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insertAtBeginning(5);

        System.out.println("List after insertions:");
        list.display(); // Expected output: 5 <-> 10 <-> 20 <-> 30 <-> NULL

        list.deleteFirst();
        list.deleteLast();
        System.out.println("List after deletions:");
        list.display(); // Expected output: 10 <-> 20 <-> NULL
    }
}
