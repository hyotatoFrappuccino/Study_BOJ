import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1500 {
    static int S;
    static int K;
    static int[] list;
    static StringBuilder output;

    static void input(String[] lines) {
        StringTokenizer st = new StringTokenizer(lines[0]);
        S = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new int[K];
        output = new StringBuilder();
    }

    static String process() {
        int initNum = S / K;
        for (int i = 0; i < K; i++) {
            list[i] = initNum;
        }

        int last = S - (initNum) * K;
        for (int i = 0; i < last; i++) {
            list[i]++;
        }

        BigInteger bi = new BigInteger("1");
        for (int i : list) {
            bi = bi.multiply(new BigInteger(String.valueOf(i)));
        }

        output.append(bi);
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