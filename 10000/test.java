import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
             sb.append("test").append(r.nextInt(100000)).append(" enter \n");
        }
        System.out.println(sb);
    }
}
