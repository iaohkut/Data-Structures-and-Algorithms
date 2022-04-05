
/**
 *
 * @author khoai2601
 */
public class Node {

    int info;
    Node next;

    public Node() {
    }

    public Node(int x, Node p) {
        info = x;
        next = p;
    }

    public Node(int x) {
        this(x, null);
    }

}
