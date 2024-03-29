import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1254 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder(br.readLine());
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                StringBuilder str1 = new StringBuilder(input.substring(i + 1, input.length()));
                str1.reverse();
                if (i - str1.length() < input.length() && i - str1.length() >= 0) {
                    String str2 = input.substring(i + 1 - str1.length(), i + 1);
                    if (str1.toString().equals(str2)) {
                        System.out.println(input.length() * 2 - str1.length() * 2);
                        System.out.println(str1);
                        System.out.println(str2);
                        System.exit(0);
                    }
                }
            }
        }

        int index = input.length() - 2;
        while (!isPalindrome(input.toString())) {
            input.append(input.charAt(index--));
        }
        System.out.println(input.length());
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
