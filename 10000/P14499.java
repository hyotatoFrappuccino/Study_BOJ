import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P14499 {
    static int N;
    static int M;
    static int x;
    static int y;
    static int K;
    static int top;
    static int bottom;
    static int east;
    static int west;
    static int south;
    static int north;

    static int[][] matrix;
    static int[] cmd;
    static StringBuilder output;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        top = 0;
        bottom = 0;
        east = 0;
        west = 0;
        south = 0;
        north = 0;

        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(lines[i + 1].split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        cmd = Arrays.stream(lines[N + 1].split(" ")).mapToInt(Integer::parseInt).toArray();

        output = new StringBuilder();
    }

    static String process() {
        for (int direction : cmd) {
            if (isValidMove(direction)) {
                move(direction);
                check();
                output.append(top).append("\n");
            }
        }
        return output.toString();
    }

    private static void check() {
        if (matrix[x][y] == 0) {
            matrix[x][y] = bottom;
        } else {
            bottom = matrix[x][y];
            matrix[x][y] = 0;
        }
    }

    private static boolean isValidMove(int direction) {
        return (direction != 1 || y + 1 < M) &&
                (direction != 2 || y - 1 >= 0) &&
                (direction != 3 || x - 1 >= 0) &&
                (direction != 4 || x + 1 < N);
    }

    private static void move(int direction) {
        int tmpBottom, tmpTop, tmpEast, tmpWest, tmpSouth, tmpNorth;
        switch (direction) {
            case 1:
                tmpBottom = east; tmpTop = west; tmpEast = top; tmpWest = bottom;
                bottom = tmpBottom; top = tmpTop; east = tmpEast; west = tmpWest;
                y += 1;
                break;
            case 2:
                tmpBottom = west; tmpTop = east; tmpEast = bottom; tmpWest = top;
                bottom = tmpBottom; top = tmpTop; east = tmpEast; west = tmpWest;
                y -= 1;
                break;
            case 3:
                tmpBottom = north; tmpTop = south; tmpSouth = bottom; tmpNorth = top;
                bottom = tmpBottom; top = tmpTop; south = tmpSouth; north = tmpNorth;
                x -= 1;
                break;
            case 4:
                tmpBottom = south; tmpTop = north; tmpSouth = top; tmpNorth = bottom;
                bottom = tmpBottom; top = tmpTop; south = tmpSouth; north = tmpNorth;
                x += 1;
                break;
        }
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