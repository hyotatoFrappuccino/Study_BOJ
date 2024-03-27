import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P10830 {
    // 미풀이
    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long[][] matrix = new long[N][N];
        long[][] newMatrix = new long[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                long num = Long.parseLong(st.nextToken());
                matrix[i][j] = num;
                newMatrix[i][j] = num;
            }
        }

        // 연산

        for (int b = 1; b < B; b++) {
            long[][] newMatrixCopy = deepCopy(newMatrix, N);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // i 행, j줄을 모두 곱해 [i,j]에 새로 할당
                    long sum = 0;
                    for (int k = 0; k < N; k++) {
                        sum += matrix[i][k] * newMatrixCopy[k][j];
                    }
                    newMatrix[i][j] = sum % 1000;
                }
            }
        }
        extracted(N, newMatrix);

        // 결과 출력

    }

    private static void extracted(int N, long[][] newMatrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(newMatrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static long[][] deepCopy(long[][] original, int n) {
        if (original == null) {
            return null;
        }

        long[][] result = new long[n][n];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
    }
}
