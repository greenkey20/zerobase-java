package exercises.src.JavaJeongseok.exercises;

import java.util.Arrays;

// 2022.8.11(목) 20h10
public class Ex4_6 {
    public static void main(String[] args) {
        int dice1, dice2;
//        int[][] sum6 = new int[][2];
        String sum6 = "";

        for (dice1 = 1; dice1 <= 6; dice1++) {
            for (dice2 = 1; dice2 <= 6; dice2++) {
                if (dice1 + dice2 == 6) {
                    // 처음에 1차원 배열 int[] sum6 만들어서 아래와 같이 활용하려고 했는데, 그러면 반복문 돌면서 조건 충족하는 새로운/마지막 dice1, dice2로 값 계속 덮어쓰기 됨 vs 2차원 배열은 차원을 어떻게 설정해야 할지, ArrayList를 사용해야 하나, 고민하다가 중단/idea 변경
                    /*
                    sum6[0] = dice1;
                    sum6[1] = dice2;
                     */

                    sum6 += "(" + dice1 + ", " + dice2 + "), ";

                    // 저자 답안
//                    System.out.println(dice1 + " + " + dice2 + " = " + (dice1 + dice2));
                }
            }
        }

//        System.out.println(Arrays.toString(sum6));
        System.out.println(sum6); // (1, 5), (2, 4), (3, 3), (4, 2), (5, 1),
    }
}
