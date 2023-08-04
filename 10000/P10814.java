import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P10814 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new Person(Integer.parseInt(input[0]), input[1], i));
        }
        list.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}

class Person implements Comparable<Person>{
    public int age;
    public String name;
    public int id;

    public Person(int age, String name, int id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }

    @Override
    public int compareTo(Person o) {
        if (this.age != o.age) return this.age - o.age;
        else return this.id - o.id;
    }
}