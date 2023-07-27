import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11651 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input;
        xy2[] list = new xy2[N];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            list[i] = new xy2(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
        Arrays.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(list[i]).append("\n");
        }
        System.out.println(sb);
    }
}

class xy2 implements Comparable<xy2> {
    public int x;
    public int y;

    public xy2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(xy2 o) {
        if (this.y == o.y) {
            return this.x - o.x;
        } else return this.y - o.y;
    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }
}
