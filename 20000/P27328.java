import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P27328 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        if (A < B)
            System.out.println("-1");
        else if (A > B)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
