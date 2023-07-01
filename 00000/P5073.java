import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P5073 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (!(input = br.readLine()).equals("0 0 0")){
            int[] sides = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(check(sides));;
        }
    }

    public static String check(int[] sides){
        if (sides[0] >= sides[1] && sides[0] >= sides[2]) {
            if (sides[0] >= sides[1] + sides[2]) return "Invalid";
        }
        else if (sides[1] >= sides[0] && sides[1] >= sides[2]) {
            if (sides[1] >= sides[0] + sides[2]) return "Invalid";
        }
        else {
            if (sides[2] >= sides[0] + sides[1]) return "Invalid";
        }
        if (sides[0] == sides[1] && sides[1] == sides[2]) return "Equilateral";
        if (sides[0] == sides[1] || sides[0] == sides[2] || sides[1] == sides[2]) return "Isosceles";
        return "Scalene";
    }
}
