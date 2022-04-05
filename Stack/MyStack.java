package LinkedList;

import java.util.EmptyStackException;

/**
 *
 * @author khoai2601
 */
public class MyStack {

    Node head, tail;

    MyStack() {
        head = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void push(int x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    void traverse() {
        Node nd = head;
        while (nd != null) {
            System.out.print(nd.info + "\t");
            nd = nd.next;
        }
        System.out.println("");
    }

    int pop() throws EmptyStackException {
        Node p = new Node();
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        p = head;
        head = head.next;
        return p.info;
    }

    int top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return head.info;
    }

    void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    int convertBase(int n) {
        while (n != 0) {
            int check = n % 2;
            n /= 2;
            this.push(check);
        }
        Node current = head;
        String result = "";
        while(current != null){
            result += String.valueOf(current.info);
            current = current.next;
        }
        return Integer.parseInt(result);
    }

}
