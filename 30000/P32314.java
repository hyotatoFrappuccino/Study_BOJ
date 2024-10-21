import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P32314 {
    // A : 암페어
    // W : 와트
    // V : 볼트
    static int A, W, V;

    static void input(String[] lines) {
        A = Integer.parseInt(lines[0]);
        StringTokenizer st = new StringTokenizer(lines[1]);
        W = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
    }

    static String process() {
        if (W / V >= A) {
            return "1";
        } else {
            return "0";
        }
    }

    public static void main(String[] args) throws IOException {
        input(readLines());
        System.out.println(process());
    }

    private static String[] readLines() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            lines.add(line);
        }
        br.close();

        String[] linesArray = new String[lines.size()];
        linesArray = lines.toArray(linesArray);
        return linesArray;
    }
}