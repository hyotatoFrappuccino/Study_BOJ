import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1157 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int[] list = new int['z' - 'a'+1];
        for (char c : input) {
            if (c >= 'a')
                c -= 32;
            list[c-'A'] += 1;
        }
        int maxindex = -1;
        int max = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > max) {
                maxindex = i;
                max = list[i];
            }
        }
        int maxcount = 0;
        for (int i : list) {
            if (i == max)
                maxcount += 1;
        }
        if (maxcount > 1)
            System.out.println("?");
        else
            System.out.println((char) ('A' + maxindex));
    }
}
