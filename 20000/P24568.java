import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P24568 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int R = Integer.parseInt(br.readLine());
        int S = Integer.parseInt(br.readLine());
        System.out.println(R * 8 + S * 3 - 28);
    }
}
