import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P10972 {
    static StringBuilder output;
    static int N;
    static int[] list;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        list = Arrays.stream(lines[1].split(" ")).mapToInt(Integer::parseInt).toArray();
        output = new StringBuilder();
    }

    static String process() {
        boolean end = false;
        for (int i = N - 1; i > 0; i--) {
            if (list[i - 1] < list[i]) {

                int j = N - 1;
                while (list[i - 1] > list[j]) j--;


                int temp = list[j];
                list[j] = list[i - 1];
                list[i - 1] = temp;
                Arrays.sort(list, i, N);
                end = true;
                break;
            }
        }
        if (end) {
            for (int i : list) {
                output.append(i).append(" ");
            }
        } else {
            output.append("-1");
        }

        return output.toString();
    }

    public static void main(String[] args) throws IOException {
        input(readLines());
        System.out.println(process());
    }

    private static String[] readLines() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            lines.add(line);
        }
        br.close();

        String[] linesArray = new String[lines.size()];
        linesArray = lines.toArray(linesArray);
        return linesArray;
    }
}