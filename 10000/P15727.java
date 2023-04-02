import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P15727 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n % 5 == 0)
            System.out.println(n/5);
        else
            System.out.println(n/5 + 1);
    }
}
