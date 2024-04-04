import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P10825 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        for (Student student : list) {
            System.out.println(student);
        }
    }

    private static class Student implements Comparable<Student>{

        private final String name;
        private final int kor;
        private final int eng;
        private final int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (this.kor != o.kor)
                return o.kor - this.kor;
            else if (this.eng != o.eng)
                return this.eng - o.eng;
            else if (this.math != o.math)
                return o.math - this.math;
            else
                return this.name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
