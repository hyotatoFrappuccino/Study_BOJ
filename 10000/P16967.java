import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P16967 {
    static int H;
    static int W;
    static int X;
    static int Y;
    static int[][] A;
    static int[][] B;
    static StringBuilder output;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        A = new int[H][W];
        B = new int[H + X][W + Y];
        for (int i = 0; i < H + X; i++) {
            B[i] = Arrays.stream(lines[i + 1].split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        output = new StringBuilder();
    }

    static String process() {
        for (int i = X; i < H + X; i++) {
            for (int j = Y; j < W + Y; j++) {
                B[i][j] -= B[i - X][j - Y];
            }
        }


        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                output.append(B[i][j]).append(" ");
            }
            output.append("\n");
        }
        return output.toString();
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