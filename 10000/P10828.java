import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class P10828 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            if (Objects.equals(input[0], "push")){
                list.add(Integer.parseInt(input[1]));
            } else if (Objects.equals(input[0], "pop")){
                System.out.println(list.size() != 0 ? list.remove(list.size() - 1) : -1);
            } else if (Objects.equals(input[0], "size")){
                System.out.println(list.size());
            } else if (Objects.equals(input[0], "empty")){
                System.out.println(list.size() == 0 ? 1 : 0);
            } else if (Objects.equals(input[0], "top")){
                System.out.println(list.size() != 0 ? list.get(list.size() - 1) : -1);
            }
        }
    }
}
