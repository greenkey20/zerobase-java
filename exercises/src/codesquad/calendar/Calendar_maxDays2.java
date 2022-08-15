package exercises.src.codesquad.calendar;

import java.util.Scanner;

// 2021.8월초 inflearn 강의
public class Calendar_maxDays2 {
	
	private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public int getMaxDaysOfMonth (int month) {
		return MAX_DAYS[month - 1];
	}	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Calendar_maxDays2 cal = new Calendar_maxDays2();
		System.out.println("달을 입력하세요");
		int month = scanner.nextInt();
		
		System.out.printf("%d월은 %d일까지 있습니다", month, cal.getMaxDaysOfMonth(month));
		scanner.close();
	}
}