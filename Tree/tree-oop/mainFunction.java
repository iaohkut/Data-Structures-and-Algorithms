package Trees_OOP;

/**
 *
 * @author khoai2601
 */
public class mainFunction {

    public static void main(String[] args) {
        BSTree tree = new BSTree();
        tree.readFile("person.txt");
        
        tree.inOrder(tree.root);
        System.out.println("");
        System.out.println("===============================");
    }

//    public static void main(String[] args) {
//        BSTree tree = new BSTree();
////        int[] numbers = {7, 4, 8, 1, 3, 9, 2, 5};
//        
//        tree.insert(new Person("7", 28));
//        tree.insert(new Person("4", 28));
//        tree.insert(new Person("8", 28));
//        tree.insert(new Person("1", 28));
//        tree.insert(new Person("3", 28));
//        tree.insert(new Person("9", 28));
//        tree.insert(new Person("2", 28));
//        tree.insert(new Person("5", 28));
//        tree.insert(new Person("8", 20));
//        
//        tree.breadth();
//        System.out.println("");
//        System.out.println("===============================");
//        
////        Person per_tmp = new Person("4", 28);       
////        tree.deleteByMerging(per_tmp);
////        tree.breadth();
////        System.out.println("");
////        System.out.println("===============================");
//
//        System.out.println("Count = " + tree.count(tree.root));
//        System.out.println("Height = " + tree.height());
//
//    }
}
