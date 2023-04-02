import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P4999 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();
        if (input1.length() >= input2.length()) System.out.println("go");
        else System.out.println("no");
    }
}
