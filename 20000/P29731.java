import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P29731 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        list.add("Never gonna give you up");
        list.add("Never gonna let you down");
        list.add("Never gonna run around and desert you");
        list.add("Never gonna make you cry");
        list.add("Never gonna say goodbye");
        list.add("Never gonna tell a lie and hurt you");
        list.add("Never gonna stop");
        boolean result = false;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            if (!list.contains(br.readLine())) {
                result = true;
                break;
            }
        }
        if (result) System.out.println("Yes");
        else System.out.println("No");
    }
}
