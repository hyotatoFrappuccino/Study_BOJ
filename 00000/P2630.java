import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2630 {
    static int N;
    static int curN;
    static int white = 0;
    static int blue = 0;
    static int[][] matrix;
    static boolean[][] done;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 색종이의 가로세로 길이
        N = Integer.parseInt(br.readLine());

        // 색종이
        matrix = new int[N][N];

        // 마지막으로 나눠진 크기의 색종이인지
        done = new boolean[N][N];

        // 입력
        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // /2씩 분할하기 위해 처음 기준을 가로세로 길이 N으로 지정
        curN = N;
        // 하나의 정사각형 칸이 될 때까지 반복
        while (curN >= 1) {
            // 분할된 각 색종이가 모두 하얀색 또는 파란색으로 칠해져 있는지 체크
            check();
            // 분할
            curN /= 2;
        }

        // 결과 출력
        System.out.println(white + "\n" + blue);
    }

    public static void check() {
        // 나눈 색종이 별로 모두 파랑이거나 하양인지 검사, 단위는 현재 나누는 단위로 함. 시작위치가 i와 j가 됨
        for (int i = 0; i < N; i += curN) {
            for (int j = 0; j < N; j += curN) {
                // 0이면 모두 하양, Math.pow(curN, 2)면 모두 파랑으로 판단
                int result = 0;
                // 나눈 각 색종이를 합함
                for (int k = i; k < i + curN; k++) {
                    for (int l = j; l < j + curN; l++) {
                        result += matrix[k][l];
                    }
                }
                // 아직 나눠지지 않은 색종이고 모두 하양이라면
                if (!done[i][j] && result == 0) {
                    white++;
                    for (int k = i; k < i + curN; k++) {
                        for (int l = j; l < j + curN; l++) {
                            // 해당 색종이를 나눠진 것으로 지정
                            done[k][l] = true;
                        }
                    }
                }
                // 아직 끝나지 않았고 모두 파랑이라면
                else if (!done[i][j] && result == Math.pow(curN, 2)) {
                    blue++;
                    for (int k = i; k < i + curN; k++) {
                        for (int l = j; l < j + curN; l++) {
                            done[k][l] = true;
                        }
                    }
                }
            }
        }
    }
}
