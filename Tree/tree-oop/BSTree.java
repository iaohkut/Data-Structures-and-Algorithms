package Trees_OOP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



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
    public Node search(Person x) {
        Node p = root;
        if (p == null) {
            return (null);
        }
        while (p != null) {
            if (p.info.equals(x)) {
                break;
            }
            if (x.getName().compareTo(p.info.getName()) > 0) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return (p);
    }

    // 4.   void insert(int x) - check if the key x does not exists in a tree then insert new node with value x into the tree.
    public void insert(Person x) {
        if (root == null) {
            root = new Node(x);
            return;
        }
        Node f, p;
        p = root;
        f = null;
        while (p != null) {
            if (p.info.equals(x)) {
                System.out.println(" The key '" + x + "' already exists, no insertion");
                return;
            }
            f = p;
            if (x.getName().compareTo(p.info.getName()) > 0) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (x.getName().compareTo(f.info.getName()) < 0) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }
    
    // 5.   void breadth() - traverse a tree.
    public void breadth() {
        if (root == null) {
            return;
        }
        Queue queue = new Queue();
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
            System.out.print(p.info + "   ");
        }
    }

    public void visit(Node p) {
        System.out.println(p.info.toString());
    }

    // 6.   void preorder(Node p) - recursive preorder traverse of a tree.
    public void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    // 7.   void inorder(Node p) - recursive inorder traverse of a tree.
    public void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    // 8.   void postorder(Node p) - recursive postorder traverse of a tree.
    public void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }
    
    // 9.   int count() - count and return number of nodes in the tree.
    public int count(Node _root) {
        if (_root == null) {
            return 0;
        }
        return 1 + count(_root.left) + count(_root.right);
    }
    
    // 10. The height of a tree is the maximum number of nodes on a path from the root to a leaf node. Write a  function that returns the height of a binary tree.
    public int height_calcu(Node _root) {
        if (_root == null) {
            return 0;
        }
        return 1 + Math.max(height_calcu(_root.left), height_calcu(_root.right));
    }

    public int height() {
        return height_calcu(root);
    }

    // 11. void dele(int x) - delete a node having value x. 
    public void deleteByMerging(Person x) {
        root = deleteMerging(root, x);
    }

    Node deleteMerging(Node root, Person value) {
        if (root == null) {
            return root;
        }
        
        if (value.getName().compareTo(root.info.getName()) < 0) {
            root.left = deleteMerging(root.left, value);
        } else if (value.getName().compareTo(root.info.getName()) > 0) {
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

    public void deleteByCopying(Person x) {
        root = deleteCopy(root, x);
    }

    Node deleteCopy(Node root, Person value) {
        if (root == null) {
            return root;
        }
        if (value.getName().compareTo(root.info.getName()) < 0) {
            root.left = deleteCopy(root.left, value);
        } else if (value.getName().compareTo(root.info.getName()) > 0) {
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

    Person maxLeft(Node _root) {
        Person max = _root.info;
        while (_root.right != null) {
            max = _root.right.info;
            _root = _root.right;
        }
        return max;
    }
    
    public void readFile(String fname){
        try {
            File myObj = new File(fname);
            Scanner sc = new Scanner(myObj);
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split("\\|");
                Person person = new Person(data[0].trim(), Integer.parseInt(data[1].trim()));
                insert(person);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

}
