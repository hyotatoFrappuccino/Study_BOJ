import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1152 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input.equals(" ")){
            System.out.println(0);
        }
        else{
            System.out.println(input.trim().split(" ").length);
        }
    }
}
