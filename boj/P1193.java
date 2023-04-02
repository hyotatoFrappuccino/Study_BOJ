import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1193 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = 0;
        int added = 0;
        int input = Integer.parseInt(br.readLine());
        if (input == 1)
            System.out.println("1/1");
        else {
            while (added < input){
                length += 1;
                added += length;
            }
//            length가 짝수이면 front = 1, end = length
//            length가 홀수이면 front = length, end = 1
            int front = 0;
            int end = 0;
            if (length % 2 == 0){
                front = length;
                end = 1;
            }
            else{
                front = 1;
                end = length;
            }
            int order = added - input;
            if (length % 2 == 0) {
                for (int i = 0; i < order; i++) {
                    front -= 1;
                    end += 1;
                }
            }
            else{
                for (int i = 0; i < order; i++) {
                    front += 1;
                    end -= 1;
                }

            }
            System.out.println(front+"/"+end);
        }
    }
}
