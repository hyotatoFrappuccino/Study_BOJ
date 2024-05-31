import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P24751 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double a = Long.parseLong(br.readLine());
        double b = 100 - a;
        bw.append(String.valueOf(100 / a)).append("\n");
        bw.append(String.valueOf(100 / b));

        bw.flush();

        br.close();
        bw.close();
    }
}
