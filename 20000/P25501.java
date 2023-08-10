import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P25501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            isPalindrome(word, 0, 0);
        }
    }

    public static void isPalindrome(String word, int index, int count) {
        count++;
        if (index >= word.length() / 2)
            System.out.println("1 " + count);
        else if (word.charAt(index) == word.charAt(word.length() - 1 - index))
            isPalindrome(word, index + 1, count);
        else
            System.out.println("0 " + count);

    }
}
