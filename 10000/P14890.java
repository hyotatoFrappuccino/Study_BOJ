import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P14890 {
    static int N;
    static int L;
    static int[][] matrix;
    static int result;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(lines[i + 1].split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        result = 0;
    }

    static String process() {

        for (int i = 0; i < N; i++) {
            // 가로줄 체크
            if (check(matrix[i])) {
                result++;
            }

            int[] list = new int[N];
            for (int j = 0; j < N; j++) {
                list[j] = matrix[j][i];
            }
            if (check(list)) {
                result++;
            }
        }


        return String.valueOf(result);
    }


    public static boolean check(int[] list) {
        boolean[] installed = new boolean[list.length];
        int j = 0;
        for (; j < N - 1; j++) {
            // 다음칸 높이가 같다면
            if (list[j] == list[j + 1]) continue;

            // 경사로를 놓을 수 있는 범위 이상이라면 불가능.
            if (j + L < N) {
                boolean slope = true;
                // 경사로 내 칸이 모두 -1차이가 나는지
                for (int k = j + 1; k <= j + L; k++) {
                    if (list[k] != list[j] - 1) {
                        slope = false;
                        break;
                    }
                }
                if (slope) {
                    for (int i = j + 1; i <= j + L; i++) {
                        installed[i] = true;
                    }
                    j += L - 1;
                    continue;
                }
            }

            if (j + 1 - L >= 0) {
                boolean slope2 = true;
                for (int i = j; i > j - L; i--) {
                    if (installed[i] || list[i] != list[j + 1] - 1) {
                        slope2 = false;
                        break;
                    }
                }
                if (slope2) continue;
            }
            return false;
        }
        return j == N - 1;
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