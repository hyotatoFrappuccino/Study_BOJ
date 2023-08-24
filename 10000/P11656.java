import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class P11656 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            list.add(input.substring(i));
        }
        list.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (String str : list)
            sb.append(str).append("\n");
        System.out.println(sb);
    }
}
