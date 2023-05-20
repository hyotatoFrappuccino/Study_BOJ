import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P5086 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean factor = false;
        boolean multiple = false;
        while (true){
            int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n1 = list[0];
            int n2 = list[1];
            if (n1 == 0 && n2 == 0) break;
            if (n2 % n1 == 0) factor = true;
            if (n1 % n2 == 0) multiple = true;
            if (factor) System.out.println("factor");
            else if (multiple) System.out.println("multiple");
            else System.out.println("neither");
            factor = false;
            multiple = false;
        }
    }
}
