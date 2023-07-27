import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1427 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] list = br.readLine().toCharArray();
        Arrays.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = list.length - 1; i >= 0; i--) {
            sb.append(list[i]);
        }
        System.out.println(sb);
    }
}
