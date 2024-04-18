import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P6064 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            // input
            @SuppressWarnings("DuplicatedCode")
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            // process
            boolean flag = false;
            for (int j = x; j <= M * N; j += M) {
                if (j % N == y) {
                    bw.append(String.valueOf(j + 1)).append("\n");
                    flag = true;
                    break;
                }
            }
            if (!flag)
                bw.append("-1\n");

        }
        // output
        bw.flush();

        br.close();
        bw.close();
    }
}