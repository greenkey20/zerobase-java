package exercises.src.codesquad.calendar;

import java.util.Scanner;

// 2021.8월초 inflearn 강의
public class Calendar_maxDays1 {
	public static void main(String[] args) {
		System.out.println("Hello, Calendar");
		System.out.println("일  월  화 수  목 금  토");
		System.out.println("--------------------");
		System.out.println("          1  2  3  4");
		System.out.println(" 5  6  7  8  9 10 11");
		System.out.println("12 13 14 15 16 17 18");
		System.out.println("19 20 21 22 23 24 25");
		System.out.println("26 27 28 29 30 31");
		
		System.out.println("월을 입력하세요");
		Scanner scanner = new Scanner(System.in);
		String s;
		s = scanner.next();
		
		int i, j = 0;
		i = Integer.parseInt(s);
		
		if (i == 1) {
				j = 31;
		} else if (i == 2) {
			j = 28;
		} else if (i == 3)
			j = 31;
		else if (i == 4)
			j = 30;
		else if (i == 5)
			j = 31;
		else if (i == 6)
			j = 30;
		else if (i == 7)
			j = 31;
		else if (i == 8)
			j = 31;
		else if (i == 9)
			j = 30;
		else if (i == 10)
			j = 31;
		else if (i == 11)
			j = 30;
		else if (i == 12)
			j = 31;
		
		System.out.printf("%d월은 %d일까지 있습니다", i, j);
		scanner.close();	
	}
}
