package Singly_LinkedList;

/**
 *
 * @author khoai2601
 */
public class Node {
    int info;

    public Node() {
    }
    
    Node next;

    public Node(int info) {
        this.info = info;
    }
    
    public Node(int x, Node p) {
        this.info = x;
        this.next = p;
    }
    
    
}
