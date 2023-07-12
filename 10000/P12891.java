import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P12891 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int S = input[0];
        int P = input[1];
        String text = br.readLine();
        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int A = input[0];
        int C = input[1];
        int G = input[2];
        int T = input[3];

        int start = 0;
        int result = 0;
        String pwd = text.substring(0, P);
        int countA = 0;
        int countC = 0;
        int countG = 0;
        int countT = 0;
        for (char c : pwd.toCharArray()) {
            if (c == 'A') countA++;
            else if (c == 'C') countC++;
            else if (c == 'G') countG++;
            else countT++;
        }

        while (start + P < S) {
            if (countA >= A && countC >= C && countG >= G && countT >= T) result++;
            char c = text.charAt(start);
            if (c == 'A') countA--;
            else if (c == 'C') countC--;
            else if (c == 'G') countG--;
            else countT--;
            if (start + P < S) {
                c = text.charAt(start + P);
                if (c == 'A') countA++;
                else if (c == 'C') countC++;
                else if (c == 'G') countG++;
                else countT++;
            }
            start++;
        }
        if (countA >= A && countC >= C && countG >= G && countT >= T) result++;
        System.out.println(result);
    }
}
