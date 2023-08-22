import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Objects;
import java.util.StringTokenizer;

public class P1016 {
    public static void main(String[] args) throws Exception {
        // 미해결
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger min = new BigInteger(st.nextToken());
        BigInteger max = new BigInteger(st.nextToken());
        int count = 0;
        for (BigInteger i = min; i.compareTo(max) <= 0; i = i.add(BigInteger.ONE)) {
            boolean res = true;
            System.out.print(i + " : ");
            for (BigInteger j = BigInteger.TWO; j.compareTo(i.sqrt()) <= 0; j = j.add(BigInteger.ONE)) {
                if (Objects.equals(i.divideAndRemainder(j.multiply(j))[1], BigInteger.ZERO)) {
                    res = false;
                    System.out.print(j + " ");
                    break;
                }
            }
            if (res) {
                count++;
            }
            System.out.println();
        }
        System.out.println(count);
    }
}
