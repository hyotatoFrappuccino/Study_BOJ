import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P9613 {
    static int T;
    static List<int[]> list;
    static StringBuilder output;
    static List<int[]> comb;

    static void input(String[] lines) {
        T = Integer.parseInt(lines[0]);
        list = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(lines[i + 1]);
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            list.add(arr);
        }
        comb = new ArrayList<>();
        output = new StringBuilder();
    }

    static String process() {
        for (int[] nums : list) {
            long sum = 0;
            comb = new ArrayList<>();

            dfs(nums, new int[2], 0, 0);

            for (int[] ints : comb) {
                int A = ints[0];
                int B = ints[1];
                sum += gcd(A, B);
            }

            output.append(sum).append("\n");
        }

        return output.toString();
    }

    static void dfs(int[] nums, int[] arr, int depth, int start) {
        if (depth == 2) {
//            System.out.println(Arrays.toString(arr));
            int[] result = new int[2];
            result[0] = arr[0];
            result[1] = arr[1];
            comb.add(result);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            arr[depth] = nums[i];
            dfs(nums, arr, depth + 1, i + 1);
        }
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
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