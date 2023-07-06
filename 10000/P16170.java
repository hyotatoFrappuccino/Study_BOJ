import java.time.LocalDate;
import java.time.ZoneId;

public class P16170 {
    public static void main(String[] args) throws Exception {
        LocalDate time = LocalDate.now(ZoneId.of("UTC"));
        int year = time.getYear();
        int month = time.getMonthValue();
        int day = time.getDayOfMonth();
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
    }
}
