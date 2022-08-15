package exercises.src.JavaJeongseok.exercises.ch4;

// 2022.8.11(목) 19h30
public class Ex4_5 {
    public static void main(String[] args) {
        // 문제에서 주어진 for문
        /*
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            } // inner for문 종료

            System.out.println();
        } // outer for문 종료
         */

        int i = 0;
        while (i <= 10) {
            int j = 0;
            while (j <= i) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }
    } // main() 종료
}
