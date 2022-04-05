
/**
 *
 * @author khoai2601
 */
public class main {
    public static void main(String[] args) throws Exception {
        MyQueue mq = new MyQueue();
        
        mq.enqueue(20);
        mq.enqueue(50);
        mq.enqueue(100);

        mq.clear();
        
        System.out.println(mq.convertBase(0.453f));
        
        mq.traverse();
        
        
    }
}
