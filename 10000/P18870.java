import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P18870 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double N = Double.parseDouble(br.readLine());
        double[] input = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double[] distinctInput = Arrays.stream(input).distinct().toArray();
        List<Double> list = Arrays.stream(distinctInput).boxed().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }
        StringBuilder sb = new StringBuilder();
        for(Double d : input) {
            sb.append(map.get(d)).append(" ");
        }
        System.out.println(sb);
    }
}
