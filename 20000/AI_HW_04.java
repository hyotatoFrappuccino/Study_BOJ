import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AI_HW_04 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int[][] cost = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            cost[i][0] = i;
        }
        for (int i = 0; i <= b.length(); i++) {
            cost[0][i] = i;
        }
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                char aCode = a.charAt(i - 1);
                char bCode = b.charAt(j - 1);

                // 동일한 경우
                int replaceCost = 0;
                // 대소문자만 다른 경우
                if (isAlphabet(aCode) && isAlphabet(bCode) && Math.abs(aCode - bCode) == 32)
                    replaceCost = 1;
                // 둘 다 숫자인 경우
                else if (isNumber(aCode) && isNumber(bCode))
                    replaceCost = Math.abs(aCode - bCode);
                // 하나는 알파벳, 다른 하나는 숫자인 경우
                else if (isAlphabet(aCode) && isNumber(bCode) || isNumber(aCode) && isAlphabet(bCode))
                    replaceCost = 7;
                // 둘 다 알파벳이면서 다른 경우
                else if (isAlphabet(aCode) && isAlphabet(bCode) && aCode != bCode)
                    replaceCost = 5;

                cost[i][j] = Math.min(cost[i - 1][j] + 5, Math.min(cost[i - 1][j - 1] + replaceCost, cost[i][j - 1] + 5));
            }
        }
        System.out.println(cost[a.length()][b.length()]);
        for (int[] ints : cost) {
            for (int j = 0; j < cost[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isAlphabet(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

    public static boolean isNumber(char c) {
        return (c >= 48 && c <= 57);
    }
}
