import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P10807 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int V = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int num : list) {
            if (num == V){
                sum += 1;
            }
        }
        System.out.println(sum);
    }
}
