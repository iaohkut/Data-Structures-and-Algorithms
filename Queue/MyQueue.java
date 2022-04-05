
/**
 *
 * @author khoai2601
 */
public class MyQueue {

    Node head, tail;

    MyQueue() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void enqueue(int x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    int dequeue() throws Exception {
        Node p = new Node();
        if (isEmpty()) {
            throw new Exception();
        }
        p = head;
        head = head.next;
        return p.info;
    }

    int first() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return head.info;
    }

    void traverse() {
        Node nd = head;
        while (nd != null) {
            System.out.print(nd.info + "\t");
            nd = nd.next;
        }
        System.out.println("");
    }

    void clear() throws Exception {
        while (!isEmpty()) {
            dequeue();
        }
    }

    String convertBase(float n) {
        float remain = n * 2;
        float check;
        while (remain != 0) {
            int bit = (int) remain;
            remain = remain - bit;
            remain *= 2;
            this.enqueue(bit);
        }
        
        Node current = head;
        String result = "";
        while(current != null){
            result += String.valueOf(current.info);
            current = current.next;
        }
        return result;
    }
}
