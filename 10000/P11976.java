import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P11976 {
    static int[][] rank;
    static StringBuilder output;

    static void input(String[] lines) {
        rank = new int[4][2];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(lines[i]);
            rank[i][0] = Integer.parseInt(st.nextToken());
            rank[i][1] = Integer.parseInt(st.nextToken());
        }
        output = new StringBuilder();
    }

    static String process() {
        int bronzeToSilver = rank[1][1] - rank[1][0];
        int silverToGold = rank[2][1] - rank[2][0];
        int goldToPlatinum = rank[3][1] - rank[3][0];
        output.append(goldToPlatinum + silverToGold + bronzeToSilver).append("\n");
        output.append(goldToPlatinum + silverToGold).append("\n");
        output.append(goldToPlatinum).append("\n");
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