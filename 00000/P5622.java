import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P5622 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        int minTime = 0;
        for (String str : input){
            if (str.equals("S")) minTime += 8;
            else if (str.equals("V")) minTime += 9;
            else if (str.equals("Y") || str.equals("Z")) minTime += 10;
            else{
                minTime += ((((int) str.charAt(0)) - 65 ) / 3 ) + 3;
            }
        }
        System.out.println(minTime);
    }

}
