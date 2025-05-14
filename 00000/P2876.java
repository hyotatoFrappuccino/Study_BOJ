import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2876 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        int maxCount = 0;
        int resultGrade = 6;

        for (int grade = 1; grade <= 5; grade++) {
            int count = 0;

            for (int right = 0; right < N; right++) {
                if (A[right] == grade || B[right] == grade) {
                    count++;
                } else {
                    // 왼쪽을 이동시키며 새로운 윈도우 시작
                    count = 0;
                }

                if (count > maxCount) {
                    maxCount = count;
                    resultGrade = grade;
                } else if (count == maxCount && grade < resultGrade) {
                    resultGrade = grade;
                }
            }
        }

        System.out.println(maxCount + " " + resultGrade);
    }
}
