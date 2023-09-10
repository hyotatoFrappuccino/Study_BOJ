import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14501 {
    // 미풀이
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] listT = new int[N];
        int[] listP = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            listT[i] = Integer.parseInt(st.nextToken());
            listP[i] = Integer.parseInt(st.nextToken());
        }
        recur(0);
    }

    public static void recur(int depth) {

    }
}
