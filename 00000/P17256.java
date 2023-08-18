import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17256 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int az = Integer.parseInt(st.nextToken());
        int ay = Integer.parseInt(st.nextToken());
        int ax = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int cz = Integer.parseInt(st.nextToken());
        int cy = Integer.parseInt(st.nextToken());
        int cx = Integer.parseInt(st.nextToken());
        System.out.println((cz - ax) + " " + (cy / ay) + " " + (cx - az));
    }
}
