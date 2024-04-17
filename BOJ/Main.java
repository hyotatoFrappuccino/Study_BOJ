import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static String[] readLines() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        br.close();

        String[] linesArray = new String[lines.size()];
        linesArray = lines.toArray(linesArray);

        return linesArray;
    }
    
    static String process(String[] lines){
        String result = "";
    	//입력받은 데이터들로 문제 풀 준비를 하는 메서드
        return result;
    }
	public static void main(String[] args) throws IOException {
        System.out.println(process(readLines()));
    }
}