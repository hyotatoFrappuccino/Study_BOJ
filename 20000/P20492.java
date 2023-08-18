import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P20492 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println((int)(N * 0.78) + " " + (int)(N - (N * 0.2 * 0.22)));
    }
}
