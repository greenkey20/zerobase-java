package codingtest.src.zb;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 2022.8.10(수) 22h52~23h40 정확성 6 + 효율성 0 = 6점/20점 만점
public class w2_q4 {

    public static void main(String[] args) {
//        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
    }

    public static int solution(String dirs) {
        int answer = 0;

        int[] origin = {0, 0};
        int[] arrival = {0, 0};

//        Set set = new HashSet();
        Set set2 = new HashSet();

        for (int i = 0; i < dirs.length(); i++) {
            switch (dirs.charAt(i)) {
                case 'U' :
                    if (arrival[1] < 5) {
                        arrival[1] += 1;
                    }
                    break;
                case 'D' :
                    if (arrival[1] > -5) {
                        arrival[1] -= 1;
                    }
                    break;
                case 'R' :
                    if (arrival[0] < 5) {
                        arrival[0] += 1;
                    }
                    break;
                case 'L' :
                    if (arrival[0] > -5) {
                        arrival[0] -= 1;
                    }
            }

            int[][] points = {{origin[0], origin[1]}, {arrival[0], arrival[1]}};
//            System.out.println(Arrays.toString(points));
//            int[][] points = {origin, arrival};
            set2.add(points);

            for (int j = 0; j < 2; j++) {
                origin[j] = arrival[j];
            }
        }

        answer = set2.size();

//        System.out.println("set2 = " + set2);

        return answer;
    }


}
