
/**
 *
 * @author khoai2601
 */
public class BSTree {

    Node root;

    public BSTree() {
        root = null;
    }

    // 1.   boolean isEmpty() -   return true if a tree is empty, return false otherwise.
    public boolean isEmpty() {
        return root == null;
    }
    
    // 2.   void clear() - clear a tree.
    public void clear() {
        this.root = null;
    }
    
    // 3.   Node search(int x) - Search a node having value x. Return a reference to that node if found, return null otherwise.
    public Node search(int x) {
        Node p = root;
        if (p == null) {
            return (null);
        }
        while (p != null) {
            if (p.info == x) {
                break;
            }
            if (x > p.info) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return (p);
    }

    // 4.   void insert(int x) - check if the key x does not exists in a tree then insert new node with value x into the tree.
    public void insert(int x) {
        if (root == null) {
            root = new Node(x);
            return;
        }
        Node f, p;
        p = root;
        f = null;
        while (p != null) {
            if (p.info == x) {
                System.out.println(" The key " + x + " already exists, no insertion");
                return;
            }
            f = p;
            if (x < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x < f.info) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }
    
    // 5.   void breadth() - traverse a tree.
    public void breadth() {
        int sum = 0;
        if (root == null) {
            return;
        }
        MyQueue_Tree queue = new MyQueue_Tree();
        queue.enqueue(root);
        Node p;
        while (!queue.isEmpty()) {
            p = queue.dequeue();
            if (p.left != null) {
                queue.enqueue(p.left);
            }
            if (p.right != null) {
                queue.enqueue(p.right);
            }
            System.out.print(p.info + " ");
        }
    }

    public void visit(Node p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // 6.   void preorder(Node p) - recursive preorder traverse of a tree.
    public void preOrder(Node p) {
        if (p == null) {
            return;
        }
        System.out.print(p.info + " ");
        preOrder(p.left);
        preOrder(p.right);
    }

    // 7.   void inorder(Node p) - recursive inorder traverse of a tree.
    public void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        System.out.print(p.info + " ");
        inOrder(p.right);
    }

    // 8.   void postorder(Node p) - recursive postorder traverse of a tree.
    public void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        System.out.print(p.info + " ");
    }
    
    // 9.   int count() - count and return number of nodes in the tree.
    public int count(Node _root) {
        if (_root == null) {
            return 0;
        }
        return 1 + count(_root.left) + count(_root.right);
    }

    // 10.1. void dele(int x) - delete by merging a node having value x. 
    public void deleteByMerging(int x) {
        root = deleteMerging(root, x);
    }

    Node deleteMerging(Node root, int value) {
        if (root == null) {
            return root;
        }
        if (value < root.info) {
            root.left = deleteMerging(root.left, value);
        } else if (value > root.info) {
            root.right = deleteMerging(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            Node rightmost = search(maxLeft(root.left));
            rightmost.right = root.right;
            root = root.left;
        }
        return root;
    }

    // 10.2. void dele(int x) - delete by copying a node having value x. 
    public void deleteByCopying(int x) {
        root = deleteCopy(root, x);
    }

    Node deleteCopy(Node root, int value) {
        if (root == null) {
            return root;
        }
        if (value < root.info) {
            root.left = deleteCopy(root.left, value);
        } else if (value > root.info) {
            root.right = deleteCopy(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.info = maxLeft(root.left);

            root.left = deleteCopy(root.left, root.info);
        }
        return root;
    }

    int maxLeft(Node _root) {
        int max = _root.info;
        while (_root.right != null) {
            max = _root.right.info;
            _root = _root.right;
        }
        return max;
    }

    // 11. Node min() - find and return the node with minimum value in the tree.  
    public Node min() {
        int min = root.info;
        Node nd = root;
        while (nd.left != null) {
            min = nd.left.info;
            nd = nd.left;
        }
        return search(min);
    }

    // 12. Node max() - find and return the node with maximum value in the tree.  
    public Node max() {
        int max = root.info;
        Node nd = root;
        while (nd.right != null) {
            max = nd.right.info;
            nd = nd.right;
        }
        return search(max);
    }

    // 13. int sum() - return the sum of all values in the tree.  
    public int sum() {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        MyQueue_Tree queue = new MyQueue_Tree();
        queue.enqueue(root);
        Node p;
        while (!queue.isEmpty()) {
            p = queue.dequeue();
            if (p.left != null) {
                queue.enqueue(p.left);
            }
            if (p.right != null) {
                queue.enqueue(p.right);
            }
            sum += p.info;
        }
        return sum;
    }

    // 14. int avg() - return the average of all values in the tree.
    public int avg() {
        return sum() / count(root);
    }

    // 15. The height of a tree is the maximum number of nodes on a path from the root to a leaf node. Write a  function that returns the height of a binary tree.
    public int height_calcu(Node _root) {
        if (_root == null) {
            return 0;
        }
        return 1 + Math.max(height_calcu(_root.left), height_calcu(_root.right));
    }

    public int height() {
        return height_calcu(root);
    }

    // 16. Write a  function to determine whether a given binary tree is AVL or not.
    public void balance(int data[], int first, int last) {
        if (first <= last) {
            int middle = (first + last) / 2;
            insert(data[middle]);
            balance(data, first, middle - 1);
            balance(data, middle + 1, last);
        }
    }

    public void balance(int data[]) {
        balance(data, 0, data.length - 1);
    }

    // 17. Convert array to tree
    public String StringInOrder(Node p) {
        String str = "";
        if (p == null) {
            return str;
        }

        str += StringInOrder(p.left) + " ";
        str += p.info + " ";
        str += StringInOrder(p.right) + " ";
        return str.trim();
    }

    public int[] convertArray(String str) {
        String[] numberStrs = str.split(" ");
        int[] numbers = new int[numberStrs.length];
        for (int i = 0; i < numberStrs.length; i++) {
            numbers[i] = Integer.parseInt(numberStrs[i]);
        }
        return numbers;
    }

    // 18. Single rotate
    public Node singleRotateLeft(Node a) {
        Node b = a.right;
        a.right = b.left;
        b.left = a;
        return b;
    }

    public Node singleRotateRight(Node a) {
        Node b = a.left;
        a.left = b.right;
        b.right = a;
        return b;
    }

    // 18. Double rotate
    public Node doubleRotateWithLeftChild(Node a) {
        a.right = singleRotateRight(a.right);
        return singleRotateLeft(a);
    }

    public Node doubleRotateWithRightChild(Node a) {
        a.left = singleRotateLeft(a.left);
        return singleRotateRight(a);
    }

}
