package exercises.src.JavaJeongseok.examples.ch10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// 2023.7.11(화) 18h35
public class DateFormatEx3 {
    public static void main(String[] args) {
        DateFormat df1 = new SimpleDateFormat("yyyy년 MM월 dd일");
        DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");

        try {
            Date tmr = df1.parse("2023년 7월 12일");
            System.out.println(df2.format(tmr));
        } catch (Exception e) {
        }
    }
}
