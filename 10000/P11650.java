import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11650 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input;
        xy[] list = new xy[N];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            list[i] = new xy(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
        Arrays.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(list[i]).append("\n");
        }
        System.out.println(sb);
    }
}

class xy implements Comparable<xy> {
    public int x;
    public int y;

    public xy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(xy o) {
        if (this.x == o.x) {
            return this.y - o.y;
        } else return this.x - o.x;
    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }
}
