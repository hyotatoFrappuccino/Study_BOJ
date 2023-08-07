import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P24511 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] qs = new int[N];
        int[] list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            qs[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] list2 = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            list2[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int count = 0; // < M 까지
        int index = N - 1;
        while (count < M && index >= 0) {
            if (qs[index] == 0) {
                sb.append(list[index]).append(" ");
                count++;
            }
            index--;
        }
        index = 0;
        while (count < M) {
            sb.append(list2[index++]).append(" ");
            count++;
        }
        System.out.println(sb);
    }
}
