import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P10809 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for (int i = 'a'; i <= 'z'; i++) {
            System.out.print(input.indexOf(i) + " ");
        }
    }
}
