import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16927 {
    static int N;
    static int M;
    static long R;
    static int[][] matrix;
    static StringBuilder output;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Long.parseLong(st.nextToken());
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(lines[i + 1]);
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        output = new StringBuilder();
    }

    static String process() {
        for (int level = 0; level < Math.min(N, M) / 2; level++) {
            Deque<Integer> q = new LinkedList<>();
            int i = level;
            int j = level;

            for (; i < N - level; i++) q.add(matrix[i][j]);
            i--; j++;

            for (; j < M - level; j++) q.add(matrix[i][j]);
            j--; i--;

            for (; i >= level; i--) q.add(matrix[i][j]);
            i++; j--;
            for (; j > level; j--) q.add(matrix[i][j]);


            for (int k = 0; k < R % ((N + M - level * 4L - 2L) * 2L); k++) q.addFirst(q.pollLast());


            i = level;
            j = level;

            for (; i < N - level; i++) matrix[i][j] = q.poll();
            i--; j++;

            for (; j < M - level; j++) matrix[i][j] = q.poll();
            j--; i--;

            for (; i >= level; i--) matrix[i][j] = q.poll();
            i++; j--;
            for (; j > level; j--) matrix[i][j] = q.poll();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                output.append(matrix[i][j]);
                if (j < M - 1) output.append(" ");
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