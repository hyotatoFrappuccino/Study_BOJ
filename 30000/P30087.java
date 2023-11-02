import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P30087 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        map.put("Algorithm", "204");
        map.put("DataAnalysis", "207");
        map.put("ArtificialIntelligence", "302");
        map.put("CyberSecurity", "B101");
        map.put("Network", "303");
        map.put("Startup", "501");
        map.put("TestStrategy", "105");
        for (int i = 0; i < N; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }
}
