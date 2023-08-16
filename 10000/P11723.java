import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class P11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] set = new boolean[20];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            if (Objects.equals(cmd, "add")) {
                set[Integer.parseInt(st.nextToken()) - 1] = true;
            }
            else if (Objects.equals(cmd, "remove")) {
                set[Integer.parseInt(st.nextToken()) - 1] = false;
            }
            else if (Objects.equals(cmd, "check")) {
                if (set[Integer.parseInt(st.nextToken()) - 1])
                    sb.append("1").append("\n");
                else
                    sb.append("0").append("\n");
            }
            else if (Objects.equals(cmd, "toggle")) {
                int index = Integer.parseInt(st.nextToken()) - 1;
                set[index] = !set[index];
            }
            else if (Objects.equals(cmd, "all")) {
                for (int j = 0; j < 20; j++) {
                    set[j] = true;
                }
            }
            else if (Objects.equals(cmd, "empty")) {
                for (int j = 0; j < 20; j++) {
                    set = new boolean[20];
                }
            }
        }
        System.out.println(sb);
    }
}
