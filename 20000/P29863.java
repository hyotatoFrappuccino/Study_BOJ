import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P29863 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sleep = Integer.parseInt(br.readLine());
        if (sleep >= 20) sleep -= 24;
        int wake = Integer.parseInt(br.readLine());
        System.out.println(wake - sleep);
    }
}
