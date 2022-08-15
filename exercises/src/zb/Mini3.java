package exercises.src.zb;

import java.util.Scanner;

// 강은영
// 2022.8.15(월) 22h
public class Mini3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[입장권 계산]");

        // 나의 질문 = 아래 콘솔 메뉴 출력('~를 입력해 주세요') 및 사용자 데이터 입력(모두 일단 scanner.nextLine()으로 받고 형 변환?) 코드 반복을 효과적으로 어떻게 줄일 수 있을까?
        System.out.print("나이를 입력해 주세요.(숫자 입력):");
        int age = scanner.nextInt();

        System.out.print("입장시간을 입력해 주세요.(숫자 입력):");
        int entranceHour = scanner.nextInt();
        scanner.nextLine(); // 나의 질문 = scanner.nextInt() vs Integer.parseInt(scanner.nextLine()) 성능이나 기능 차이?

        System.out.print("국가유공자 여부를 입력해 주세요.(y/n):");
        char nationalVictim = scanner.nextLine().charAt(0);

        System.out.print("복지카드 여부를 입력해 주세요.(y/n):");
        char welfareCard = scanner.nextLine().charAt(0);

        int entranceFee = calculateEntranceFee(age, entranceHour, nationalVictim, welfareCard);
        System.out.println("입장료: " + entranceFee);
    }

    public static int calculateEntranceFee(int age, int entranceHour, char nationalVictim, char welfareCard) {
        int entranceFee = 10000;

        // 나의 질문 = 각 조건별 우선순위를 내 머리로 따져서 가장 큰 혜택을 최종적으로 누릴 수 있도록(e.g. 39세 국가유공자(8천원)가 17시에 입장(4천원) 시 입장료 4천원) 조건문의 순서를 배치했는데, 더 효율적인/자동화할 수 있는 방법은 무엇일까?

        if (nationalVictim == 'y' || welfareCard == 'y') {
            entranceFee = 8000;
        }

        if (3 <= age && age < 13 || entranceHour >= 17) {
            entranceFee = 4000;
        } else if (age < 3) {
            entranceFee = 0;
        }

        return entranceFee;
    }
}
