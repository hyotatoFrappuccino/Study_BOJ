import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.junit.Test;
import static org.junit.Assert.*;
public class P17413 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(stringFunc(br.readLine()));
    }

    public static String stringFunc(String input) {
        for(char c : input.toCharArray()) {
            if (c == '<') {

            }
        }
    }

    @Test
    public void test() {
        assertEquals("noojkeab enilno egduj", stringFunc("baekjoon online judge"));
        assertEquals("<open>gat<close>", stringFunc("<open>tag<close>"));
        assertEquals("<ab cd>fe hg<ij kl>", stringFunc("<ab cd>ef gh<ij kl>"));
        assertEquals("1eno 2owt 3eerht rruof4 evif5 xis6", stringFunc("one1 two2 three3 4fourr 5five 6six"));
        assertEquals("<int><max>7463847412<long long><max>7085774586302733229", stringFunc("<int><max>2147483647<long long><max>9223372036854775807"));
        assertEquals("<problem>31471<is hardest>melborp reve<end>", stringFunc("<problem>17413<is hardest>problem ever<end>"));
        assertEquals("<   space   >ecaps ecaps ecaps<    spa   c e>", stringFunc("<   space   >space space space<    spa   c e>"));
    }
}
