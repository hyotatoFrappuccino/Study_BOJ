import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class P14543 {
    static int T;
    static List<Node> list;
    static StringBuilder output;

    static void input(String[] lines) {
        T = Integer.parseInt(lines[0]);
        list = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            list.add(new Node(lines[i + 1]));
        }
        output = new StringBuilder();
    }

    static String process() {
        for (int i = 0; i < list.size(); i++) {
            output.append("Equation %d\n".formatted(i + 1));

            String sol = solution(list.get(i));
            output.append(sol).append("\n\n");
        }

        return output.toString();
    }

    private static String solution(Node node) {
        BigDecimal a = node.getA();
        BigDecimal b = node.getB();
        BigDecimal c = node.getC();

        if (Objects.equals(a, BigDecimal.ZERO)) {
            if (b.equals(c)) {
                return "More than one solution.";
            } else {
                return "No solution.";
            }
        }
        BigDecimal x = (c.subtract(b)).divide(a, 6, RoundingMode.DOWN);
        return "x = %6f".formatted(x);
    }

    static class Node {
        private final BigDecimal a;
        private final BigDecimal b;
        private final BigDecimal c;

        public Node(String equation) {
            String[] split = equation.split(" ");
            this.a = new BigDecimal(split[0].split("x")[0]);
            this.b = new BigDecimal(split[2]);
            this.c = new BigDecimal(split[4]);
        }

        public BigDecimal getA() {
            return a;
        }

        public BigDecimal getB() {
            return b;
        }

        public BigDecimal getC() {
            return c;
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