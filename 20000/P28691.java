import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P28691 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        //noinspection IfCanBeSwitch
        if (input.equals("M"))
            System.out.println("MatKor");
        else if (input.equals("W"))
            System.out.println("WiCys");
        else if (input.equals("C"))
            System.out.println("CyKor");
        else if (input.equals("A"))
            System.out.println("AlKor");
        else if (input.equals("$"))
            System.out.println("$clear");
    }
}
