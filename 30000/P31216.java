import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P31216 {
    static StringBuilder output;
    static int T;
    static int[] N;
    static boolean[] isPrime;
    static int[] primeNumbers;
    static int[] resultPrime;

    static void input(String[] lines) {
        T = Integer.parseInt(lines[0]);
        N = new int[T];
        for (int i = 0; i < T; i++) {
            N[i] = Integer.parseInt(lines[i + 1]);
        }
        primeNumbers = new int[318137 + 1];
        resultPrime = new int[3000];
        output = new StringBuilder();
    }

    static String process() {
        make_prime(318137);

        int index = 0;
        int j = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primeNumbers[index++] = i;
                if (isPrime[index]) {
                    resultPrime[j++] = i;
                }
            }
        }

        for (int n : N) {
            output.append(resultPrime[n - 1]).append("\n");
        }
        return output.toString();
    }

    // N 이하 소수 생성 메소드
    public static void make_prime(int n){
        isPrime = new boolean[n+1]; // N번째의 수 까지 받기위해 N+1까지 동적할당

        for(int i = 0; i < isPrime.length; i++){
            isPrime[i] = true; // boolean배열의 default값은 false이므로 true로 바꿔주기
        }

        isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아니니깐 false

        for(int i = 2; i <= Math.sqrt(n); i++){ // 2부터 n의 제곱근까지의 모든 수를 확인
            if(isPrime[i]){ // 해당수가 소수라면, 해당수를 제외한 배수들을 모두 false 처리하기
                for(int j = i*i; j<= n; j += i){//그 이하의 수는 모두 검사했으므로 i*i부터 시작
                    isPrime[j] = false;
                }
            }
        }
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