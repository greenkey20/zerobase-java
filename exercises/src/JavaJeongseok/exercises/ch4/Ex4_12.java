package exercises.src.JavaJeongseok.exercises.ch4;

// 2022.8.13(토) 1h45
// 구구단 출력
public class Ex4_12 {
    public static void main(String[] args) {
        /*
        for (int i = 1; i < 4; i++) {
            for (int j = 2; j < 9; j += 3) {
                System.out.printf("%d * %d = %d", j, i, j * i);
            }
            System.out.println();
        }
         */

        /*
        for (int j = 2; j < 9; j += 3) {
            for (int i = 1; i < 4; i++) {
                if (j != 8) {
                    System.out.printf("%d * %d = %d\t%d * %d = %d\t%d * %d = %d\n", j, i, j * i, j + 1, i, (j + 1) * i, j + 2, i, (j + 2) * i);
                } else {
                    System.out.printf("%d * %d = %d\t%d * %d = %d\n", j, i, j * i, j + 1, i, (j + 1) * i);
                }

            }
            System.out.println();
        }
         */
        /* 위 코드의 문제점
        1. 낮은 가독성
        2. printf() 내 비슷한 패턴의 수식 여러 번 반복
        3. 문제에서 요구되지 않은 10단이 출력됨 -> if ~ else 조건으로 j = 8일 때 분기해서 10단 출력되지 않도록 함 -> 그럼에도 위 문제점들이 해결되지는 않음
         */

        // 2022.8.14(일) 23h30 저자 해설(반복문 2번 사용해서 작성) 참고
        /* 문제 요구는 2단~9단 출력이나, 문제를 쉽게 하기 위해 10단까지 출력하는 것이 좋음(나의 질문 = 출력 형식 1행에 3단씩 출력하는 패턴을 반복하기 위해서인가?) + 곱하기 3까지만 출력 -> 총 9 * 3 = 27번 반복 돌림
        이 풀이의 핵심 = '단' 의미하는 변수 layer 및 '곱하는 숫자' 의미하는 변수 multiplier를 정의하고, 반복문 제어변수/카운터 i, j를 이용해서 layer 및 multiplier의 값을 적절히 계산하는 것 -> 논리적인 과정을 하나하나 거쳐 나가면서 답을 만들어 가는 것/문제를 풀어가는 과정을 배워야 함
        -> i, j 값의 변화와 그에 따른 layer, multiplier 값의 변화를 표로 적어보는 것까지 해설 읽어보고, 나 스스로 관계 및 패턴을 고민해서 코드 작성해봄

        2022.8.15(월) 1h30
         */
        int layer = 0;
        int multiplier = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                layer = j + 2 + i / 3 * 3;
                multiplier = i % 3 + 1;

                if (layer == 10) { // 10단은 출력하지 않도록 함
                    break;
                }

                System.out.printf("%d*%d=%d\t", layer, multiplier, layer * multiplier);

                // version1 -> 저자 답안 읽어보니, 나의 이 로직 구질구질 ㅠㅠ
                /*
                if (layer != 9) {
                    if (j == 2) {
                        System.out.println();
                    }
                } else {
//                    if (j == 1) { // Condition 'j == 1' is always 'true'
                        System.out.println();
//                    }
                }
                 */
            }

            System.out.println(); // 3행 출력 후 개행하는 것 저자 답안 참고해서 version2 2h45

            if (multiplier == 3) {
                System.out.println();
            }
        }

        // 저자 답안
        /*
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 3; j++) {
                int layer = j + 1 + (i - 1) / 3 * 3;
                int multiplier = i % 3 == 0? 3 : i % 3;

                if (layer > 9) {
                    break;
                }

                System.out.print(layer + "*" + multiplier + "=" + layer * multiplier + "\t");
            }
            System.out.println();
            if (i % 3 == 0) {
                System.out.println();
            }
        }
         */
    } // main() 종료
}
