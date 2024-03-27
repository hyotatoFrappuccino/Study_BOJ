import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class P1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> list = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        StringBuilder sb = new StringBuilder("<");
        while (!list.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                list.add(list.remove());
            }
            sb.append(list.remove());
            sb.append(!list.isEmpty() ? ", " : "");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
