import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class P1793 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();

        String input = "";
        // 백준 제출용
        while ((input = br.readLine()) != null) {
        // 인텔리제이용
//        while ((input = br.readLine()) != null & !input.isEmpty()) {
            list.add(Integer.parseInt(input));
        }

        BigInteger[] DP = new BigInteger[250 + 1];

        //기본값 설정
        DP[0] = new BigInteger("1");
        DP[1] = new BigInteger("1");
        DP[2] = new BigInteger("3");

        //테스트케이스가 여러개 들어오므로 미리 모든값을 계산해놓음
        for (int i = 3; i <= 250; i++) {
            DP[i] = DP[i - 1].add(DP[i - 2].multiply(new BigInteger("2")));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Integer num : list) {
            bw.append(DP[num].toString()).append("\n");
        }

        bw.flush();
        bw.close();
    }
}