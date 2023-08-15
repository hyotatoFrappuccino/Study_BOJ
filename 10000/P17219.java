import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P17219 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        // 저장된 사이트 주소의 수
        int N = Integer.parseInt(st.nextToken());
        
        // 비밀번호를 찾으려는 사이트 주소의 수
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> list = new HashMap<>();

        // 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String domain = st.nextToken();
            String password = st.nextToken();
            list.put(domain, password);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(list.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }
}
