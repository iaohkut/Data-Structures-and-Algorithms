package LinkedList;

/**
 *
 * @author khoai2601
 */
public class Node {

    int info;
    Node next;

    public Node() {
    }

    Node(int x, Node p) {
        info = x;
        next = p;
    }

    Node(int x) {
        this.info = x;
        this.next = null;
    }

}
