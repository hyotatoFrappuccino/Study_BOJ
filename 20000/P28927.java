import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P28927 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = sumTime(new StringTokenizer(br.readLine()));
        int mel = sumTime(new StringTokenizer(br.readLine()));
        if (max > mel)
            System.out.println("Max");
        else if (max < mel)
            System.out.println("Mel");
        else
            System.out.println("Draw");
    }

    public static int sumTime(StringTokenizer st) {
        int sum = 0;
        sum += Integer.parseInt(st.nextToken()) * 3;
        sum += Integer.parseInt(st.nextToken()) * 20;
        sum += Integer.parseInt(st.nextToken()) * 120;
        return sum;
    }
}
