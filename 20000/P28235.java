import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P28235 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        //noinspection IfCanBeSwitch
        if (input.equals("SONGDO")) {
            System.out.println("HIGHSCHOOL");
        }
        else if (input.equals("CODE"))
            System.out.println("MASTER");
        else if (input.equals("2023"))
            System.out.println("0611");
        else
            System.out.println("CONTEST");
    }
}
