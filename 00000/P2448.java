import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P2448 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> star = new ArrayList<>();
        star.add("  *  ");
        star.add(" * * ");
        star.add("*****");

        for (int i = 6; i <= N; i *= 2) {
            List<String> temp = new ArrayList<>(star);
            star = new ArrayList<>();
            for (String s : temp) {
                star.add(" ".repeat(i / 2) + s + " ".repeat(i / 2));
            }
            for (String s : temp) {
                star.add(s + " " + s);
            }
        }
        for (String s : star) {
            System.out.println(s);
        }

    }
}
