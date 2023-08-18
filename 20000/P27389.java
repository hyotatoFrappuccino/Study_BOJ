import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P27389 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double num = Double.parseDouble(br.readLine()) / 4;
        String str = String.valueOf(num);
        str = str.split("\\.")[1];
        if (str.length() == 1 || str.charAt(1) == 0)
            System.out.printf("%.1f", num);
        else
            System.out.printf("%.2f", num);
    }
}
