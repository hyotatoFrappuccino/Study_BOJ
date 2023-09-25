import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9656 {
    public static void main(String[] args) throws Exception {
        System.out.println(((Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()) & 1) == 1) ? "CY" : "SK");
    }
}
