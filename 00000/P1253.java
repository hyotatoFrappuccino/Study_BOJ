import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(list);
        int count = 0;
        for (int i = 0; i < list.length; i++) {
//            System.out.println("index : " + i);
            int start = 0;
            int end = list.length - 1;
            while (start < end) {
//                System.out.println("start : " + start + ", end : " + end);
                if (start == i) {
                    start++;
                    continue;
                } else if (end == i) {
                    end--;
                    continue;
                }
                int sum = list[start] + list[end];
                if (sum == list[i]) {
                    count++;
                    break;
                } else if (sum > list[i]) {
                    end--;
                } else start++;
            }
        }

        System.out.println(count);
    }
}
