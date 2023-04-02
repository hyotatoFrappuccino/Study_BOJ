import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2744 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        for (char c : input){
            if (c >= 97) System.out.print(Character.toString(c - 32));
            else System.out.print(Character.toString(c + 32));
//            if (Character.isUpperCase(c))
        }
    }
}
