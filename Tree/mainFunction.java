
/**
 *
 * @author khoai2601
 */
public class mainFunction {

    public static void main(String[] args) {
        BSTree tree = new BSTree();
        int[] numbers_main = {10, 7, 15, 4, 8, 13, 20, 1, 3, 9, 18, 25, 14, 2};
        int[] numbers_balance = {2, 1, 3, 4, 5, 6, 7};
        int[] numbers_singleRotate = {8, 6, 9, 2, 7, 1, 3, 5, 4};
        int[] numbers_doubleRotate = {20, 15, 30, 25, 35, 23, 27};
        for (int number : numbers_singleRotate) {
            tree.insert(number);
        }

        System.out.println("Height = " + tree.height());
        tree.breadth();
        System.out.println("");
        System.out.println("===============================");

        int[] array_tree = tree.convertArray(tree.StringInOrder(tree.root));
        
        tree.clear();
        
        tree.balance(array_tree);
        System.out.println("Height = " + tree.height());
        tree.inOrder(tree.root);
        System.out.println("");
        tree.root.left = tree.singleRotateRight(tree.root.left);
        tree.root = tree.doubleRotateWithLeftChild(tree.root);

        System.out.println("Height = " + tree.height());
        tree.breadth();
        System.out.println("");

    }

}
