package codingtest.src.zb;

import java.util.Arrays;

// 2022.8.10(수) 22h45~22h50 정확성 20 + 효율성 0 = 20점/20점 만점
public class w2_q3 {

    public static void main(String[] args) {
        System.out.println(solution(123));
    }

    public static int solution(int n) {
        int answer = 0;

        String nString = String.valueOf(n);

        for (int i = 0; i < nString.length(); i++) {
            answer += n % 10;
            n = n / 10;
        }

        return answer;
    }

}
