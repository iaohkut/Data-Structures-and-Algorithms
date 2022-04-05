

import java.util.LinkedList;

/**
 *
 * @author khoai2601
 */
public class Queue {

    LinkedList<Integer> t;

    Queue() {
        t = new LinkedList<Integer>();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void clear() {
        t.clear();
    }

    void enqueue(int x) {
        t.addLast(x);
    }

    Integer dequeue() {
        if (isEmpty()) {
            return (null);
        }
        return (t.removeFirst());
    }

    Integer front() {
        if (isEmpty()) {
            return (null);
        }
        return (t.getFirst());
    }
}
