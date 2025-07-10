import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * BOJ 문제 자동 테스트 클래스 (웹 크롤링 기능 포함)
 *
 * --- 사용 방법 ---
 * 1. 아래 `problemNum` 변수에 테스트할 백준 문제 번호를 입력하세요.
 * 2. `main` 메소드를 실행(Run)하세요.
 * 3. 테스트케이스 파일이 없으면 자동으로 다운로드 후 즉시 테스트를 시작합니다.
 *    (이때 testcase 폴더의 모든 기존 파일은 삭제됩니다.)
 *
 * --- 필요 조건 ---
 * - Jsoup 라이브러리가 프로젝트에 추가되어 있어야 합니다.
 * - Main.java 파일에 public static void input(String[]) 메소드가 있어야 합니다.
 * - Main.java 파일에 public static String process() 메소드가 있고, 결과 문자열을 반환해야 합니다.
 */
public class Test {

    // =================================================================
    // =================== 테스트할 문제 번호를 입력하세요 ===================
    static final String problemNum = "10156";
    // =================================================================
    // =================================================================

    private static final String DIRECTORY_PATH = "BOJ/testcase";

    public static void main(String[] args) throws Exception {
        File directory = new File(DIRECTORY_PATH);
        if (!directory.exists() && !directory.mkdirs()) {
            System.err.println("오류: " + DIRECTORY_PATH + " 폴더를 생성할 수 없습니다.");
            return;
        }

        File[] testcaseFiles = directory.listFiles((dir, name) -> name.startsWith(problemNum + "_") && name.endsWith(".in"));

        if (testcaseFiles == null || testcaseFiles.length == 0) {
            System.out.println("테스트케이스 파일을 찾을 수 없습니다. 백준 사이트에서 다운로드를 시작합니다...");
            GetTestcase(directory);
            System.out.printf("%n다운로드가 완료되었습니다. 바로 테스트를 시작합니다.%n");
            testcaseFiles = directory.listFiles((dir, name) -> name.startsWith(problemNum + "_") && name.endsWith(".in"));
        }

        if (testcaseFiles == null || testcaseFiles.length == 0) {
            System.err.println("오류: 테스트케이스 다운로드에 실패했거나, 해당 문제의 예제가 없습니다.");
            return;
        }

        System.out.printf("'%s'번 문제 자동 채점을 시작합니다.%n%n", problemNum);
        Arrays.sort(testcaseFiles, Comparator.comparing(File::getName));

        boolean allPass = true;
        for (File inFile : testcaseFiles) {
            String testName = inFile.getName().replace(".in", "");
            File outFile = new File(directory, testName + ".out");

            if (!outFile.exists()) {
                System.err.printf("경고: %s 파일을 찾을 수 없어 해당 테스트를 건너뜁니다.%n", outFile.getName());
                continue;
            }

            String[] inputLines = readAllLines(inFile);
            String expectedOutput = readAllText(outFile);

            Main.input(inputLines);
            String actualOutput = Main.process();

            if (actualOutput.trim().replaceAll("\r\n", "\n").equals(expectedOutput.trim().replaceAll("\r\n", "\n"))) {
                System.out.printf("✅ [PASS] %s%n", testName);
            } else {
                allPass = false;
                System.out.printf("❌ [FAIL] %s%n", testName);
                System.out.println("  [기대값]");
                System.out.println(expectedOutput);
                System.out.println("  [실행 결과]");
                System.out.println(actualOutput);
            }
        }

        if (allPass) {
            System.out.printf("%n🎉 모든 테스트케이스를 통과했습니다!%n");
        }
    }

    private static String[] readAllLines(File file) throws IOException {
        return Files.readAllLines(file.toPath()).toArray(new String[0]);
    }

    private static String readAllText(File file) throws IOException {
        return new String(Files.readAllBytes(file.toPath()));
    }

    private static void GetTestcase(File directory) throws Exception {
        String URL = "https://www.acmicpc.net/problem/" + problemNum;
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
                         + "AppleWebKit/537.36 (KHTML, like Gecko) "
                         + "Chrome/98.0.4758.102 Safari/537.36";

        System.out.println("User-Agent: " + userAgent);

        // testcase 폴더의 모든 파일을 삭제하여 다른 문제의 테스트케이스를 정리합니다.
        System.out.println("\n기존 테스트케이스 파일을 삭제합니다...");
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (!file.delete()) {
                System.err.println("경고: " + file.getName() + " 파일을 삭제하지 못했습니다.");
            }
        }
        
        Document doc = Jsoup.connect(URL).userAgent(userAgent).get();
        Elements sections = doc.select("section[id^=sampleinput], section[id^=sampleoutput]");

        int fileIndex = 1;
        for (Element section : sections) {
            Element pre = section.selectFirst("pre.sampledata");
            if (pre == null) continue;
            String content = pre.text();

            String fileName;
            if (section.id().contains("input")) {
                fileName = String.format("%s_%d.in", problemNum, fileIndex);
            } else {
                fileName = String.format("%s_%d.out", problemNum, fileIndex);
                fileIndex++;
            }
            saveToFile(new File(directory, fileName).getAbsolutePath(), content);
            System.out.println("Saved " + fileName);
        }
    }

    private static void saveToFile(String filePath, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content.replaceAll("\r\n", "\n"));
        }
    }
}