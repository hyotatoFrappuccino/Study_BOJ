import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16198 {
    static int N;
    static Integer[] weight;
    static int MAX;

    static void input(String[] lines) {
        N = Integer.parseInt(lines[0]);

        weight = new Integer[N];
        MAX = 0;
        StringTokenizer st = new StringTokenizer(lines[1]);
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
    }

    static String process() {
        bfs(new ArrayList<>(List.of(weight)));


        return String.valueOf(MAX);
    }

    private static void bfs(List<Integer> initWeight) {
        Queue<Energy> queue = new LinkedList<>();
        queue.add(new Energy(initWeight, 0));

        while (!queue.isEmpty()) {
            Energy energy = queue.poll();
            List<Integer> weight = energy.getWeight();
            int sum = energy.getSum();

            if (weight.size() == 2) {
                MAX = Math.max(sum, MAX);
                continue;
            }

            for (int i = 1; i < weight.size() - 1; i++) {
                sum += weight.get(i - 1) * weight.get(i + 1);
                Integer removed = weight.remove(i);
                queue.add(new Energy(weight, sum));
                weight.add(i, removed);
                sum -= weight.get(i - 1) * weight.get(i + 1);
            }
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

class Energy {
    private List<Integer> weight;
    private int sum;

    public Energy(List<Integer> weight, int sum) {
        this.weight = new ArrayList<>();
        this.weight.addAll(weight);
        this.sum = sum;
    }

    public List<Integer> getWeight() {
        return weight;
    }

    public int getSum() {
        return sum;
    }
}