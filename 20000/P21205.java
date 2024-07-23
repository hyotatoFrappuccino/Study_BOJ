import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P21205 {
    static int N;
    static String[] input;
    static StringBuilder output;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);
        input = new String[N];
        System.arraycopy(lines, 1, input, 0, N);
        output = new StringBuilder();
    }

    static String process() {
        int vaccinated = 0;
        int controlled = 0;
        int real_A = 0;
        int real_B = 0;
        int real_C = 0;
        int control_A = 0;
        int control_B = 0;
        int control_C = 0;

        for (String s : input) {
            char[] cs = s.toCharArray();
            if (cs[0] == 'Y') {
                vaccinated++;
                if (cs[1] == 'Y') real_A++;
                if (cs[2] == 'Y') real_B++;
                if (cs[3] == 'Y') real_C++;
            } else {
                controlled++;
                if (cs[1] == 'Y') control_A++;
                if (cs[2] == 'Y') control_B++;
                if (cs[3] == 'Y') control_C++;
            }
        }

        calc((double) real_A / vaccinated, (double) control_A / controlled);
        calc((double) real_B / vaccinated, (double) control_B / controlled);
        calc((double) real_C / vaccinated, (double) control_C / controlled);

        return output.toString();
    }

    private static void calc(double vacRate, double contRate) {
        if (vacRate >= contRate) {
            output.append("Not Effective\n");
        } else {
            output.append("%.6f".formatted((1 - (vacRate / contRate)) * 100)).append("\n");
        }
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