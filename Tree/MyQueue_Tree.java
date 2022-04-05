
import java.util.*;


/**
 *
 * @author khoai2601
 */
public class MyQueue_Tree {

    LinkedList<Node> list;

    MyQueue_Tree() {
        list = new LinkedList<Node>();
    }
    
    void clear(){
        list.clear();
    }

    boolean isEmpty() {
        return (list.isEmpty());
    }

    void enqueue(Node p) {
        list.addLast(p);
    }

    Node dequeue(){
        if (isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }
    
    Node front(){
        if (isEmpty()) {
            return null;
        }
        return list.getFirst();
    }
}
