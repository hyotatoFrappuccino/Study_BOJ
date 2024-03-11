import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1924 {
    public static void main(String[] args) throws IOException {
        int day = getDay();
        switch (day) {
            case 0:
                System.out.println("SUN");
                break;
            case 1:
                System.out.println("MON");
                break;
            case 2:
                System.out.println("TUE");
                break;
            case 3:
                System.out.println("WED");
                break;
            case 4:
                System.out.println("THU");
                break;
            case 5:
                System.out.println("FRI");
                break;
            case 6:
                System.out.println("SAT");
                break;
        }
    }

    private static int getDay() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int count = 1;
        int curx = 1;
        int cury = 1;
        while (curx != x || cury != y) {
            count++;
            cury++;
            if ((cury == 29 && curx == 2) || (cury == 31 && (curx == 4 || curx == 6 || curx == 9 || curx == 11)) || (cury == 32 && (curx == 1 || curx == 3 || curx == 5 || curx == 7 || curx == 8 || curx == 10 || curx == 12))) {
                curx++;
                cury = 1;
            }
        }
        return count % 7;
    }
}
