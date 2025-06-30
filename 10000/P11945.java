import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11945 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String NM = br.readLine();
        int N = Integer.parseInt(NM.split(" ")[0]);
        int M = Integer.parseInt(NM.split(" ")[1]);


        char[][] matrix = new char[N][M];
        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().toCharArray();
        }



        StringBuilder output = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = M - 1; j >= 0; j--) {
                output.append(matrix[i][j]);
            }
            output.append("\n");
        }

        System.out.println(output);
    }
}
