import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P5597 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> stack = new LinkedList<>();
        for (int i = 1; i <= 30; i++) {
            stack.add(i);
        }
        for (int i = 0; i < 28; i++) {
            stack.remove(Integer.parseInt(br.readLine()));
        }
        System.out.println(stack.remove());
        System.out.println(stack.remove());
    }
}
