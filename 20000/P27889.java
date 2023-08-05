import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P27889 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input.equals("NLCS"))
            System.out.println("North London Collegiate School");
        else if (input.equals("BHA"))
            System.out.println("Branksome Hall Asia");
        else if (input.equals("KIS"))
            System.out.println("Korea International School");
        else if (input.equals("SJA"))
            System.out.println("St. Johnsbury Academy");
    }
}
