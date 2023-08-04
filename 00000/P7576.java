import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P7576 {
    static int M;
    static int N;
    static boolean change;
    static Map<Integer, List<Integer>> checkList = new HashMap<>();
    static int[][] matrix;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            List<Integer> list = new ArrayList<>();
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) list.add(j);
                matrix[i][j++] = num;
            }
            checkList.put(i, list);
        }
        int day = 0;
        while (true) {
            change = false;
            Map<Integer, List<Integer>> mapCopy = checkList.entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, e -> List.copyOf(e.getValue())));
            for (Map.Entry<Integer, List<Integer>> e : mapCopy.entrySet()) {
                int x = e.getKey();
                for (int y : e.getValue()) {
                    isValidPos(x - 1, y);
                    isValidPos(x, y - 1);
                    isValidPos(x, y + 1);
                    isValidPos(x + 1, y);
                }
            }
            if (change) {
                day++;
            }
            else break;
        }

        boolean done = true;
        for (int[] ints : matrix) {
            if (done) {
                for (int anInt : ints)
                    if (anInt == 0) {
                        done = false;
                        break;
                    }
            }
        }
        if (done) System.out.println(day);
        else System.out.println(-1);
    }

    public static void isValidPos(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < M && matrix[x][y] == 0) {
            matrix[x][y] = 1;
            List<Integer> list = checkList.get(x);
            list.add(y);
            checkList.put(x, list);
            change = true;
        }
    }
}
