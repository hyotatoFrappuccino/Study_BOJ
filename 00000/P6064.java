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
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
//            if (M == x && N == y) {
//                bw.append("1\n");
//                continue;
//            }

            // process
            Year_P6064 X = new Year_P6064(M);
            Year_P6064 Y = new Year_P6064(N);
            boolean flag = false;
            for (int j = 1; j <= M * N; j++) {
//                System.out.println("j : " + j + ", x : " + X.getCurYear() + ", y : " + Y.getCurYear());
                if (X.getCurYear() == x && Y.getCurYear() == y) {
                    bw.append(String.valueOf(j)).append("\n");
                    flag = true;
                    break;
                }
                X.next();
                Y.next();
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

class Year_P6064 {
    private int curYear = 1;
    private final int maxYear;

    public Year_P6064(int maxYear) {
        this.maxYear = maxYear;
    }

    public int getCurYear() {
        return curYear;
    }

    public void next() {
        if (curYear++ == maxYear) {
            curYear = 1;
        }
    }
}
