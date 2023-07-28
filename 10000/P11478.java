import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P11478 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        Set<String> set = new HashSet<>();
        for (int subsize = 1; subsize <= word.length(); subsize++)
            for (int start = 0; start <= word.length() - subsize; start++)
                set.add(word.substring(start, start + subsize));
        System.out.println(set.size());
    }
}
