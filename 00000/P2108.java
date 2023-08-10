import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P2108 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        // 산술평균
        System.out.println(Math.round((float) Arrays.stream(list).sum() /N));
        // 중앙값
        Arrays.sort(list);
        System.out.println(list[N / 2]);
        // 최빈값
        int[] freq = new int[8001];
        for (int i : list) {
            if (i >= 0) freq[i]++;
            else freq[4000 + Math.abs(i)]++;
        }

        int maxFreq = 0;
        for (int i : freq) {
            if (i > maxFreq) maxFreq = i;
        }
        List<Integer> freqList = new ArrayList<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == maxFreq) {
                if (i <= 4000) freqList.add(i);
                else freqList.add(-(i-4000));
            }
        }
        freqList.sort(Comparator.naturalOrder());
        if (freqList.size() >= 2)
            System.out.println(freqList.get(1));
        else
            System.out.println(freqList.get(0));

        // 범위
        int min = 4001;
        int max = -4001;
        for (int i : list) {
            if (i < min) min = i;
            if (i > max) max = i;
        }
        System.out.println(max - min);
    }
}
