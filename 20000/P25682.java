import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P25682 {
    static int N;
    static int M;
    static int K;
    static int[][] matrix;
    static StringBuilder output;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] charArray = lines[i + 1].toCharArray();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = (charArray[j] == 'B') ? 1 : 0;
            }
        }
        output = new StringBuilder();
    }

    static String process() {
        int[][] prefixSum = new int[N + 1][M + 1];

        // 누적합
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        System.out.println("====== 누적합 (prefixSum) ======");
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                System.out.print(prefixSum[i][j] + " ");
            }
            System.out.println();
        }

        int areaA = Math.round((float) (K * K) / 2);
        int areaB = K * K / 2;
        System.out.println("areaA = " + areaA + ", areaB = " + areaB);
        System.out.printf("===== K * K =====\n");

        // K * K 가능한 모든 경우의 수 구간합 (matrix[i][j] ~ matrix[i+K][j+K] 의 구간합)
        int min = Math.max(areaA, areaB);
        int mini = 0;
        int minj = 0;
        for (int i = 1; i <= N - K + 1; i++) {
            for (int j = 1; j <= M - K + 1; j++) {
                int i1 = prefixSum[i + K - 1][j + K - 1] - prefixSum[i - 1][j + K - 1] - prefixSum[i + K - 1][j - 1] + prefixSum[i - 1][j - 1];
                System.out.println("i = " + i + ", j = " + j + ", B = " + i1 + ", W = " + (K * K - i1));
                int minNum = Math.abs(areaA - i1);
                if (minNum < min) {
                    min = minNum;
                    mini = i;
                    minj = j;
                }
            }
        }
        System.out.println("mini = " + mini + ", minj = " + minj);

        int[][] wise = new int[K][K];
        for (int i = 0; i < K; i++) {
            int c = (i & 1) == 0 ? 1 : 0;
            for (int j = 0; j < K; j++) {
                wise[i][j] = c;
                c = c == 1 ? 0 : 1;
            }
        }
        int countB = 0;
        int countW = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                if (wise[i][j] == matrix[mini + i - 1][minj + j - 1]) {
                    countB++;
                } else {
                    countW++;
                }
            }
        }
        System.out.println("countB = " + countB + ", countW = " + countW);

        return String.valueOf(Math.min(countB, countW));
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