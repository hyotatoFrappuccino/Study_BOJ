import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Test {
    static final String problemNum = "14940";
    private static final String DIRECTORY_PATH = "BOJ\\testcase";//in, out 파일이 들어있는 디렉토리 경로
    private static final int MAX_LINES = 10000; //읽을 수 있는 최대 라인 수(문제에 따라 다르게 설정합니다.)

    private final String fileName;

    public Test(String fileName) {
        this.fileName = fileName;
    }

    @org.junit.Test
    public void test() throws Exception {
        File directory = new File(DIRECTORY_PATH);

        // 이미 있다면 테스트케이스 실행
        boolean testcaseExists = false;
        for (String filename : Objects.requireNonNull(directory.list())) {
            if (filename.contains(problemNum)) {
                testcaseExists = true;
                break;
            }
        }

        if (testcaseExists) {
            Main.input(readLines(fileName));
            String[] process = Main.process().split("\n");
            StringBuilder actual = new StringBuilder();
            for (String s : process) {
                actual.append(s.trim()).append("\n");
            }

            assertEquals(readResult(fileName), actual.toString());
        } else {
            GetTestcase(directory);
            System.exit(0);
        }
    }

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Object[] data() {
        File directory = new File(DIRECTORY_PATH);
        return Arrays.stream(Objects.requireNonNull(directory.list()))
                .map(fileName -> fileName.replaceFirst("[.][^.]+$", "")).distinct().toArray();
    }

    private String[] readLines(String fileName) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader(String.format("%s/%s.in", DIRECTORY_PATH, fileName)));
        String temp;
        String[] lines = new String[MAX_LINES];
        int idx = 0;
        while ((temp = fr.readLine()) != null) {
            lines[idx++] = temp;
        }
        fr.close();
        return lines;
    }

    private String readResult(String fileName) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader(String.format("%s/%s.out", DIRECTORY_PATH, fileName)));
        String temp;
        StringBuilder result = new StringBuilder();
        while ((temp = fr.readLine()) != null) {
            result.append(temp).append("\n");
        }
        fr.close();
        return result.toString();
    }

    private static void GetTestcase(File directory) throws Exception {
        String URL = "https://www.acmicpc.net/problem/" + problemNum;
        @SuppressWarnings("SpellCheckingInspection")
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36";

        Document doc = Jsoup.connect(URL).userAgent(userAgent).get();
        // 예제 입력과 출력을 담고 있는 섹션을 선택합니다.
        //noinspection SpellCheckingInspection
        Elements sections = doc.select("section[id^=sampleinput], section[id^=sampleoutput]");
        if (!directory.exists()) {
            if (!directory.mkdirs())
                throw new Exception("BOJ/testcase 폴더가 생성되지 않았습니다. 권한등의 문제일 수 있습니다.");
        }

        // 이전 테스트케이스 삭제
        deleteFiles(directory);

        int fileIndex = 1;
        String inFile, outFile;

        // 선택한 섹션을 순회합니다.
        for (Element section : sections) {
            // 섹션 내의 <pre> 태그를 선택합니다.
            @SuppressWarnings("SpellCheckingInspection")
            Element pre = section.select("pre.sampledata").first();
            // <pre> 태그 안의 내용을 가져옵니다.
            assert pre != null;
            String content = pre.text();


            // 홀수 번째 content 는 .in 파일에, 짝수 번째 content 는 .out 파일에 저장합니다.
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
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    private static void deleteFiles(File directory) {
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteFiles(file);
                    } else {
                        //noinspection ResultOfMethodCallIgnored
                        file.delete();
                    }
                }
            }
        }
    }
}