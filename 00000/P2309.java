import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2309 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            list[i] = Integer.parseInt(br.readLine());
            sum += list[i];
        }
        Arrays.sort(list);

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - list[i] - list[j] == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            System.out.println(list[k]);
                        }
                    }
                    System.exit(0);
                }
            }
        }
        br.close();
    }
}
