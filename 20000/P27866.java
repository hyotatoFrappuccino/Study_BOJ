import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P27866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int index = Integer.parseInt(br.readLine()) - 1;
        System.out.println(word.charAt(index));
    }
}