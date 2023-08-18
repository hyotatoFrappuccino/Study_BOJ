import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P28113 {
    public static void main(String[] args) throws Exception {
        //noinspection DuplicatedCode
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        st.nextToken(); // 버스 > 지하철
        int A = Integer.parseInt(st.nextToken()); // 버스 도착시간
        int B = Integer.parseInt(st.nextToken()); // 지하철 도착시간
        if (A < B)
            System.out.println("Bus");
        else if (A > B)
            System.out.println("Subway");
        else
            System.out.println("Anything");
    }
}
