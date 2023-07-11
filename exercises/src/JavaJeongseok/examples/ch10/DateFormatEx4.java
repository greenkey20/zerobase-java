package exercises.src.JavaJeongseok.examples.ch10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

// 2023.7.11(화) 18h40
public class DateFormatEx4 {
    public static void main(String[] args) {
        String pattern = "yyyy/MM/dd";
        DateFormat df = new SimpleDateFormat(pattern);
        Scanner scanner = new Scanner(System.in);

        Date inputDate = null;

        System.out.print("날짜를 " + pattern + "의 형태로 입력해 주세요 (입력 예: 2023/04/08) > ");

        while (scanner.hasNextLine()) {
            try {
                inputDate = df.parse(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.print("날짜를 " + pattern + "의 형태로 다시 입력해 주세요 (입력 예: 2023/04/08) > ");
            }
        }

        Calendar inputDateCal = Calendar.getInstance();
        inputDateCal.setTime(inputDate);
        Calendar todayCal = Calendar.getInstance();
        long diff = (inputDateCal.getTimeInMillis() - todayCal.getTimeInMillis()) / (60 * 60 * 1000);
        System.out.println("입력하신 날짜 " + inputDate + "는 현재와 " + diff + "시간 차이가 있습니다");
    }
}
