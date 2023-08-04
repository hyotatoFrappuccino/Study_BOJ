import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P7568 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<People> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new People(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (People p1 : list) {
            int rank = 1;
            for (People p2 : list) {
                if (p1.compareTo(p2) < 0) rank++;
            }
            p1.setRank(rank);
        }
        StringBuilder sb = new StringBuilder();
        for (People p : list) {
            sb.append(p.getRank()).append(" ");
        }
        System.out.println(sb);
    }
}

class People implements Comparable<People>{
    int weight;
    int height;
    int rank;

    public People(int weight, int height) {
        this.weight = weight;
        this.height = height;
        this.rank = -1;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return this.rank;
    }

    @Override
    public int compareTo(People o) {
        if (this.weight > o.weight && this.height > o.height) return 1;
        else {
            if (this.weight < o.weight && this.height < o.height) return -1;
            else return 0;
        }
    }

    @Override
    public String toString() {
        return "People{" +
                "weight=" + weight +
                ", height=" + height +
                ", rank=" + rank +
                '}';
    }
}
