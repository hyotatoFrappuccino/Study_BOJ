import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            Queue<Number> queue = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                queue.add(new Number(Integer.parseInt(st.nextToken()), j));
            }

            int count = 0;
            while (!queue.isEmpty()) {
                Iterator<Number> it = queue.iterator();
                Number max = it.next();
                int maxWeight = max.getWeight();
                int maxIndex = max.getIndex();
                // 나머지 다 돌아서 더 큰게 있는지 검사
                while (it.hasNext()) {
                    Number num = it.next();
                    if (num.getWeight() > maxWeight) maxIndex = num.getIndex();
                }
                // 뒤에 더 큰게 있다면 뒤로 넘김
                if (maxIndex != max.getIndex()) {
                    queue.add(queue.remove());
                }
                // 맨앞이 제일 큰거라면 빼고 count 증가
                else {
                    Number num = queue.remove();
                    count++;
                    if (num.getIndex() == M) {
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
    }
}

class Number implements Comparable<Number> {
    // 중요도
    int weight;
    // 위치
    int index;

    public Number(int weight, int index) {
        this.weight = weight;
        this.index = index;
    }

    public int getWeight() {
        return weight;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Number o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "{" + weight +
                ", " + index +
                '}';
    }
}
