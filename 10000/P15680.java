import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class P15680 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (Objects.equals(br.readLine(), "0")) System.out.println("YONSEI");
        else System.out.println("Leading the Way to the Future");
    }
}
