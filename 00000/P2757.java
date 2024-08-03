import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P2757 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] list = br.readLine().split("R");
            list = list[1].split("C");
            int n = Integer.parseInt(list[0]);
            int m = Integer.parseInt(list[1]);

            //debug
//            System.out.println("n = " + n + ", m = " + m);

            if (n == 0 && m == 0)
                break;

            System.out.println(m / 26);

            List<Integer> result = new ArrayList<>();
            result.add(65);

            for (int i = 0; i < m; i++) {

            }
        }
    }

//    private static int
}
