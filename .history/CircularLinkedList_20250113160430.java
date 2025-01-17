class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    Node head;
    Node tail;
    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }
    // Insert at the end (O(1))
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = head; // Circular connection
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Maintain circular connection
        }
    }

    // Insert at the beginning (O(1))
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = head; // Circular connection
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head; // Maintain circular connection
        }
    }

    // Delete the first node (O(1))
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) {
            head = tail = null; // Only one node case
        } else {
            head = head.next;
            tail.next = head; // Maintain circular connection
        }
    }

    // Delete the last node (O(n))
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) {
            head = tail = null; // Only one node case
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = head; // Maintain circular connection
            tail = temp;
        }
    }

    // Display the list (O(n))
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Back to head)");
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insertAtBeginning(5);

        System.out.println("List after insertions:");
        list.display(); // Expected output: 5 -> 10 -> 20 -> 30 -> (Back to head)

        list.deleteFirst();
        list.deleteLast();
        System.out.println("List after deletions:");
        list.display(); // Expected output: 10 -> 20 -> (Back to head)
    }
}
