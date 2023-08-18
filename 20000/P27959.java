import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P27959 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        if (100 * Integer.parseInt(st.nextToken()) >= Integer.parseInt(st.nextToken())) System.out.println("Yes");
        else System.out.println("No");
    }
}
