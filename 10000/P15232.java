import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P15232 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int R = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(R-- > 0) {
            sb.append("*".repeat(C)).append("\n");
        }
        System.out.println(sb);

        br.close();
    }
}
