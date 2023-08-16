import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P18111 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M];
        int min = 256;
        int max = 0;
        // 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;
                if (num < min) min = num;
                if (num > max) max = num;
            }
        }

        int minTime = Integer.MAX_VALUE;
        int minHeight = 0;
        // 이미 땅 고르기가 완료된 경우
        if (min == max) minTime = 0;
        for (int height = min; height <= max; height++) {
            int time = 0;
            int tempB = B;
            int correct = 0;
            // 제거
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int cur = matrix[i][j];
                    if (cur > height) {
                        time += 2 * (cur - height);
                        tempB += cur - height;
                        correct++;
                    }
                }
            }
            // 설치
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int cur = matrix[i][j];
                    if (cur < height && tempB >= height - cur) {
                        time += height - cur;
                        tempB -= height - cur;
                        correct++;
                    }
                    if (cur == height) correct++;
                }
            }
            if (correct == N * M && time > 0 && time < minTime || (time == minTime && height > minHeight)) {
                minTime = time;
                minHeight = height;
            }
        }
        System.out.println(minTime + " " + minHeight);
    }
}
