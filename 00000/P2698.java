import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2698 {
    static StringBuilder output;
    static int testcase;
    static int[] inputN;
    static int[] inputK;
    static int count;
    static int N;
    static int K;

    static void input(String[] lines) {
        testcase = Integer.parseInt(lines[0]);
        inputN = new int[testcase];
        inputK = new int[testcase];
        for (int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(lines[i + 1]);
            inputN[i] = Integer.parseInt(st.nextToken());
            inputK[i] = Integer.parseInt(st.nextToken());
        }
        output = new StringBuilder();
    }

    static String process() {
        for (int i = 0; i < testcase; i++) {
            N = inputN[i];
            K = inputK[i];
            count = 0;

            BigInteger bi = new BigInteger("0");
            for (int j = 0; j < ((1 << N) - 1); j++) {
                bi = bi.add(BigInteger.ONE);
                char[] list = bi.toString(2).toCharArray();
                int sum = 0;
                for (int k = 0; k < list.length - 1; k++) {
                    sum += (list[k] - '0') * (list[k + 1] - '0');
                }
                if (sum == K) count++;
            }
            output.append(count).append("\n");
        }

        return output.toString();
    }

//    static void dfs(int depth, int[] list) {
//        if (depth == N - 1) {
//            int sum = 0;
//            for (int i = 0; i < N - 1; i++) {
//                sum += list[i] * list[i + 1];
//            }
//            if (sum == K) {
//                count++;
//            }
//            return;
//        }
//
//        list[depth] = 0;
//        dfs(depth + 1, list);
//        list[depth] = 1;
//        dfs(depth + 1, list);
//    }

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