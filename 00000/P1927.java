import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class P1927 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (!q.isEmpty()) {
                    bw.append(String.valueOf(q.poll())).append("\n");
                } else {
                    bw.append("0").append("\n");
                }
            } else {
                q.add(input);
            }
        }


        // output
        bw.flush();

        br.close();
        bw.close();
    }
}
