import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2750 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
//        Arrays.sort(list);
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (list[j] > list[j+1]) {
                    swap(list, j, j+1);
                }
            }
        }
        for (int i : list) {
            System.out.println(i);
        }
    }

    static void swap(int[] list, int a, int b) {
        int tmp = list[b];
        list[b] = list[a];
        list[a] = tmp;
    }
}
