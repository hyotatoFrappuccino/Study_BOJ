import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10798 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        A ~ Z, a ~ z, 0 ~ 9
//        글자가 없으면 읽지 않음
        char[][] matrix = new char[5][15];
        for (int i = 0; i < 5; i++) {
            char[] input = br.readLine().toCharArray();
            System.arraycopy(input, 0, matrix[i], 0, input.length);
        }
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 5; j++)
                if (matrix[j][i] != 0)
                    System.out.print(matrix[j][i]);
    }
}
