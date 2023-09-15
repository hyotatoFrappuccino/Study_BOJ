import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class P9655 {
    public static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        get(1, "SK");
    }

    public static void get(int n, String name) {
        if (n == N) {
            System.out.println(name);
            System.exit(0);
        }
        else if (n > N) return;
        if (Objects.equals(name, "SK")){
            get(n + 1, "CY");
            get(n + 3, "CY");
        }
        else {
            get(n + 1, "SK");
            get(n + 3, "SK");
        }
    }
}
