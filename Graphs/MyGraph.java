/**
 *
 * @author khoai2601
 */
public class MyGraph {

    char[] vertices;
    int[][] matrix;
    int n;
    int deg[];

    public MyGraph() {
        vertices = "ABCDEF".toCharArray();
        deg = new int[20];
    }

    void setData(int[][] b) {
        n = b.length;
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = b[i][j];
            }
        }
    }

    void displayAdjacencyList() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(vertices[i] + " |  ");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    System.out.print(vertices[j] + "   ");
                }
            }
            System.out.println("");
        }
    }

    void visit(int i) throws Exception {
        System.out.print(" " + vertices[i]);
    }

    // Breadth-first traversal from vertex  A? 
    // (visit nodes in alphabetical order if there are some nodes having the same selection ability).
    void breadthFirst(int k) throws Exception {
        Queue q = new Queue();
        int i, h;
        boolean[] enqueued = new boolean[n];

        for (i = 0; i < n; i++) {
            enqueued[i] = false;
        }

        q.enqueue(k);
        enqueued[k] = true;
        while (!q.isEmpty()) {
            h = q.dequeue();
            visit(h);
            for (i = 0; i < n; i++) {
                if ((!enqueued[i]) && matrix[h][i] > 0) {
                    q.enqueue(i);
                    enqueued[i] = true;
                }
            }
        }
    }

    void breadth(boolean[] en, int i) throws Exception {
        Queue q = new Queue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            for (j = 0; j < n; j++) {
                if (!en[j] && matrix[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void breadth(int k) throws Exception {
        boolean[] en = new boolean[n];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i);
            }
        }
        System.out.println();
    }

    // Depth-first traversal from vertex  A? 
    // (visit nodes in alphabetical order if there are some nodes having the same selection ability).
    void depth(boolean[] visited, int k) throws Exception {
        visit(k);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && matrix[k][i] > 0) {
                depth(visited, i);
            }
        }
    }

    void depth(int k) throws Exception {
        boolean[] visited = new boolean[n];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth(visited, k);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth(visited, i);
            }
        }
        System.out.println();
    }

    int[] setArray(int x) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = x;
        }
        return array;
    }

    void traverse() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(vertices[i] + " |  ");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0 && matrix[i][j] != 999) {
                    System.out.print(vertices[j] + "   ");
                }
            }
            System.out.println("");
        }
    }

    // The Dijkstra algorithm to find the shortest path from the vertex A to the vertex F
    void dijkstra(int indexStart, int indexEnd) {

        boolean[] known = new boolean[n];
        int[] cost = setArray(999);
        int[] path = setArray(-1);

        cost[indexStart] = 0;

        for (int k = 0; k < n; k++) {
            int minIndex = find_minIndex(cost, known);

            known[minIndex] = true;

            for (int i = 0; i < n; i++) {
                if (known[i]) {
                    continue;
                }
                if (cost[minIndex] == 999) {
                    break;
                }
                if (cost[i] > cost[minIndex] + matrix[minIndex][i]) {
                    cost[i] = cost[minIndex] + matrix[minIndex][i];
                    path[i] = minIndex;
                }
            }
        }
        display(cost, path, indexEnd);
    }

    int find_minIndex(int[] array, boolean[] known) {
        int min = 999;
        int minIndex = -1;
        for (int i = 0; i < n; i++) {
            if (known[i] == false && array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    void display(int cost[], int path[], int end) {
        Stack sCost = new Stack();
        Stack s = new Stack();

        s.push(end);
        sCost.push(cost[end]);
        int indexPath = path[end];
        while (indexPath != -1) {
            s.push(indexPath);
            sCost.push(cost[indexPath]);
            indexPath = display_tmp(path, vertices[indexPath]);
        }

        while (!(s.isEmpty())) {
            System.out.print(vertices[s.pop()] + " ");
        }

        System.out.println("");

        while (!(sCost.isEmpty())) {
            System.out.print(sCost.pop() + " ");
        }
    }

    int display_tmp(int path[], char c) {
        int i = 0;
        for (i = 0; i < n; i++) {
            if (vertices[i] == c) {
                break;
            }
        }
        return path[i];
    }

    // Determine whether or not  an Euler cycle exists, and if so, provide an example.
    int deg(int i) {
        int s, j;
        s = 0;
        for (j = 0; j < n; j++) {
            s += matrix[i][j];
        }
        s += matrix[i][i];
        return (s);
    }

    // Recommend start in here
    boolean allDegEven() {
        for (int i = 0; i < n; i++) {
            if (deg(i) % 2 == 1) {
                return (false);
            }
        }
        return (true);
    }

    boolean isConnected() {
        Stack s = new Stack();
        boolean[] p = new boolean[n];
        int i, j, k;
        for (i = 0; i < n; i++) {
            p[i] = false;
        }
        s.push(0);
        p[0] = true;
        while (!s.isEmpty()) {
            k = s.pop();
            for (i = 0; i < n; i++) {
                if (!p[i] && matrix[k][i] > 0) {
                    s.push(i);
                    p[i] = true;
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (!p[i]) {
                return (false);
            }
        }
        return (true);
    }

    boolean hasEulerCycle() {
        if (isConnected() && allDegEven()) {
            return (true);
        }
        return (false);
    }

    void eulerCycle(int k) {
        if (!hasEulerCycle()) {
            System.out.println("Conditions for Euler Cycle are not satisfied");
            return;
        }
        Stack s = new Stack();
        int[] eu = new int[100];
        int i, j, r, m;
        m = 0;
        s.push(k);
        while (!s.isEmpty()) {
            r = s.top();
            for (i = 0; i < n; i++) {
                if (matrix[r][i] > 0) {
                    break;
                }
            }
            if (i == n) { // r is isolated
                s.pop();
                eu[m++] = r;
            } else {
                s.push(i);
                matrix[r][i]--;
                matrix[i][r]--;
            }
        }
        System.out.print(vertices[eu[0]]);
        for (i = 1; i < m; i++) {
            System.out.print(" -> " + vertices[eu[i]]);
        }
        System.out.println();
    }

    //Bonus: traverse base input index
    int startIndex = 0;
    int endIndex = 4;
    int count = 0;

    void visitBaseIndex(int i) throws Exception {
        if (count >= startIndex && count <= endIndex) {
            System.out.print(" " + vertices[i]);
        }
    }

    void breadthBaseIndex(boolean[] en, int i) throws Exception {
        Queue q = new Queue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            count++;
            visitBaseIndex(r);
            for (j = 0; j < n; j++) {
                if (!en[j] && matrix[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void breadthBaseIndex() throws Exception {
        boolean[] en = new boolean[n];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        breadthBaseIndex(en, 0);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadthBaseIndex(en, i);
            }
        }
        System.out.println();
    }

    void depthBaseIndex(boolean[] visited, int k) throws Exception {
        count++;
        visitBaseIndex(k);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && matrix[k][i] > 0) {
                depthBaseIndex(visited, i);
            }
        }
    }

    void depthBaseIndex() throws Exception {
        boolean[] visited = new boolean[n];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depthBaseIndex(visited, 0);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depthBaseIndex(visited, i);
            }
        }
        System.out.println();
    }

    //Visit base degree
    void fvisitDeg(int i) throws Exception {
        if (deg[i] == 2) {
            System.out.print(" " + vertices[i] + "(" + deg[i] + ")" + "   ");
        }
    }

    void breadthBaseDeg(boolean[] en, int i) throws Exception {
        Queue q = new Queue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            deg[r] = deg(r);
            fvisitDeg(r);
            for (j = 0; j < n; j++) {
                if (!en[j] && matrix[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void breadthBaseDeg(int k) throws Exception {
        boolean[] en = new boolean[n];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        breadthBaseDeg(en, k);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadthBaseDeg(en, i);
            }
        }
        System.out.println();
    }

    void depthBaseDeg(boolean[] visited, int k) throws Exception {
        deg[k] = deg(k);
        fvisitDeg(k);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && matrix[k][i] > 0) {
                depthBaseDeg(visited, i);
            }
        }
    }

    void depthBaseDeg(int k) throws Exception {
        boolean[] visited = new boolean[n];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depthBaseDeg(visited, k);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depthBaseDeg(visited, i);
            }
        }
        System.out.println();
    }
}
