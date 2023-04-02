import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P14581 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(":fan::fan::fan:");
        System.out.println(":fan::" + input + "::fan:");
        System.out.println(":fan::fan::fan:");
    }
}
