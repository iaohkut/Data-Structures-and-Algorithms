package Recursion_PE;

/**
 *
 * @author khoai2601
 */
public class main {
    public static void main(String[] args) {
        MyRecursion mr = new MyRecursion();
        int arr[] = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println(mr.binarySearch(arr, arr.length, 236));
    }
}
