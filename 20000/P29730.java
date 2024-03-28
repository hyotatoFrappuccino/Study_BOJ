import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P29730 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> studyList = new ArrayList<>();
        List<Integer> bojList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String log = br.readLine();
            if (log.contains("boj.kr/")) {
                String[] split = log.split("boj.kr/");
                bojList.add(Integer.parseInt(split[1]));
            }
            else
                studyList.add(log);
        }
        studyList.sort(new studyComparator());
        Collections.sort(bojList);
        for (String s : studyList) {
            System.out.println(s);
        }
        for (Integer integer : bojList) {
            System.out.println("boj.kr/" + integer);
        }
    }

    private static class studyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() != o2.length())
                return o1.length() - o2.length();
            else
                return o1.compareTo(o2);
        }
    }
}
