import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14888 {
    static int N;
    static int[] A;
    static long MAX = Long.MIN_VALUE;
    static long MIN = Long.MAX_VALUE;
    static char[] operatorList;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int add = Integer.parseInt(st.nextToken());
        int subtract = Integer.parseInt(st.nextToken());
        int multiply = Integer.parseInt(st.nextToken());
        int divide = Integer.parseInt(st.nextToken());

        operatorList = new char[N - 1];
        visited = new boolean[N - 1];
        int index = 0;

        for (int i = 0; i < add; i++) {
            operatorList[index++] = '+';
        }
        for (int i = 0; i < subtract; i++) {
            operatorList[index++] = '-';
        }
        for (int i = 0; i < multiply; i++) {
            operatorList[index++] = '*';
        }
        for (int i = 0; i < divide; i++) {
            operatorList[index++] = '/';
        }


        recur(0, A[0]);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void recur(int depth, long num) {
        if (depth == N - 1) {
            if (num > MAX) MAX = num;
            if (num < MIN) MIN = num;
        }

        // 연산자 리스트 반복
        for (int i = 0; i < N - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                char operator = operatorList[i];
                if (operator == '+')
                    recur(depth + 1, num + A[depth + 1]);
                else if (operator == '-')
                    recur(depth + 1, num - A[depth + 1]);
                else if (operator == '*')
                    recur(depth + 1, num * A[depth + 1]);
                else if (operator == '/')
                    recur(depth + 1, num / A[depth + 1]);
                visited[i] = false;
            }
        }
    }
}
