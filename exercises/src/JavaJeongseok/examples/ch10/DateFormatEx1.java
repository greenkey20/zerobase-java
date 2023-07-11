package exercises.src.JavaJeongseok.examples.ch10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// 2023.7.11(화) 18h20
public class DateFormatEx1 {
    public static void main(String[] args) {
//        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.set(2023, 6, 11); // Month는 0~11의 범위를 가짐 -> 7월 의미
        Date today = cal.getTime();

        SimpleDateFormat sdf1, sdf2, sdf3, sdf4, sdf10;
        SimpleDateFormat sdf5, sdf6, sdf7, sdf8, sdf9;

        sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        sdf2 = new SimpleDateFormat("''yy년 MMM dd일 E요일");
        sdf10 = new SimpleDateFormat("yy-MM-dd E요일");
        sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");

        sdf5 = new SimpleDateFormat("오늘은 올해의 D번째 날입니다");
        sdf6 = new SimpleDateFormat("오늘은 이 달의 d번째 날이에요");
        sdf7 = new SimpleDateFormat("오늘은 올해의 w번째 주입니다");
        sdf8 = new SimpleDateFormat("오늘은 이 달의 W번째 주에요");
        sdf9 = new SimpleDateFormat("오늘은 이 달의 F번째 E요일이에요");

        System.out.println(sdf1.format(today));
        System.out.println(sdf2.format(today));
        System.out.println(sdf10.format(today));
        System.out.println(sdf3.format(today));
        System.out.println(sdf4.format(today));
        System.out.println();
        System.out.println(sdf5.format(today));
        System.out.println(sdf6.format(today));
        System.out.println(sdf7.format(today));
        System.out.println(sdf8.format(today));
        System.out.println(sdf9.format(today));
    }
}
