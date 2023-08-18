import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P27294 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        if (S == 1 || T <= 11 || T >= 17)
            System.out.println("280");
        else
            System.out.println("320");

    }
}
