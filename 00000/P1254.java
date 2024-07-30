import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1254 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder(br.readLine());
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < input.length() - 1; i++) {
            for (int range = i; range <= input.length(); ) {
                if ((i - range) < 0 || (i + range) >= input.length() || input.charAt(i - range) != input.charAt(i + range))
                    break;
                range++;
                if ((i - range) < 0 || (i + range) >= input.length()) {
                    result = input.length() + input.length() - ((range - 1) * 2) - 1;
                    break;
                }
            }
        }
        result = Math.min(result, check(input));

        int index = input.length() - 2;
        while (!isPalindrome(input.toString())) {
            input.append(input.charAt(index--));
        }
        result = Math.min(result, input.length());
        System.out.println(result);
    }

    private static int check(StringBuilder input) {
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                StringBuilder str1 = new StringBuilder(input.substring(i + 1, input.length()));
                str1.reverse();
                if (i - str1.length() < input.length() && i - str1.length() >= 0) {
                    String str2 = input.substring(i + 1 - str1.length(), i + 1);
                    if (str1.toString().equals(str2)) {
                        return input.length() * 2 - str1.length() * 2;
                    }
                }
            }
        }
        return input.length() * 2;
    }

    private static boolean isPalindrome(String word) {
        if ((word.length() & 1) == 0)
            return false;
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1))
                return false;
        }
        return true;
    }
}
