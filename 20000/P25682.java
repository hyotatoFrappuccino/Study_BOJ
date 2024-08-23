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
    static char[][] matrix;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        matrix = new char[N][M];
        for (int i = 0; i < N; i++) {
            char[] charArray = lines[i + 1].toCharArray();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = charArray[j];
            }
        }
    }

    static String process() {
//        틀린걸 저장하는 누적합 (K*K의 왼쪽 위가 B로 시작할 때, W로 시작할 때)
        int[][] prefixSumB = new int[N + 1][M + 1];
        int[][] prefixSumW = new int[N + 1][M + 1];

        // 누적합
        char filterB;
        char filterW;
        for (int i = 1; i <= N; i++) {
            filterB = (i & 1) == 1 ? 'B' : 'W';
            filterW = (i & 1) == 1 ? 'W' : 'B';
            for (int j = 1; j <= M; j++) {
                prefixSumB[i][j] = prefixSumB[i - 1][j] + prefixSumB[i][j - 1] - prefixSumB[i - 1][j - 1] + (matrix[i - 1][j - 1] != filterB ? 1 : 0);
                prefixSumW[i][j] = prefixSumW[i - 1][j] + prefixSumW[i][j - 1] - prefixSumW[i - 1][j - 1] + (matrix[i - 1][j - 1] != filterW ? 1 : 0);
                filterB = filterB == 'B' ? 'W' : 'B';
                filterW = filterW == 'B' ? 'W' : 'B';
            }
        }

        // K * K 가능한 모든 경우의 수 구간합 (matrix[i][j] ~ matrix[i+K][j+K] 의 구간합)
        int min = K * K;
        for (int i = 1; i <= N - K + 1; i++) {
            for (int j = 1; j <= M - K + 1; j++) {
                int minNumB = getWrongCount(prefixSumB, i, j);
                int minNumW = getWrongCount(prefixSumW, i, j);
                int minNum = Math.min(minNumB, minNumW);
                if (minNum < min) {
                    min = minNum;
                }
            }
        }

        return String.valueOf(min);
    }

    private static int getWrongCount(int[][] prefixSum, int i, int j) {
        return prefixSum[i + K - 1][j + K - 1] - prefixSum[i - 1][j + K - 1] - prefixSum[i + K - 1][j - 1] + prefixSum[i - 1][j - 1];
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