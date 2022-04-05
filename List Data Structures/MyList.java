package Singly_LinkedList;

/**
 *
 * @author khoai2601
 */
public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

//1.   void addToHead(int x) - add a node with value x  at the head of  a list.
    void addFirst(int x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

//2.   void addToTail(int x) - add a node with value x  at the tail of  a list.
    void addLast(int x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

//3.   void addAfter(Node p, int x) - add a node with value x  after the node p.
    void addAfter(Node p, int x) {
        Node aA = new Node(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            aA.next = p.next;
            p.next = aA;
        }
    }

//16. void addBefore(Node p, int x) - add a node with value x  before the node p.
    void addBefore(Node p, int x) {
        Node aA = new Node(x);
        Node tmp1 = null;
        Node tmp2 = head;
        if (isEmpty()) {
            head = tail = p;
        } else {
            if (p == head) {
                addFirst(x);
            } else {
                while (tmp2 != p) {
                    tmp1 = tmp2;
                    tmp2 = tmp2.next;
                }
                tmp1.next = aA;
                aA.next = tmp2;
            }

        }
    }

//4.   void traverse() - traverse from head to tail and dislay info of all nodes in the list.
    void traverse() {
        Node nd = head;
        while (nd != null) {
            System.out.print(nd.info + "\t");
            nd = nd.next;
        }
        System.out.println("");
    }

//5.   int deleteFromHead() - delete the head and return its info.
    int deleteFromHead() {
        Node p = new Node();
        if (isEmpty()) {
            System.out.println("List null");
        } else {
            p = head;
            head = head.next;
        }
        return p.info;
    }

//6.   int deleteFromTail() - delete the tail and return its info.
    int deleteFromTail() {
        Node p = null;
        Node tmp = head;
        if (isEmpty()) {
            System.out.println("List null");
        } else {
            if (head == tail) {
                head = tail = null;
            } else {
                while (tmp != tail) {
                    p = tmp;
                    tmp = tmp.next;
                }
                p.next = null;
                tail = p;
            }

        }
        return tmp.info;
    }

//7.   int deleteAter(Node p) - delete the node after the node  p  and return its info.
    int deleteAfter(Node p) {
        Node tmp = null;
        if (isEmpty()) {
            System.out.println("List null");
        } else {
            tmp = p.next;
            p.next = p.next.next;
        }
        return tmp.info;
    }

//8.   void dele(int x) - delele the first node whose info is equal to  x.
    void deleInfo(int x) {
        Node current = head;
        Node previous = null;
        if (!isEmpty()) {
            if (search(x) != null) {
                if (head.info == x) {
                    deleteFromHead();
                    return;
                }
                while (current != null) {
                    if (current.info == x) {
                        previous.next = current.next;
                    }
                    previous = current;
                    current = current.next;
                }
            }
        }
    }

//9.   Node search(int x) - search and return the reference to the first node having info x.
    Node search(int x) {
        Node nd = head;
        boolean flag = false;
        if (isEmpty()) {
            System.out.println("List null");
        } else {
            while (nd != null) {
                if (nd.info == x) {
                    flag = true;
                    break;
                }
                nd = nd.next;
            }
        }
        if (flag) {
            return nd;
        }
        return null;
    }

//10. int count() - count and return number of nodes in the list.
    int count() {
        int count = 0;
        if (isEmpty()) {
            count = 0;
        } else {
            Node nd = head;
            while (nd != null) {
                count++;
                nd = nd.next;
            }
        }
        return count;
    }

//13. void dele(Node p) - delete node p if it exists in the list.
    void dele(Node p) {
        Node current = head;
        Node previous = null;
        if (!isEmpty()) {
            if (search(p.info) == null) {
                System.out.println("This node isn't exsits!!!");
            } else {
                if (head == p) {
                    deleteFromHead();
                    return;
                }
                while (current != null) {
                    if (current == p) {
                        previous.next = current.next;
                    }
                    previous = current;
                    current = current.next;
                }
            }
        }
    }

//11. void dele(int i) - delete an i-th node on the list. Besure that such a node exists.
    void deleIndex(int i) {
        if (isEmpty()) {
            System.out.println("List null");
            return;
        }
        if (i > (count() - 1)) {
            System.out.println("List out of range!!!");
            return;
        }
        Node prev = null;
        Node current = head;
        for (int index = 0; index < i; index++) {
            prev = current;
            current = current.next;
        }
        if (current == head) {
            deleteFromHead();
        } else {
            prev.next = current.next;
        }
    }

    void swapNode(int i, int j) {
        Node prev1 = null;
        Node current1 = head;
        for (int index = 0; index < i; index++) {
            prev1 = current1;
            current1 = current1.next;
        }

        Node prev2 = null;
        Node current2 = head;
        for (int index = 0; index < j; index++) {
            prev2 = current2;
            current2 = current2.next;
        }

        int tmp = current1.info;
        current1.info = current2.info;
        current2.info = tmp;
    }

//12. void sort() - sort the list by ascending order of info.
    void sort() {
        if (isEmpty()) {
            System.out.println("List null");
            return;
        }
        for (int i = 0; i < count() - 1; i++) {
            Node current = head;
            for (int j = 0; j < count() - i - 1; j++) {
                if (current.info > current.next.info) {
                    swapNode(j, j + 1);
                }
                current = current.next;
            }
        }
    }

//14. int [] toArray() - create and return array containing info of all nodes in the list. 
    int[] toArray() {
        int[] array = new int[count()];
        int count = 0;
        Node current = head;
        for (int index = 0; index < count(); index++) {
            array[count] = current.info;
            count++;
            current = current.next;
        }
        return array;
    }

//15. Merge two ordered singly linked lists of integers into one ordered list.
    Node SortedMerge(Node headA, Node headB) {
        Node current = null;
        if (headA == null) {
            return headB;
        }
        if (headB == null) {
            return headA;
        }
        if (headA.info < headB.info) {
            return headA;
        } else {
            return headB;
        }
    }

    MyList mergeList(MyList list) {
        MyList list_results = new MyList();
        if (this.sorted() && list.sorted()) {
            Node current1 = head;
            Node current2 = list.head;
            while (current1 != null && current2 != null) {
                current1 = head;
                current2 = list.head;
                Node removeNode = SortedMerge(current1, current2);
                list_results.addLast(removeNode.info);
                if (current1 == removeNode) {
                    this.dele(removeNode);
                }
                if (current2 == removeNode) {
                    list.dele(removeNode);
                }
                
            }
        }
        return list_results;
    }

//17. Attach a singly linked list to the end of another singly linked list.
    MyList attack(MyList list) {
        while (list.head != null) {
            this.addLast(list.head.info);
            list.head = list.head.next;
        }
        return this;
    }

//18. int max() - find and return the maximum value in the list. 
    int max() {
        if (isEmpty()) {
            System.out.println("List null");
            return 0;
        }
        Node current = head.next;
        int max = head.info;
        for (int i = 0; i < count() - 1; i++) {
            max = max > current.info ? max : current.info;
            current = current.next;
        }
        return max;
    }

//19. int min() - find and return the minimum value in the list.  
    int min() {
        if (isEmpty()) {
            System.out.println("List null");
            return 0;
        }
        Node current = head.next;
        int min = head.info;
        for (int i = 0; i < count() - 1; i++) {
            min = min < current.info ? min : current.info;
            current = current.next;
        }
        return min;
    }

//20. int sum() - return the sum of all values in the list. 
    int sum() {
        if (isEmpty()) {
            System.out.println("List null");
            return 0;
        }
        Node current = head;
        int sum = 0;
        for (int i = 0; i < count(); i++) {
            sum += current.info;
            current = current.next;
        }
        return sum;
    }

//21. int avg() - return the average of all values in the list.
    float avg() {
        return (float) sum() / count();
    }

//22. boolean sorted() - check and return true if the list is sorted, 
//return false if the list is not sorted.
    boolean sorted() {
        return sorted_ascending() || sorted_descending();
    }

    boolean sorted_descending() {
        if (isEmpty()) {
            System.out.println("List null");
            return true;
        }
        for (Node t = head; t.next != null; t = t.next) {
            if (t.info < t.next.info) {
                return false;
            }
        }
        return true;
    }

    boolean sorted_ascending() {
        if (isEmpty()) {
            System.out.println("List null");
            return true;
        }
        for (Node t = head; t.next != null; t = t.next) {
            if (t.info > t.next.info) {
                return false;
            }
        }
        return true;
    }

//23. void insert(int x) - insert node with value x into sorted list so that the new list is sorted.
    void insert(int x) {
        if (isEmpty()) {
            addFirst(x);
            return;
        }
        if (sorted_ascending()) {
            Node current = head;
            for (int i = 0; i < count(); i++) {
                if (current.info > x) {
                    addBefore(current, x);
                    return;
                }
                current = current.next;
            }
            addLast(x);
        }
        if (sorted_descending()) {
            Node current = head;
            for (int i = 0; i < count(); i++) {
                if (current.info < x) {
                    addBefore(current, x);
                    return;
                }
                current = current.next;
            }
            addLast(x);
        }
    }

//24. Reverse a singly linked list using only one pass through the list.
    void reverse() {
        int count = 0;
        Node move = head;
        while (count < count() - 1) {
            this.addBefore(move, deleteFromTail());
            count++;
        }
    }

//25. Check whether two singly linked list have the same contents.
    boolean compareList(MyList list) {
        if (this.count() != list.count()) {
            return false;
        }
        this.sort();
        list.sort();
        for (int i = 0; i < count(); i++) {
            if (this.head.info != list.head.info) {
                return false;
            }
            this.deleteFromHead();
            list.deleteFromHead();
        }
        return true;
    }
}
