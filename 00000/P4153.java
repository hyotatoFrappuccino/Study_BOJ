import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class P4153 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        StringBuilder sb = new StringBuilder();
        while (!Objects.equals(input = br.readLine(), "0 0 0")) {
            StringTokenizer st = new StringTokenizer(input, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (Math.pow(a, 2) == (Math.pow(b, 2) + Math.pow(c, 2)) ||
                Math.pow(b, 2) == (Math.pow(a, 2) + Math.pow(c, 2)) ||
                Math.pow(c, 2) == (Math.pow(a, 2) + Math.pow(b, 2))
            )
                sb.append("right").append("\n");
            else
                sb.append("wrong").append("\n");
        }
        System.out.println(sb);
    }
}
