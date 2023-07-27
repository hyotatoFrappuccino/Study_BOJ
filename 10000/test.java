import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
             sb.append(r.nextInt(100)).append(" ");
        }
        System.out.println(sb);
    }
}
