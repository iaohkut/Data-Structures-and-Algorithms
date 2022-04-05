package LinkedList;



/**
 *
 * @author khoai2601
 */
public class main {

    public static void main(String[] args) {
        MyStack llist = new MyStack();
        llist.push(5);
        llist.push(10);
        llist.push(15);
        
        llist.pop();
        llist.pop();
        llist.pop();
        llist.pop();
        llist.traverse();
    }

}
