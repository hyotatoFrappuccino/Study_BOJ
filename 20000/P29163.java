import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P29163 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int countOdd = 0; // 홀수
        int countEven = 0; // 짝수
        for (int i = 0; i < N; i++) {
            if ((Integer.parseInt(st.nextToken()) & 1) == 0)
                countEven++;
            else
                countOdd++;
        }
        if (countEven > countOdd)
            System.out.println("Happy");
        else
            System.out.println("Sad");
    }
}
