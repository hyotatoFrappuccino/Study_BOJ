import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P30676 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N < 425)
            System.out.println("Violet");
        else if (N < 450)
            System.out.println("Indigo");
        else if (N < 495)
            System.out.println("Blue");
        else if (N < 570)
            System.out.println("Green");
        else if (N < 590)
            System.out.println("Yellow");
        else if (N < 620)
            System.out.println("Orange");
        else
            System.out.println("Red");
    }
}
