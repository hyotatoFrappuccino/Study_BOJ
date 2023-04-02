import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class P1316 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int res = 0;
//      단어 한개씩 입력을 받는다.
        for (int i = 0; i < num; i++) {
            String[] input = br.readLine().split("");
            boolean result = true;
            for (int j = 0; j < input.length - 1; j++) {
                if (!input[j].equals(input[j+1])){
                    for (int k = j+1; k < input.length; k++) {
                        if (input[j].equals(input[k])) {
                            result = false;
                            break;
                        }
                    }
                }
            }
            if (result) res += 1;

//            input에 대해서 1개씩 검사를 한다.
//            만약 뒤에 있는 문자가 다른데, 그 뒤부터 끝까지 해당 문자가 있으면 False 끝까지 없으면 True
        }
        System.out.println(res);
    }
}
