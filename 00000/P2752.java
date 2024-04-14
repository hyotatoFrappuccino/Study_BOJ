import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2752 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[3];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < 3; i++) {
            list[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(list);
        for (int i : list) {
            System.out.print(i + " ");
        }
        br.close();
    }
}
