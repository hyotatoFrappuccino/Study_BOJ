import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P15658 {
    static int N;
    static int[] A;
    static int[] oper;
    static long MIN;
    static long MAX;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        StringTokenizer st = new StringTokenizer(lines[1]);
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(lines[2]);
        oper = new int[4];
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }
        MIN = Integer.MAX_VALUE;
        MAX = Integer.MIN_VALUE;
    }

    static String process() {
        dfs(0, new int[N -1]);
        return MAX + "\n" + MIN;
    }

    private static void dfs(int depth, int[] operList) {
        if (depth == N - 1) {
            // operList 넘겨서 oper[]에 충족하면, MIN, MAX 갱신
            check(operList);
            return;
        }

        for (int i = 0; i < 4; i++) {
            operList[depth] = i;
            dfs(depth + 1, operList);
        }
    }

    private static void check(int[] operList) {
        int[] operCount = new int[4];
        Arrays.stream(operList).forEach(i -> operCount[i]++);

        // 허용 연산 수를 넘은 경우
        for (int i = 0; i < 4; i++) {
            if (operCount[i] > oper[i]) {
                return;
            }
        }

        // 계산해서 MIN, MAX 갱신
        long sum = 0L;
        sum += A[0];
        for (int i = 1; i < N; i++) {
            switch (operList[i - 1]) {
                case 0:
                    sum += A[i];
                    break;
                case 1:
                    sum -= A[i];
                    break;
                case 2:
                    sum *= A[i];
                    break;
                case 3:
                    sum /= A[i];
                    break;
            }
        }

        MIN = Math.min(MIN, sum);
        MAX = Math.max(MAX, sum);
    }

    public static void main(String[] args) throws IOException {
        input(readLines());
        System.out.println(process());
    }

    private static String[] readLines() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            lines.add(line);
        }
        br.close();

        String[] linesArray = new String[lines.size()];
        linesArray = lines.toArray(linesArray);
        return linesArray;
    }
}