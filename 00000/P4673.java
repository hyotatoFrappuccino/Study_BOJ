import java.util.*;

public class P4673 {
    static List<Integer> alreadychecklist = new ArrayList<>();
    public static void main(String[] args) {
        for (int i = 1; i <= 10000; i++) {
            alreadychecklist.add(i);
        }
        while(!alreadychecklist.isEmpty()){
            int test = alreadychecklist.remove(0);
            System.out.println(test);
            selfnumber(test);
        }
    }
    public static void selfnumber(int num){
        int next = num;
        String numstr = Integer.toString(num);
        for (int i = 0; i < numstr.length(); i++) {
            next += Integer.parseInt(String.valueOf(numstr.charAt(i)));
        }
        alreadychecklist.remove((Integer)next);
        if (next <= 10000 && !alreadychecklist.contains(next))
            selfnumber(next);
    }
}
