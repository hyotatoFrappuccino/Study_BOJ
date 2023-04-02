import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2566 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < 9; i++) {
            int[] rowInput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < 9; j++) {
                if (rowInput[j] >= max){
                    max = rowInput[j];
                    maxRow = i + 1;
                    maxCol = j + 1;
                }
            }

        }
        System.out.println(max);
        System.out.println(maxRow + " " + maxCol);
    }
}
