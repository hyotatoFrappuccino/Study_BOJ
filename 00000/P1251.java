import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P1251 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        List<String> list = new ArrayList<>();

        for (int i = 1; i < word.length() - 1; i++) {
            for (int j = i + 1; j < word.length(); j++) {
                String s1 = word.substring(0, i);
                String s2 = word.substring(i, j);
                String s3 = word.substring(j);

                StringBuilder sb = new StringBuilder();

                for (int k = s1.length() - 1; k >= 0; k--) {
                    sb.append(s1.charAt(k));
                }

                for (int k = s2.length() - 1; k >= 0; k--) {
                    sb.append(s2.charAt(k));
                }

                for (int k = s3.length() - 1; k >= 0; k--) {
                    sb.append(s3.charAt(k));
                }

                list.add(sb.toString());
            }
        }

        list.sort(Comparator.naturalOrder());

        System.out.println(list.get(0));
    }
}
