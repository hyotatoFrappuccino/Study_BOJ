import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P1476 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        int[] years = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int inputE = years[0];
        int inputS = years[1];
        int inputM = years[2];


        // process
        Year e = new Year(15);
        Year s = new Year(28);
        Year m = new Year(19);

        int result = 1;

        if (inputE == 1 && inputS == 1 && inputM == 1) {
            bw.append("1");
            bw.flush();
            System.exit(0);
        }

        while (true) {
            e.next();
            s.next();
            m.next();
            result++;

            if (e.getCurYear() == inputE && s.getCurYear() == inputS && m.getCurYear() == inputM) {
                bw.append(String.valueOf(result));
                break;
            }
        }

        // output
        bw.flush();

        br.close();
        bw.close();
    }

}

class Year {
    int maxYear;
    int curYear;

    public Year(int maxYear) {
        this.curYear = 1;
        this.maxYear = maxYear;
    }

    public void next() {
        if (curYear++ == maxYear)
            curYear = 1;
    }

    public int getCurYear() {
        return curYear;
    }
}