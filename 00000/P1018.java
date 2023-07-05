import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1018 {
    static char[][] matrix;
    static char[][] correctMatrix1 =   {"BWBWBWBW".toCharArray(),
                                        "WBWBWBWB".toCharArray(),
                                        "BWBWBWBW".toCharArray(),
                                        "WBWBWBWB".toCharArray(),
                                        "BWBWBWBW".toCharArray(),
                                        "WBWBWBWB".toCharArray(),
                                        "BWBWBWBW".toCharArray(),
                                        "WBWBWBWB".toCharArray()};
    static char[][] correctMatrix2 =   {"WBWBWBWB".toCharArray(),
                                        "BWBWBWBW".toCharArray(),
                                        "WBWBWBWB".toCharArray(),
                                        "BWBWBWBW".toCharArray(),
                                        "WBWBWBWB".toCharArray(),
                                        "BWBWBWBW".toCharArray(),
                                        "WBWBWBWB".toCharArray(),
                                        "BWBWBWBW".toCharArray()};

    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];
        matrix = new char[N][M];
        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().toCharArray();
        }
        int min = N * M;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int result = getFillCount(i, j);
                if (result < min) min = result;
            }
        }
        System.out.println(min);


    }

    public static int getFillCount(int x, int y){
        int count1 = 0;
        int count2 = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (matrix[i][j] != correctMatrix1[i-x][j-y]){
                    count1++;
                }
                if (matrix[i][j] != correctMatrix2[i-x][j-y]){
                    count2++;
                }
            }
        }
        if (count1 < count2)
            return count1;
        return count2;
    }
}
