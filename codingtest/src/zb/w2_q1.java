package codingtest.src.zb;

import java.util.ArrayList;
import java.util.List;

// 2022.8.10(수) 21h15~21h55 정확성 12 + 효율성 0 = 12점/20점 만점
public class w2_q1 {

    public static void main(String[] args) {
        System.out.println(solution(100, 130));
    }

    public static int solution(int n, int m) {
        int answer = 0;
        String nString = "";

        for (int i = n; i <= m; i++) {
            nString = String.valueOf(i);
//            System.out.println(nString); // 100 ~ 130

//            List nReverse = new ArrayList();
            String nReverse = "";

            for (int j = nString.length(); j > 0 ; j--) {
//                nReverse.add(nString.charAt(j - 1));

//                char[] nReverseArray = new char[nString.length()];
//                nReverseArray[nString.length() - j] = nString.charAt(j - 1);

                nReverse += String.valueOf((nString.charAt(j - 1)));
            }

//            System.out.println(nReverse.toString()); // nReverse를 ArrayList로 만들었을 때 [0, 0, 1] ~ [0, 3, 1] vs String으로 만들었을 때 001 ~ 031
            System.out.println(nReverse);

            if (nString.equals(nReverse)) {
                answer++;
            }
        }

        return answer;
    }

}
