import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1992 {
    static int N;
    static int[][] matrix;
    static StringBuilder output;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);

        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] charArray = lines[i + 1].toCharArray();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = charArray[j];
            }
        }
        output = new StringBuilder();
    }

    static String process() {

        search(0, 0, N);

        return output.toString();
    }

//    같은 depth에서는 괄호안에!
    private static void search(int i, int j, int len) {
        boolean isAllOne = true;
        boolean isAllZero = true;

        for (int k = i; k < i + len; k++) {
            for (int l = j; l < j + len; l++) {
                if (matrix[k][l] == '1') {
                    isAllZero = false;
                }
                if (matrix[k][l] == '0') {
                    isAllOne = false;
                }
            }
        }
        if (isAllOne) {
            output.append("1");
            return;
        }

        if (isAllZero) {
            output.append("0");
            return;
        }

        output.append("(");
        len /= 2;
        search(i, j, len);
        search(i, j + len, len);
        search(i + len, j, len);
        search(i + len, j + len, len);
        output.append(")");
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