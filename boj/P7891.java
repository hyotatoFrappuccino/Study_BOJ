import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P7891 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            long[] input = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            System.out.println(input[0] + input[1]);
        }
    }
}
