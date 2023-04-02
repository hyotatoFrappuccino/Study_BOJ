import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P15964 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] input = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        System.out.println((input[0] + input[1]) * (input[0] - input[1]));
    }
}
