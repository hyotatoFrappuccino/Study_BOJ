import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P24060 {
    static int count = 0;
    static boolean print = false;
    static int K;
    static int[] tmp = new int[500001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(A, 0, A.length - 1);
        if (!print) System.out.println("-1");
    }

    public static void merge_sort(int[] A, int p, int r) {
        if (p < r) {
            int q = (int) (double) ((p + r) / 2);
            merge_sort(A, p, q);
            merge_sort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public static void merge(int[] A, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 1;
        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
                print(A[i - 1]);
            }
            else {
                tmp[t++] = A[j++];
                print(A[j - 1]);
            }
        }
        while (i <= q) {
            tmp[t++] = A[i++];
            print(A[i - 1]);

        }
        while (j <= r) {
            tmp[t++] = A[j++];
            print(A[j - 1]);
        }
        i = p;
        t = 1;
        while (i <= r) A[i++] = tmp[t++];
    }

    public static void print(int num) {
        count++;
        if (count == K) {
            System.out.println(num);
            print = true;
        }
    }
}
