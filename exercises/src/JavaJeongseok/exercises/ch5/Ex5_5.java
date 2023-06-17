package exercises.src.JavaJeongseok.exercises.ch5;

// 2023.6.18(일) 0h40

import java.util.ArrayList;
import java.util.List;

/**
 * 1~9 사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는 프로그램
 */
public class Ex5_5 {
    public static void main(String[] args) {
        int[] ballArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] ball3 = new int[3];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < ball3.length; i++) {
            int idx = (int) (Math.random() * ballArr.length);
            int num = ballArr[idx];

            if (list.contains(num)) {
                i--;
            } else {
                list.add(num);
            }
        }

//        System.out.println(list); // todo
        for (int i = 0; i < ball3.length; i++) {
            ball3[i] = list.get(i);
        }

        for (int i : ball3) {
            System.out.print(i);
        }

        // draft
        /*
        int randNum = (int) Math.random() * ballArr.length; // 0~8 범위의 정수 중 하나가 랜덤으로 뽑힘
        ball3[0] = ballArr[randNum];

        for (int i = 1; i < ball3.length; i++) {
            randNum = (int) Math.random() * ballArr.length;

            for (int j = i - 1; j < i; j++) {
                if (randNum == ball3[j]) {

                }
            }
        }
         */
    }
}
