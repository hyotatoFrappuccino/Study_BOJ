import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P8958 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("X");
            int score = 0;
            for (String str : input) {
                if (str.contains("O")) {
                    for (int k = 1; k <= str.length(); k++) {
                        score += k;
                    }
                }
            }
            System.out.println(score);
        }
    }
}
