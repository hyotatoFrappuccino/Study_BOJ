import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class P25192 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (Objects.equals(input, "ENTER")) {
                sum += set.size();
                set.clear();
            }
            else {
                set.add(input);
            }
        }
        sum += set.size();
        System.out.println(sum);
    }
}
