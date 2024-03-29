import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P1431 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }
        list.sort(new serialComparator());
        for (String serial : list) {
            System.out.println(serial);
        }
    }

    private static class serialComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                int sum1 = 0;
                int sum2 = 0;
                for (int i = 0; i < o1.length(); i++) {
                    if (isNum(o1.charAt(i)))
                        sum1 += o1.charAt(i) - 48;
                    if (isNum(o2.charAt(i)))
                        sum2 += o2.charAt(i) - 48;
                }
                if (sum1 != sum2)
                    return sum1 - sum2;
                else
                    return o1.compareTo(o2);
            }

        }
    }

    private static boolean isNum(char c) {
        return c >= 48 && c <= 57;
    }
}
