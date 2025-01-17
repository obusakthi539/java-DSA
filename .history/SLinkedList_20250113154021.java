class Node {
    int data;
    Node next;

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SLinkedList {
    Node head;
    Node tail;

    // Constructor to initialize an empty list
    public SLinkedList() {
        this.head = null;
        this.tail = null;
    }
    // Insert a node at the end (O(1) if tail is maintained)
    public void insert(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode; // If list is empty, head and tail both point to the new node
        } else {
            tail.next = newNode;  // Link the last node to the new node
            tail = newNode;       // Update tail to the new node
        }
    }

    // Insert a node at the beginning (O(1))
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode; // If list is empty, head and tail both point to the new node
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Insert after a specific value (O(n))
    public void insertAfter(int target, int data) {
        Node targetNode = findNode(target);
        if (targetNode == null) {
            System.out.println("Node with value " + target + " not found.");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = targetNode.next;
        targetNode.next = newNode;
        if (newNode.next == null) {
            tail = newNode;  // Update tail if the new node is inserted at the end
        }
    }

    // Insert before a specific value (O(n))
    public void insertBefore(int target, int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data == target) {
            insertAtBeginning(data);
            return;
        }
        Node prev = null;
        Node temp = head;
        while (temp != null && temp.data != target) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Node with value " + target + " not found.");
            return;
        }
        Node newNode = new Node(data);
        prev.next = newNode;
        newNode.next = temp;
    }

    // Delete the first node (O(1))
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null; // If the list becomes empty, update tail as well
        }
    }

    // Delete the last node (O(n))
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = tail = null; // If there’s only one node, set both head and tail to null
            return;
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp; // Update tail to the second-last node
    }

    // Delete a node at a specific position (O(n))
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (position == 0) {
            deleteFirst();
            return;
        }
        Node temp = head;
        int currentPosition = 0;
        while (temp != null && currentPosition < position - 1) {
            temp = temp.next;
            currentPosition++;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Invalid position.");
            return;
        }
        temp.next = temp.next.next;
        if (temp.next == null) {
            tail = temp; // If the last node is deleted, update tail
        }
    }

    // Display the list (O(n))
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Helper method to find a node (O(n))
    private Node findNode(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return temp;
            }
            temp = temp.next;
        }
        return null;  // Return null if the node is not found
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insertAtBeginning(5);
        list.insertAfter(20, 25);
        list.insertBefore(30, 15);
        list.display(); // Expected output: 5 -> 10 -> 20 -> 25 -> 15 -> 30 -> NULL
        System.out.println("--------------");
        list.deleteFirst();
        list.deleteLast();
        list.deleteAtPosition(2);
        list.display(); // Expected output: 10 -> 20 -> 25 -> NULL
    }
}
