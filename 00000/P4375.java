import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Objects;

public class P4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            int num = Integer.parseInt(input);
            // 각 자릿수가 모두 1로만 이루어진 n의 배수를 만들어주기 위해 BigInteger를 만들어준다.
            BigInteger bi = new BigInteger("1");
            while (true) {
                // bi를 나누면 몫과 나머지가 나오는데, [1]로 나머지를 추출하여 0인지 확인한다.
                // 0이면 bi의 자리수를 출력 후 종료하고 아니라면 1의 자리를 늘려가며 반복해 확인한다.
                if (Objects.equals(bi.divideAndRemainder(BigInteger.valueOf(num))[1], BigInteger.ZERO)) {
                    System.out.println(bi.toString().length());
                    break;
                }
                bi = bi.multiply(BigInteger.valueOf(10L)).add(BigInteger.ONE);
            }
        }
    }
}
