package exercises.src.zb;

import java.util.Scanner;

// 2022.8.13(토) 15h45

/* 2022.8.13(토) 19h20 해설 강의
MDI(multi document interface) = 왼쪽에 문서 전체를 볼 수 있고, 특정 문서 선택하면 화면 우측에 크게 표시되며서 작업 가능

Java는 클래스 단위로 되어있음/실행 -> 클래스 만드는 것부터 시작
클래스 = 해당 클래스의 범위(scope, 대괄호 {}) 내에 속성(값) + 메소드(기능 수행, 함수)
String도 클래스 -> String 클래스도 여러 메소드를 가지고 있음 e.g. toLowerCase()(문자열을 소문자로 바꿔줌)

이전에는 jdk 먼저 설치 -> 관련 tools(IDE) 설치 vs 요즘에는 여러 종류의 open jdk가 나오면서 tools 설치하고 jdk 자동으로 다운로드 가능함

프로젝트 생성하는 방법 중 (편한)하나 = 프로젝트로 사용할 빈 폴더 생성해서 IntelliJ로 drag해서 열기 -> 'file > project structure'에서 jdk (다운로드 및)선택
long-term service(lts) version = 1.8, 11, 17 = JDK가 많이 지원되는 버전; 실무에서 많이 쓰임(현재 실무에서 대부분 1.8 사용)
.idea 폴더 = 설정 파일
 */
public class Example1 {
    // 조건문, 반복문, 배열, Scanner 활용 + 로직은 단순(특정 조건이 반복될 때까지 실행하고, 어떤 조건이 맞으면 빠져나감)

    /* 화면 출력하는 함수/메소드
    좌측 세로줄에 달린 region? = 축소했다가 펼쳤다 하는 기능 -> displayMenu() 메소드 만든 후에 이 함수는 내 관심사가 아님/알아서 잘 나오겠지, 나는 그냥 호출할 뿐인 경우에는 축소해둠
     */
    public static void displayMenu() {
        System.out.println("== 메뉴 선택 =="); // 콘솔 화면에 출력하는 정적 메소드
        System.out.println("1. 회원 관리");
        System.out.println("2. 과목 관리");
        System.out.println("3. 수강 관리");
        System.out.println("4. 결제 관리");
        System.out.println("5. 종료");

        // for문 반복하는 케이스가 대개 객체 컬렉션 형태 -> 회수/개수만큼 반복하기 보다는 for each문 자주 사용
    }

    public static void main(String[] args) {
        /* 2022.8.15(월) 강사님 해설 강의 tips
        - Windows 이전 시절(DOS 사용 등) 텍스트 기반 프로그램에서 많이 사용되던 방식 = 화면에 메뉴 보여주고, 메뉴 선택되면 그 메뉴의 sub화면으로 들어가서 기능 처리하고, 다시 main으로 나오고..
        - 백엔드든 클라이언트/프론트든 일반적인 업무 = 사용자에게 입력받은 내용을 데이터에 저장 + 데이터에 저장된 내용을 화면에 보여줌
        - 프로그램이 복잡해 보이면 작/잘게 쪼개보기
        ex1) 일단/우선 화면에 '메뉴 선택' 내용(=6개의 문자열)을 출력해보기
        ex2) 관련 메시지 출력 <- 사용자로부터 입력받은 값을 판단 <- 조건문(if문, switch문)
        ex3) '메뉴 선택' 내용은 무한 출력해야 함 -> 출력하는 부분을 별도/따로 함수 displayMenu()로 만듦 + 반복되는 과정에 대해서는 반복문(for문(특정한 조건에 의해 반복, 시작 값 + 종료 값/범위 + step), (do-)while문(특정 조건이 맞을 때까지 반복) -> 여기서는 for문도 가능은 하나, while문으로 반복하는 것이 더 좋을 것 같음)
        - 컴퓨터 프로그램에서 내가 하고자 하는 대부분의 기능/일은 마우스 오른쪽 버튼에 있음 vs 없다면, 내가 하고자 하는 것을 잘못 선택 ou 프로그래머가 그 프로그램 잘못 만듦 -> 이 클래스 main() 작성 후 마우스 오른쪽 버튼 클릭하면 할 수 있는 일 중 이 프로그램 실행(run) 있음
        - 함수 호출하면 그 함수가 알아서 해주는 기능들의 집합
         */
        Scanner sc = new Scanner(System.in); // 콘솔에서 값 입력받는 경우 Scanner 클래스 사용
        // Scanner 클래스는 생성 시 기본적으로 input stream을 필요로 함 -> default 생성자 new Scanner()(x) new Scanner(System.in))(o)

        boolean flag = true; // while문의 조건식으로 사용할 변수(Java 정석 p172 참고)

        // 프로그램이 실행하다가 while문이 애초에 실행이 안 되는 경우가 발생할 수 있는 바, 메뉴를 무조건 1번은 보여준다는 의미를 구현하기 위해 일반적으로 do~ while문(무조건 1번은 실행하고, 조건 검사해서 계속 실행할지 말지 여부 판단)으로 구현 -> flag 변수는 do~ while문에서는 의미 없고, while문 실행할 수 있는 상태를 주기 위해 만든 것임
        while (flag) {
            // 나는 아래와 같이 main() 내에 출력 내용 작성
            /*
            System.out.println("== 메뉴 선택 =="); // 콘솔 화면에 출력하는 정적 메소드
            System.out.println("1. 회원 관리");
            System.out.println("2. 과목 관리");
            System.out.println("3. 수강 관리");
            System.out.println("4. 결제 관리");
            System.out.println("5. 종료");
             */

            // 강사님께서는 별도 함수로 만드심 = 프로그램이 길어지면 병적으로 refactoring(분리, 관심사를 떨어뜨리기, '이 함수 내가 호출하면 잘 처리해줘' 하고 관심사 밖으로 밀어두기)하게 됨
            displayMenu();

            // 사용자가 숫자만 입력한다고 전제함 vs 사용자 대상 실제 서비스 시 다양한 조건의 예외 처리 필요
            int input = sc.nextInt(); // nextInt()는 정수 값을 리턴하는 메소드; 강사님께서는 int형 변수 이름 inputMenu로 하심(더 좋은 것 같다)

            // 강사님께서는 프로그램 전체 흐름을 좀 더 잘 보이게 하기 위해 switch()문을 별도 함수로 만드심
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
} // 클래스 Example1의 범위 끝
