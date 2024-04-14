import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P14500 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        int max = 0;
        List<int[][]> shapes = new ArrayList<>();
        shapes.add(new int[][]{{1, 1, 1, 1}});
        shapes.add(new int[][]{{1}, {1}, {1}, {1}});
        shapes.add(new int[][]{{1,1}, {1, 1}});
        shapes.add(new int[][]{{1,1}, {0,1}, {0,1}});
        shapes.add(new int[][]{{1,1}, {1,0}, {1,0}});
        shapes.add(new int[][]{{0,1}, {0,1}, {1,1}});
        shapes.add(new int[][]{{1,0}, {1,0}, {1,1}});
        shapes.add(new int[][]{{1,1,1}, {0,0,1}});
        shapes.add(new int[][]{{0,0,1}, {1,1,1}});
        shapes.add(new int[][]{{1,0,0}, {1,1,1}});
        shapes.add(new int[][]{{1,1,1}, {1,0,0}});
        shapes.add(new int[][]{{1,0}, {1,1}, {0,1}});
        shapes.add(new int[][]{{0,1}, {1,1}, {1,0}});
        shapes.add(new int[][]{{0,1,1}, {1,1,0}});
        shapes.add(new int[][]{{1,1,0}, {0,1,1}});
        shapes.add(new int[][]{{0,1,0}, {1,1,1}});
        shapes.add(new int[][]{{1,1,1}, {0,1,0}});
        shapes.add(new int[][]{{0,1}, {1,1}, {0,1}});
        shapes.add(new int[][]{{1,0}, {1,1}, {1,0}});

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int[][] shape : shapes) {
            for (int rowStart = 0; rowStart <= N - shape.length; rowStart++) {
                for (int colStart = 0; colStart <= M - shape[0].length; colStart++) {
                    int sum = 0;
                    for (int i = 0; i < shape.length; i++) {
                        for (int j = 0; j < shape[0].length; j++) {
                            if (shape[i][j] == 1)
                                sum += matrix[rowStart + i][colStart + j];
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
        }

        bw.append(String.valueOf(max));
        bw.flush();

        br.close();
        bw.close();
    }
}
