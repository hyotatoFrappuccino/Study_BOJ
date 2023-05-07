import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11005 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long N = Long.parseLong(input[0]);
        int B = Integer.parseInt(input[1]);
        StringBuilder sb = new StringBuilder();
        long cur = N;
        // 몫이 0이 될 때까지 반복한다.
        while (cur > 0) {
            // 나머지가 10보다 작으면 그대로 추가한다.
            if (cur % B < 10) {
                sb.append(cur % B);
            // 나머지가 10보다 크다면 10진법으로 나타낼 수 없기 때문에, 10을 빼준 후 아스키 'A' 를 더해 A(10), B(11), ... Z(35) 등으로 나타내준다. 이를 char로 변환해주어야 문자가 된다.
            } else {
                sb.append((char) (cur % B - 10 + 'A'));
            }
            // 계속 B로 나눈다.
            cur /= B;
        }
        // 역순으로 더해야 하므로 더해진 값들을 역순으로 바꿔준다.
        System.out.println(sb.reverse());
    }
}
