import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2775 {
    public static int[][] people = new int[14][15];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 14; i++) {
            people[0][i] = i;
        }
        for (int i = 0; i < testcase; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(getPeople(k, n));
        }
    }

    public static int getPeople(int a, int b) {
        int sum = 0;
        for (int i = 1; i <= b; i++) {
            if (people[a-1][i] > 0) sum += people[a-1][i];
            else sum += getPeople(a-1, i);
        }
        return sum;
    }
}
