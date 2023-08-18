import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P26209 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String result = "S";
        for (int i = 0; i < 8; i++) {
            if (st.nextToken().equals("9"))
                result = "F";
        }
        System.out.println(result);
    }
}
