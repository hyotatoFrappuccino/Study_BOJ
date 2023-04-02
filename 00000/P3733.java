import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P3733 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null && !input.isEmpty()){
            int[] NS = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = NS[0];
            int S = NS[1];
            System.out.println(S / (N + 1));
        }
    }
}
