package Trees_OOP;

/**
 *
 * @author khoai2601
 */
import java.util.*;

public class Queue {

    LinkedList<Node> t;

    Queue() {
        t = new LinkedList<Node>();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void enqueue(Node p) {
        t.addLast(p);
    }

    Node dequeue() {
        if (isEmpty()) {
            return (null);
        }
        return (t.removeFirst());
    }

    Node front() {
        if (isEmpty()) {
            return (null);
        }
        return (t.getFirst());
    }
}
