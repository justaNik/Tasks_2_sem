package task_1;

import java.sql.Date;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.*;

public class Task_1 {
    public static void main(String[] args) {

        /*
        format1 - hh:mm:ss
        format2 - hh час mm минут ss секунд
         */

        Time time = new Time(357);
        /*
        Time time2 = new Time("1:3:3");
        System.out.println(time.getTime());
        System.out.println(time2.getTime());
        Time time3 = time2.addition("0:0:1");
        System.out.println(time3.getTime());
        Time time4 = time2.addition("0:0:1");
        System.out.println(time4.getTime());

         */


/*
       LocalDate date = LocalDate.of(2024, 02,20);
       LocalTime time = LocalTime.of(12, 15,43);
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));

        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm:ss");
       */

        System.out.println(time.format2());

    }
}
