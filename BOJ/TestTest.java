import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestTest {
    private static final String DIRECTORY_PATH = "BOJ\\testcase";//in, out 파일이 들어있는 디렉토리 경로
    private static final int MAX_LINES = 10000; //읽을 수 있는 최대 라인 수(문제에 따라 다르게 설정합니다.)

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Object[] data() {
        File directory = new File(DIRECTORY_PATH);
        return Arrays.stream(Objects.requireNonNull(directory.list()))
                .map(fileName -> fileName.replaceFirst("[.][^.]+$", "")).distinct().toArray();
    }

    private final String fileName;

    public TestTest(String fileName) {
        this.fileName = fileName;
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

    @org.junit.Test
    public void test() throws IOException {
        assertEquals(readResult(fileName), Main.process(readLines(fileName)));
    }
}