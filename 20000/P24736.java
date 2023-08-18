import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P24736 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int T = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            System.out.print(T * 6 + F * 3 + S * 2 + P + C * 2 + " ");
        }
    }

}
