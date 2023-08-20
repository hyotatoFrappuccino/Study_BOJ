import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P28490 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int frame = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
            if (max < frame) {
                max = frame;
            }
        }
        System.out.println(max);
    }
}
