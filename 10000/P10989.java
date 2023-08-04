import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10989 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i : list)
            sb.append(i).append("\n");
        System.out.println(sb);
    }
}
