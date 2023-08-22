import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P14889 {
    static int N;
    static int[][] matrix;
    static boolean[] visited;
    static int[] arr;
    static int sum;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        visited = new boolean[N];
        arr = new int[N/2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;
            }
        }
        recur(0);
        System.out.println(min);
    }

    public static void recur(int depth) {
        if (depth == N / 2) {
            int sum1;
            int sum2;
            sum = 0;
            recur2(0, arr, new int[2], new boolean[N]);
            List<Integer> list = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                list.add(i);
            }
            for (int j : arr) {
                list.remove((Integer) j);
            }
            int[] arr2 = new int[N/2];
            for (int i = 0; i < N / 2; i++) {
                arr2[i] = list.get(i);
            }
            sum1 = sum;
            sum = 0;
            recur2(0, arr2, new int[2], new boolean[N]);
            sum2 = sum;
            if (Math.abs(sum1 - sum2) < min)
                min = Math.abs(sum1 - sum2);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (depth > 0 && arr[depth - 1] > i + 1)
                    continue;
                visited[i] = true;
                arr[depth] = i + 1;
                recur(depth + 1);
                visited[i] = false;
            }
        }
    }

    // num = 입력받는배열
    // arr = 기존의 arr이라 생각
    public static void recur2(int depth, int[] num, int[] arr, boolean[] visited) {
        if (depth == 2) {
            sum += matrix[num[arr[0] - 1] - 1][num[arr[1] - 1] - 1] + matrix[num[arr[1] - 1] - 1][num[arr[0] - 1] - 1];
            return;
        }
        for (int i = 0; i < N / 2; i++) {
            if (!visited[i]) {
                if (depth > 0 && arr[depth - 1] > i + 1)
                    continue;
                visited[i] = true;
                arr[depth] = i + 1;
                recur2(depth + 1, num, arr, visited);
                visited[i] = false;
            }
        }
    }
}
