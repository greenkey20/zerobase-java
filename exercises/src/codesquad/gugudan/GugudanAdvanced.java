package exercises.src.codesquad.gugudan;

// 2023.7.12(수) 16h15
// 짧은/간결한 코드로 컴퓨터에게 똑같은 일을 시킨다 = 좋은/뛰어난 프로그래머
public class GugudanAdvanced {
    public static int[] calculate(int times) {
        int[] results = new int[9];

        System.out.println("-- " + times + "단 --");
        for (int i = 0; i < results.length; i++) {
            results[i] = times * (i + 1);
        }

        return results;
    }

    public static void print(int[] results) {
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + " ");
        }
        System.out.println();
    }

    /**
     * 프로그램 실행하는 역할하는 메서드 + 실제 구구단 로직을 구현하지는 않음
     * @param args
     */
    public static void main(String[] args) {
        // 2단
        /*
        int[] results = new int[9];

        System.out.println("-- 2단 --");
        for (int i = 0; i < results.length; i++) {
            results[i] = 2 * (i + 1);
        }

        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }

        // 기존에 만든 변수에 구구단 3단 저장
        results = new int[9];

        System.out.println("-- 3단 --");
        for (int i = 0; i < results.length; i++) {
            results[i] = 3 * (i + 1);
        }

        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }

        // 새로운 변수에 구구단 4단 저장
        int[] times4 = new int[9];
        System.out.println("-- 4단 --");
        for (int i = 0; i < results.length; i++) {
            results[i] = 4 * (i + 1);
        }

        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
         */

        // 단별로 몇 단인지 지정하는 부분 제외하고는 반복 vs 해결책 = 2중 for문(반복문의 반복문) ou 메서드/함수 만들기
        // 방법1) 2중 for문
        for (int i = 2; i < 10; i++) {
            System.out.println("-- " + i + "단 --");
            int[] times = new int[9];

            for (int j = 0; j < times.length; j++) {
                times[j] = i * (j + 1);
            }

            for (int j = 0; j < times.length; j++) {
                System.out.println(i + " X " + (j + 1) + " = " + times[j]);
            }
        }

        // 방법2) 메서드/함수 만들기
        /*
        int[] results = calculate(2);
        print(results);

        int[] times3 = calculate(3);
        print(times3);

        int[] times4 = calculate(4);
        print(times4);

        int[] times5 = calculate(5);
        print(times5);
         */
        // 이상 반복 발생 중

        for (int i = 2; i < 10; i++) {
            int[] results = calculate(i);
            print(results);
        }
    }
}
