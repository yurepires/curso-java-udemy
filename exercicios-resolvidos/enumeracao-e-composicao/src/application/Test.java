package application;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
//        Date date = new Date();
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        System.out.println(cal.get(Calendar.YEAR));
        LocalDate c = LocalDate.parse("2022-07-20");

        int c_year = c.getYear();
        int c_month = c.getMonthValue();

        System.out.println(c_year);
        System.out.println(c_month);
    }
}
