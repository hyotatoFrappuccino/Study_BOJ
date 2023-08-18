import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P23235 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1;
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) break;
            System.out.println("Case " + num++ + ": Sorting... done!");
        }
    }
}
