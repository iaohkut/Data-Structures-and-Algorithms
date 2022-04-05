
/**
 *
 * @author khoai2601
 */
public class mainFunction {

    public static void main(String[] args) throws Exception {

        int[][] b1 = {
            {0, 1, 1, 0, 0, 0},
            {1, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0}
        };
//
////        int[][] b1 = {
////            {0, 1, 0, 0, 0, 1, 0},
////            {1, 0, 1, 1, 1, 0, 0},
////            {0, 1, 0, 1, 0, 0, 0},
////            {0, 1, 1, 0, 2, 0, 0},
////            {0, 1, 0, 2, 0, 0, 1},
////            {1, 0, 0, 0, 0, 0, 1},
////            {0, 0, 0, 0, 1, 1, 0}
////        };
//
        MyGraph mg = new MyGraph();
//        mg.setData(b1);
//
//        mg.breadthBaseDeg(0);
//        System.out.println("");
//        
//        mg.depthBaseDeg(0);
//        System.out.println("");
        
//        int[][] b2 = {
//            {0, 7, 9, 999, 999, 14},
//            {7, 0, 10, 15, 999, 999},
//            {9, 10, 0, 11, 999, 2},
//            {999, 15, 11, 0, 6, 999},
//            {999, 999, 999, 6, 0, 9},
//            {14, 999, 2, 999, 9, 0}
//        };
//
        int[][] b2 = {
            {00, 10, 15, 99, 99, 99},
            {10, 00, 99, 12, 99, 15},
            {15, 99, 00, 99, 10, 99},
            {99, 12, 99, 00, 02, 01},
            {99, 99, 10, 02, 00, 05},
            {99, 15, 99, 01, 05, 00}
        };
        mg.setData(b2);

        mg.traverse();
        System.out.println("===========================");

        mg.dijkstra(2, 4);
        System.out.println("");
    }
/*   
    public static void main(String[] args) {
        int[][] b = {
            {0, 2, 0, 0},//A
            {2, 0, 1, 1},//B
            {0, 1, 0, 1},//C
            {0, 1, 1, 0},//D
        };
        MyGraph g = new MyGraph();
        g.setData(b);

        System.out.print("Test Euler'cycle: ");
        g.eulerCycle(1);
        System.out.println();
    }
*/
}
