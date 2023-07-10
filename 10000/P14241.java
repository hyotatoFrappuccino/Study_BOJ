import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P14241 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int score = list[0] * list[1];
        int scale = list[0] + list[1];
        int multiIndex = 2;
        while (multiIndex < list.length) {
            score += scale * list[multiIndex];
            scale += list[multiIndex++];
        }
        System.out.println(score);
    }
}
