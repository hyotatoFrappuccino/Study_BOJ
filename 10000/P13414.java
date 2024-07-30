import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P13414 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < L; i++) {
            String id = br.readLine();
            if (list.contains(id))
                list.remove(id);
            list.add(id);
        }

        for (int i = 0; i < K; i++) {
            System.out.println(list.get(i));
        }
    }
}
