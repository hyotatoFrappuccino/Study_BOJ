import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class GetTestcase {
    static final String problemNum = "14501";
    public static void main(String[] args) throws Exception {
        String URL = "https://www.acmicpc.net/problem/" + problemNum;
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36";

        Document doc = Jsoup.connect(URL).userAgent(userAgent).get();
        // 예제 입력과 출력을 담고 있는 섹션을 선택합니다.
        Elements sections = doc.select("section[id^=sampleinput], section[id^=sampleoutput]");
        // 파일 저장 경로 설정
        File directory = new File("BOJ\\testcase");
        if (!directory.exists()) {
            directory.mkdirs(); // 디렉토리가 존재하지 않으면 생성합니다.
        }

        int fileIndex = 1;
        String inFile = "", outFile = "";

        // 선택한 섹션을 순회합니다.
        for (Element section : sections) {
            // 섹션 내의 <pre> 태그를 선택합니다.
            Element pre = section.select("pre.sampledata").first();
            // <pre> 태그 안의 내용을 가져옵니다.
            String content = pre.text();


            // 홀수 번째 content는 .in 파일에, 짝수 번째 content는 .out 파일에 저장합니다.
            if (fileIndex % 2 == 1) {
                inFile = problemNum + "_" + ((fileIndex++ + 1) / 2) + ".in";
                saveToFile(directory.getAbsolutePath() + "\\" + inFile, content);
                System.out.println("Saved " + inFile);
//                outFile = problemNum + "_" + (fileIndex++) + ".out";
            } else {
                outFile = problemNum + "_" + (fileIndex++ / 2) + ".out";
                saveToFile(directory.getAbsolutePath() + "\\" + outFile, content);
                System.out.println("Saved " + outFile);
//                inFile = problemNum + "_" + (fileIndex++) + ".in";
            }

        }
    }

    private static void saveToFile (String filePath, String content){
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}