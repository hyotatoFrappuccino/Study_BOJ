import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class P14225 {
    static int N;
    static int[] S;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        S = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        IntStream.range(0, N).forEach(i -> S[i] = Integer.parseInt(st.nextToken()));

        int sum = Arrays.stream(S).sum();
        boolean[] sumList = new boolean[sum + 2];

        for (int i = 1; i < 1 << N; i++) {
            char[] binaryCharArray = toBinaryCharArray(i);
            int sumItem = IntStream.range(0, binaryCharArray.length).filter(j -> binaryCharArray[j] == '1').map(j -> S[j]).sum();
            sumList[sumItem] = true;
        }

        for (int i = 1; i < sum + 2; i++) {
            if (!sumList[i]) {
                bw.append(String.valueOf(i));
                break;
            }
        }
        // output
        bw.flush();

        br.close();
        bw.close();
    }

    public static char[] toBinaryCharArray(int number) {
        String binaryString = Integer.toBinaryString(number);
        String paddedBinaryString = "0".repeat(Math.max(0, N - binaryString.length())) + binaryString;
        return paddedBinaryString.toCharArray();
    }
}
