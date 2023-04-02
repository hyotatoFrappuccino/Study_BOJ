import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P14652 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        번호 K만 앎
//        세로 N, 가로 M 으로 N <= M
//        입력 : n, m, k
//        출력 : 좌표
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];
        int K = input[2];
        System.out.print(K/M + " ");
        System.out.println(K - (M * (K/M)));
    }
}
