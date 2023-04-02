import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11382 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] list = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += list[i];
        }
        System.out.printf("%.0f", sum);
    }
}
