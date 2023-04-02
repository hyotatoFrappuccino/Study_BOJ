import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2908 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String[] num1 = input[0].split("");
        String[] num2 = input[1].split("");
        StringBuilder newnum1 = new StringBuilder();
        StringBuilder newnum2 = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            newnum1.append(num1[i]);
            newnum2.append(num2[i]);
        }
        int intnum1 = Integer.parseInt(newnum1.toString());
        int intnum2 = Integer.parseInt(newnum2.toString());
        System.out.println(Math.max(intnum1, intnum2));

    }
}
