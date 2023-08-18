import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P4779 {
    static StringBuilder sb2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();
        // 인텔리제이용
        while ((input = br.readLine()) != null){
            // 백준 제출용
//        while ((input = br.readLine()) != null & !input.isEmpty()){
            int N = Integer.parseInt(input);
            sb2 = new StringBuilder();
            recur("-".repeat((int) Math.pow(3, N)));
            sb.append(sb2).append("\n");
        }
        System.out.println(sb);
    }

    public static void recur(String str) {
        int len = str.length();
        if (len >= 3) {
            recur(str.substring(0, len / 3));
            recur(" ".repeat(len / 3));
            recur(str.substring(len / 3 * 2, len));
        }
        else {
            sb2.append(str);
        }
    }
}
