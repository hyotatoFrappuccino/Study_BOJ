import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P26574 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String num = br.readLine();
            sb.append(num).append(" ").append(num).append("\n");
        }
        System.out.println(sb);
    }
}
