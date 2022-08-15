package codingtest.src.zb;

import java.util.Arrays;

// 2022.8.10(수) 22h~22h35 정확성 14.4 + 효율성 0 = 14.4점/20점 만점
public class w2_q2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
    }

    public static int[] solution(int[] arr) {
        String answerString = "";

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                answerString = String.valueOf(arr[i]);
            } else {
                if (arr[i] != arr[i - 1]) {
                    answerString += String.valueOf(arr[i]);
                }
            }

            // 22h20 1차 시도 -> 내가 문제를 잘 못 이해했고, answer 배열의 길이를 쓸데없이 길게(arr 배열의 길이와 같도록) 잡았음을 깨달음
//            if (!answerString.contains(String.valueOf(arr[i]))) {
//                answerString += String.valueOf(arr[i]);
//            }

//            System.out.println(answerString);
        }

        int[] answer = new int[answerString.length()];

        for (int i = 0; i < answerString.length(); i++) {
            answer[i] = Character.getNumericValue(answerString.charAt(i));
        }

        return answer;
    }


}
