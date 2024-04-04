import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1032 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] list = new String[N];
        for (int i = 0; i < N; i++) {
            list[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder(list[0]);
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < list[0].length(); j++) {
                if (list[i].charAt(j) != list[0].charAt(j)) {
                    sb.replace(j, j + 1, "?");
                }
            }
        }
        System.out.println(sb);
    }
}
