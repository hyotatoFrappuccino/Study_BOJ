import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2587 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] score = new int[5];
        for (int i = 0; i < 5; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(score);
        System.out.println(Arrays.stream(score).sum()/5);
        System.out.println(score[2]);
    }
}
