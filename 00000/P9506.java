import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P9506 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (((input = br.readLine()) != null) && (!input.equals("-1"))) {
            int num = Integer.parseInt(input);
            int sum = 0;
            List<Integer> divisorList = new ArrayList<>();
            for (int i = 1; i <= num / 2; i++) {
                if (num % i == 0) {
                    sum += i;
                    divisorList.add(i);
                }
            }
            if (num == sum) {
                System.out.printf(num + " = ");
                for (int j = 0; j < divisorList.size(); j++) {
                    if (j < divisorList.size() - 1)
                        System.out.print(divisorList.get(j) + " + ");
                    else {
                        System.out.println(divisorList.get(j));
                    }
                }
            } else
                System.out.println(num + " is NOT perfect.");
        }
    }
}
