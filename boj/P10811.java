import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P10811 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = i+1;
        }

//        M번(횟수) 바구니의 순서를 역순으로 만듦
//        역순으로 만들 범위를 정하고 진행

        for (int l = 0; l < M; l++) {
            input = br.readLine().split(" ");
            int i = Integer.parseInt(input[0]);
            int j = Integer.parseInt(input[1]);
            int[] temp = new int[j-i+1];
            for (int k = 0; k <= j-i; k++) {
                temp[k] = list[j-1-k];
            }
//            ex 1 4
//            원본 -> temp (k)
//            3     0
//            2     1
//            1     2
//            0     3

//            ex 3 4
//            3     0
//            4     1
            System.arraycopy(temp, 0, list, i - 1, temp.length);


        }
        for (int n : list) {
            System.out.printf(n + " ");
        }

    }
}
