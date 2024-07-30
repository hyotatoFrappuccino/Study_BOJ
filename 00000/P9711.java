import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P9711 {
    static int T;
    static int[] P;
    static int[] Q;

    static StringBuilder output;

    static void input(String[] lines) {
        T = Integer.parseInt(lines[0]);
        P = new int[T];
        Q = new int[T];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(lines[i + 1]);
            P[i] = Integer.parseInt(st.nextToken());
            Q[i] = Integer.parseInt(st.nextToken());
        }
        output = new StringBuilder();
    }

    static String process() {
        // 피보나치 수 구하기
        BigInteger[] fibo = new BigInteger[10_000 + 1];
        fibo[1] = BigInteger.ONE;
        fibo[2] = BigInteger.ONE;
        for (int i = 3; i <= 10_000; i++) {
            fibo[i] = fibo[i - 1].add(fibo[i - 2]);
        }

        for (int i = 0; i < T; i++) {
            BigInteger remain = fibo[P[i]].remainder(new BigInteger(String.valueOf(Q[i])));
            output.append("Case #%d: %d\n".formatted(i + 1, remain));
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