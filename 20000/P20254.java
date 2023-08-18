import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20254 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        System.out.println(56 * Integer.parseInt(st.nextToken()) + 24 * Integer.parseInt(st.nextToken()) + 14 * Integer.parseInt(st.nextToken()) + 6 * Integer.parseInt(st.nextToken()));
    }
}
