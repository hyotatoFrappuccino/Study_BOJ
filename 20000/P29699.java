import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P29699 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) - 1;
        N %= 14;
        System.out.println("WelcomeToSMUPC".charAt(N));
    }
}
