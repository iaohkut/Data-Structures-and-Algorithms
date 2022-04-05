package Recursion_PE;

/**
 *
 * @author khoai2601
 */
public class MyRecursion {

    int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    int findmin(int a[], int n) {
        if (n == 1) {
            return a[0];
        }
        return Math.min(a[n - 1], findmin(a, n - 1));
    }

    int findmax(int a[], int n) {
        if (n == 1) {
            return a[0];
        }
        return Math.max(a[n - 1], findmax(a, n - 1));
    }

    int findsum(int a[], int n) {
        if (n == 1) {
            return a[0];
        }
        return a[n - 1] + findsum(a, n - 1);
    }

    boolean checkPali(char a[], int start, int end) {
        if (start == end) {
            return true;
        }
        if (a[start] != a[end]) {
            return false;
        }
        if (start < end) {
            checkPali(a, start + 1, end - 1);
        }
        return true;
    }

    int ispalindrome(char a[], int n) {
        if (n == 0) {
            return 1;
        }
        if (checkPali(a, 0, n - 1)) {
            return 1;
        }
        return 0;
    }

    int search(int arr[], int left, int right, int x) {
        if (left <= right) {
            int mid = (right + left) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] < x) {
                return search(arr, mid + 1, right, x);
            } else {
                return search(arr, left, mid - 1, x);
            }
        }
        return -1;
    }

    int binarySearch(int arr[], int n, int x) {
        if (search(arr, 0, n - 1, x) == -1) {
            return 0;
        } else {
            return 1;
        }
    }
}
