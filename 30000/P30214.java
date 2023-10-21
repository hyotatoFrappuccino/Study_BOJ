import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P30214 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double S1 = Double.parseDouble(st.nextToken());
        double S2 = Double.parseDouble(st.nextToken());
        if (S1 >= (S2 / 2))
            System.out.println("E");
        else
            System.out.println("H");
    }
}
