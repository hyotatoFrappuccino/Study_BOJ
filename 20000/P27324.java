import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P27324 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input.charAt(0) == input.charAt(1))
            System.out.println("1");
        else
            System.out.println("0");
    }
}
