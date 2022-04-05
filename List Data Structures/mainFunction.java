package Singly_LinkedList;


/**
 *
 * @author khoai2601
 */
public class mainFunction {

    public static void main(String[] args) {
        MyList ml1 = new MyList();
        MyList ml2 = new MyList();
        
        ml1.addLast(3);
        ml1.addLast(10);
        ml1.addLast(15);
        

        ml2.addLast(2);
        ml2.addLast(3);
        ml2.addLast(20);


        MyList ml3 = ml1.mergeList(ml2);
        ml3.traverse();
    }
}
