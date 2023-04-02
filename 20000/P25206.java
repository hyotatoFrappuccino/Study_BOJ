import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P25206 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        전공평점 계산 프로그램
//        과목별 (학점 X 과목평점)의 합을 학점의 총합으로 나눔
//        4.5 / 4.0 / 3.5 / 3.0 / 2.5 / 2.0 / 1.5 / 1.0 / 0.0
//        A+  / A0   / B+  / B0   / C+  / C0  / D+  / D0   / F
//        P/F 과목의 경우 P인 과목은 계산에서 제외

//        입력 : 과목명, 학점, 등급 (20줄 입력)
//        출력 : 전공평점 출력
//        제한 : 학점은 1.0, 2.0, 3.0, 4.0 중 하나, 등급은 A+ ~ F, P 중 하나, 적어도 한 과목은 등급이 P가 아님이 보장

//        이수학점
        double totalCredit = 0;
//        이수과목의 학점 * 과목평점
        double totalScore = 0;
        HashMap<String, Double> scoreList = new HashMap<>();
        scoreList.put("A+", 4.5);
        scoreList.put("A0", 4.0);
        scoreList.put("B+", 3.5);
        scoreList.put("B0", 3.0);
        scoreList.put("C+", 2.5);
        scoreList.put("C0", 2.0);
        scoreList.put("D+", 1.5);
        scoreList.put("D0", 1.0);
        scoreList.put("F", 0.0);

        for (int i = 0; i < 20; i++) {
            String[] input = br.readLine().split(" ");
            String score = input[2];
            if (!score.equals("P")) {
                totalCredit += Double.parseDouble(input[1]);
                totalScore += Double.parseDouble(input[1]) * scoreList.get(score);
            }
        }
        System.out.printf("%.6f", totalScore / totalCredit);
    }
}
