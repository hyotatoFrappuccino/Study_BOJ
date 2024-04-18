import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class P1759 {
	private static String[] readLines() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null && !line.equals("")) {
            lines.add(line);
        }

        br.close();

        String[] linesArray = new String[lines.size()];
        linesArray = lines.toArray(linesArray);

        return linesArray;
    }


    static String[] input;
    static int L;
    static int C;
    static List<Character> list;
    static StringBuilder sb;
    static void input(String[] lines) {
        input = lines[0].split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        list = new LinkedList<>();
        for (String str : lines[1].split(" ")) {
            list.add(str.charAt(0));
        }
        list.sort(Comparator.naturalOrder());
        sb = new StringBuilder();
    }
    
    static String process(){
        dfs(new char[L], 0, L, list);
        return sb.toString();
    }

    public static void dfs(char[] result, int depth, int maxDepth, List<Character> list) {
        if (depth == maxDepth) {
            if (isValid(result)) {
                for (char c : result) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }

        for (Character c : list) {
//            System.out.println("depth = " + depth + ", i = " + i + ", result.length : " + result.length + ", list.length : " + list.length + ", maxDepth : " + maxDepth);
            if (depth > 0 && result[depth - 1] > c) continue;
            result[depth] = c;
            List<Character> list2 = new LinkedList<>(list);
            list2.remove(c);
            dfs(result, depth + 1, maxDepth, list2);
        }
    }

    /**
     * 문자열이 최소 한개의 모음과 최소 두개의 자음으로 구성되어 있는지 여부
     */
    private static boolean isValid(char[] result) {
        int vowel = 0;
        int consonant = 0;

        for (char c : result) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                vowel++;
            else
                consonant++;
        }

        return vowel >= 1 && consonant >= 2;
    }

    public static void main(String[] args) throws IOException {
        input(readLines());
        System.out.println(process());
    }
}