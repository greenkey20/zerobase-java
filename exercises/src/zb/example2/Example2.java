package exercises.src.zb.example2;

import java.util.Arrays;

// 2022.8.13(토) 19h
/* 외부 라이브러리 연동
 */
public class Example2 {
    public static void main(String[] args) {
        String filePath = "/Users/greenpianorabbit/zerobase/zerobase-java/exercises/src/zb/example2/president19 inauguration.txt";

        FileUtils fileUtils = new FileUtils(); // FileUtils 클래스의 객체 생성 <- new + 생성자
//        String text = fileUtils.getLoadText(filePath).replace(" ", ""); // 알파벳만 셀 거니까 공백 없앤 텍스트 대상 처리할까 생각했는데, 구두점도 있으니까 이 처리는 안 하기로 함
        String text = fileUtils.getLoadText(filePath);

        // 23h
//        System.out.println(text);

//        final int TEXT_LENGTH = text.length(); // String.length() = 문자열의 길이(int)를 반환
        // 나의 질문 = 왜 'Modifier 'static' not allowed here'인지 잘 모르겠다
        // 23h5 이 값 딱히 재활용할 것 같지 않아서, 이 변수 사용하지 않기로 함

        // 처음에 생각한 로직 = 'A'~'Z'까지 if-else if문 반복해야 하나 생각했음 -> 잠시 멈추고 알파벳 순서대로 돌리는 반복문을 생각해봄
        /*
        int[] countsOfAlphabet = new int[26];

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'A' || text.charAt(i) == 'a') {
                countsOfAlphabet[0]++;
            } else if (text.charAt(i) == 'B' || text.charAt(i) == 'b') {
                countsOfAlphabet[1]++;
            }
        }
         */

        // 각 알파벳과 출현 회수를 저장할 자료 구조 마련
        final int NUM_OF_ALPHABETS = 26;
        int[][] countsOfAlphabet = new int[NUM_OF_ALPHABETS][2];

        char ch = 'A';
        for (int i = 0; i < NUM_OF_ALPHABETS; i++, ch++) {
            countsOfAlphabet[i][0] = ch;
        }

        // 각 알파벳별 출현 회수 세서 자료 구조에 저장
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < NUM_OF_ALPHABETS; j++) {
                char alphabetToCheck = (char)countsOfAlphabet[j][0];
                if (text.charAt(i) == alphabetToCheck || text.charAt(i) == (alphabetToCheck + 32)) {
                    countsOfAlphabet[j][1]++;
                }
            }
        }

//        System.out.println(Arrays.deepToString(countsOfAlphabet)); // 2차원 배열 출력(https://hianna.tistory.com/511)해서 자료들 잘 저장되었는지 확인

        int numOfAlphabetsInTheText = 0;
        for (int i = 0; i < NUM_OF_ALPHABETS; i++) {
            numOfAlphabetsInTheText += countsOfAlphabet[i][1];
        }

//        System.out.println("텍스트 파일에 포함된 알파벳의 전체 개수 = " + numOfAlphabetsInTheText); // 6458
//        System.out.println("텍스트 파일의 전체 길이(공백, 특수문자 등 포함) = " + text.length()); // 8010 -> 문제에서 주어진 출력에서는 이 숫자 대비 각 알파벳의 출현 회수 비중 계산했음

        // 자료 구조에 저장된 자료를 사용자의 요구에 맞게 가공해서 출력 -> 2022.8.14(일) 0h30 테스트 완료
        for (int i = 0; i < NUM_OF_ALPHABETS; i++) {
            int countOfAlphabet = countsOfAlphabet[i][1];
            System.out.printf("%c =\t\t%3d개,\t%5.2f%%\n", (char)countsOfAlphabet[i][0], countOfAlphabet, (float)countOfAlphabet / numOfAlphabetsInTheText * 100);
        }
    } // main() 종료
}
