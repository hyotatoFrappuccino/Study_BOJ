import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P1181 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<word> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(new word(br.readLine()));
        }
        List<word> list = new ArrayList<>(set);
        list.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}

class word implements Comparable<word>{
    public String word;

    public word(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        word word1 = (word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public int compareTo(word o) {
        if (this.word.length() != o.word.length()) return this.word.length() - o.word.length();
        else return this.word.compareTo(o.word);
    }

    @Override
    public String toString() {
        return word;
    }
}
