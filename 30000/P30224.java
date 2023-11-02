import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P30224 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int num = Integer.parseInt(input);
        if (input.contains("7")) {
            if (num % 7 == 0)
                System.out.println("3");
            else
                System.out.println("2");
        }
        else {
            if (num % 7 == 0)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
