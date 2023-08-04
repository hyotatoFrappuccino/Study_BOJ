import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P1269 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sizeA = Integer.parseInt(st.nextToken());
        int sizeB = Integer.parseInt(st.nextToken());
        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < sizeA; i++) {
            setA.add(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < sizeB; i++) {
            setB.add(st.nextToken());
        }
        Set<String> resultA = new HashSet<>(setA);
        resultA.removeAll(setB);
        Set<String> resultB = new HashSet<>(setB);
        resultB.removeAll(setA);
        System.out.println(resultA.size() + resultB.size());
    }
}
