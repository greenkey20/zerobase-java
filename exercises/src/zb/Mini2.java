package exercises.src.zb;

import java.util.Scanner;

// 강은영
// 2022.8.15(월) 21h50
public class Mini2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[캐시백 계산]");
        System.out.print("결제 금액을 입력해 주세요.(금액):");
        int payment = scanner.nextInt();

        int cashBack = calculcateCashBack(payment);
        System.out.println("결제 금액은 " + payment + "원이고, 캐시백은 " + cashBack + "원 입니다.");

        // 나의 질문 = scanner.close() 꼭/왜 해야 하나?
    }

    public static int calculcateCashBack(int payment) {
        int cashBack = payment /10 / 100 * 100; // 캐시백 포인트 단위 = 100원

        // 1건의 캐시백 포인트의 최대 금액 = 300원
        if (cashBack > 300) {
            cashBack = 300;
        }

        return cashBack;
    }
}
