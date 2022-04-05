package Trees_OOP;



/**
 *
 * @author khoai2601
 */
public class Node {

    Person info;
    Node left, right;
    Node next;

    public Node() {
    }
    
    Node(Person x) {
        info = x;
        left = right = null;
    }

}
