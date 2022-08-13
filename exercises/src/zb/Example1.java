package exercises.src.zb;

import java.util.Scanner;

// 2022.8.13(토) 15h45

/* 2022.8.13(토) 19h20 해설 강의
MDI(multi document interface) = 왼쪽에 문서 전체를 볼 수 있고, 특정 문서 선택하면 화면 우측에 크게 표시되며서 작업 가능

Java는 클래스 단위로 실행 -> 클래스 만드는 것부터 시작
이전에는 jdk 먼저 설치 -> 관련 tools(IDE) 설치 vs 요즘에는 여러 종류의 open jdk가 나오면서 tools 설치하고 jdk 자동으로 다운로드 가능함

프로젝트 생성하는 방법 중 (편한)하나 = 프로젝트로 사용할 빈 폴더 생성해서 IntelliJ로 drag해서 열기 -> 'file > project structure'에서 jdk (다운로드 및)선택
long-term service(lts) version = 1.8, 11, 17 = JDK가 많이 지원되는 버전; 실무에서 많이 쓰임(현재 실무에서 대부분 1.8 사용)
.idea 폴더 = 설정 파일
 */
public class Example1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean flag = true; // while문의 조건식으로 사용할 변수(Java 정석 p172 참고)

        while (flag) {
            System.out.println("== 메뉴 선택 =="); // 콘솔 화면에 출력하는 정적 메소드
            System.out.println("1. 회원 관리");
            System.out.println("2. 과목 관리");
            System.out.println("3. 수강 관리");
            System.out.println("4. 결제 관리");
            System.out.println("5. 종료");

            // 사용자가 숫자만 입력한다고 전제함
            int input = sc.nextInt();

            switch (input) {
                case 1 :
                    System.out.println("회원 관리 메뉴를 선택했습니다");
                    continue; // 반복문 내에서 사용해서, 반복이 진행되는 도중에 continue문을 만나면 반복문의 끝으로 이동하여 다음 반복으로 넘어감 -> for문의 경우 증감식으로 이동 + (do-)while문의 경우 조건식으로 이동
                case 2 :
                    System.out.println("과목 관리 메뉴를 선택했습니다");
                    continue;
                case 3 :
                    System.out.println("수강 관리 메뉴를 선택했습니다");
                    continue;
                case 4 :
                    System.out.println("결제 관리 메뉴를 선택했습니다");
//                    continue;
                    break; // 여기서는 무한 반복 계속하기 위해서 continue나 break 써도 무방한가?
                case 5 :
                    System.out.println("프로그램을 종료합니다");
                    // 종료하는 방법1
//                    flag = false;
//                    break; // 반복문 벗어남 -> 이 while문 다음에 코드 없으므로, 프로그램 끝이라고 생각했는데, 15h55 테스트 해보니 프로그램이 안 끝남(왜 그렇지..? break로 인해 while문 아래로 나가는 것 아닌가?) -> flag 변수 활용해서 while문 반복 조건 제어하기로 함 + 이 때 break 생략하면 default 케이스 1번 실행("입력 값이 정확하지 않습니다. 다시 입력해 주세요" 출력 1회)된 후 프로그램 종료됨

                    // 종료하는 방법2
                    return; // 현재 실행 중인 메소드를 종료하고, 호출한 메소드로 되돌아감; 반환 값 유무에 관계 없이 모든 메소드에는 적어도 하나의 return문이 있어야 하나, 반환 타입이 void인 경우 컴파일러가 메소드 마지막에 return;을 자동적으로 추가해줌
                    // 나의 질문 = main() 함수는 누가/어디에서 호출한 것이지..?
                default :
                    System.out.println("입력 값이 정확하지 않습니다. 다시 입력해 주세요");
//                    continue; // 'continue' is unnecessary as the last statement in a loop
            }
        } // while문 끝
    } // main() 종료
}
