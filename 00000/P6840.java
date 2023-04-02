import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P6840 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Comparator.naturalOrder());
        System.out.println(list.get(1));
    }
}
