import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2444 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int SIZE = Integer.parseInt(br.readLine());
        for (int i = 0; i < SIZE; i++) {
            printChar(SIZE - i - 1, ' ');
            printChar(i * 2 + 1, '*');
            System.out.println();
        }
        for (int i = SIZE-1; i > 0 ; i--) {
            printChar(SIZE - i, ' ');
            printChar(i * 2 - 1, '*');
            System.out.println();
        }
    }

    public static void printChar(int n, char c){
        for (int i = 0; i < n; i++) {
            System.out.print(c);
        }
    }


}
