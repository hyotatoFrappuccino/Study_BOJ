import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P25314 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num/4; i++) {
            System.out.print("long ");
        }
        System.out.println("int");
    }
}
