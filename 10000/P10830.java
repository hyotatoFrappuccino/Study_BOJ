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
        BigInteger B = new BigInteger(st.nextToken());
        BigInteger[][] matrix = new BigInteger[N][N];
        BigInteger[][] newMatrix = new BigInteger[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                BigInteger num = new BigInteger(String.valueOf(Integer.parseInt(st.nextToken())));
                matrix[i][j] = num;
                newMatrix[i][j] = num;
            }
        }

        // 연산

        for (BigInteger b = BigInteger.ZERO; b.compareTo(B) < 0; b = b.add(BigInteger.ONE)) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // i 행, j줄을 모두 곱해 [i,j]에 새로 할당
                    BigInteger sum = BigInteger.ZERO;
                    for (int k = 0; k < N; k++) {
                        sum = sum.add(matrix[i][k].multiply(newMatrix[k][j]));
                    }
                    newMatrix[i][j] = sum;
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(newMatrix[i][j]).append(" ");
//                sb.append(newMatrix[i][j].divide(new BigInteger("1000"))).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
