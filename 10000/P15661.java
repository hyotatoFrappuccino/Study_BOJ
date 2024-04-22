import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15661 {
    static int N;
    static int[][] matrix;
    static int min;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(lines[i + 1].split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        min = Integer.MAX_VALUE;
    }

    static String process() {
        for (int team = 1; team < (1 << N) - 1; team++) {
            int sumOfTeam0 = 0;
            int sumOfTeam1 = 0;
            for (int people0 = 0; people0 < N; people0++) {
                for (int people1 = 0; people1 < N; people1++) {
                    if (((team & (1 << people0)) > 0) && ((team & (1 << people1))  > 0)) {
                        sumOfTeam0 += matrix[people0][people1];
                    } else if (((team & (1 << people0)) == 0) && ((team & (1 << people1)) == 0)) {
                        sumOfTeam1 += matrix[people0][people1];
                    }
                }
            }
            min = Math.min(min, Math.abs(sumOfTeam0 - sumOfTeam1));
        }
        return String.valueOf(min);
    }

    public static void main(String[] args) throws IOException {
        input(readLines());
        System.out.println(process());
    }

    private static String[] readLines() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            lines.add(line);
        }
        br.close();

        String[] linesArray = new String[lines.size()];
        linesArray = lines.toArray(linesArray);
        return linesArray;
    }
}