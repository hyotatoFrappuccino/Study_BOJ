import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P6571 {
    static BigInteger[] A;
    static BigInteger[] B;
    static List<BigInteger> fibo;
    static StringBuilder output;

    static void input(String[] lines) {
        BigInteger max = BigInteger.ZERO;
        A = new BigInteger[lines.length - 1];
        B = new BigInteger[lines.length - 1];
        for (int i = 0; i < lines.length - 1; i++) {
            StringTokenizer st = new StringTokenizer(lines[i]);
            A[i] = new BigInteger(st.nextToken());
            B[i] = new BigInteger(st.nextToken());
            max = max.max(B[i]);
        }

        fibo = new ArrayList<>();
        fibo.add(BigInteger.ONE);
        fibo.add(new BigInteger("2"));
        for (int i = 2; true; i++) {
            fibo.add(new BigInteger(String.valueOf(fibo.get(i - 1).add(fibo.get(i - 2)))));
            if (fibo.get(i).compareTo(max) > 0) {
                break;
            }
        }
        output = new StringBuilder();
    }

    static String process() {
        for (int i = 0; i < A.length; i++) {
            int count = 0;
            for (BigInteger fiboNum : fibo) {
                if (fiboNum.compareTo(A[i]) >= 0 && fiboNum.compareTo(B[i]) <= 0) {
                    count++;
                }
            }
            output.append(count).append("\n");
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