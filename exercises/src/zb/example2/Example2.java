package exercises.src.zb.example2;

import java.util.Arrays;

// 2022.8.13(토) 19h 해설 강의
/* 외부 라이브러리 연동
기본적인 개념 배우고 응용해서(o) 모든 것을 다 배우고(x) 문제 해결해가는 과정
불편하더라도 계속 부딪히며 해 가야 함 + 시간 및 금전 투자한만큼 적극적으로 많이 얻어가야 함
 */
public class Example2 {
    public static void main(String[] args) {
        String filePath = "/Users/greenpianorabbit/zerobase/zerobase-java/exercises/src/zb/example2/president19 inauguration.txt";

        FileUtils fileUtils = new FileUtils(); // FileUtils 클래스의 객체 생성 <- new + 생성자
//        String text = fileUtils.getLoadText(filePath).replace(" ", ""); // 알파벳만 셀 거니까 공백 없앤 텍스트 대상 처리할까 생각했는데, 구두점도 있으니까 이 처리는 안 하기로 함
        String text = fileUtils.getLoadText(filePath); // 강사님의 변수명 fileText가 더 좋은 듯..

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
        /* 2022.8.14(일) 해설 강의 강사님 설명 = a~z 각 알파벳의 개수 세기 위해/셀 수 있는 count 변수 26개 만들어야 함 + 동일한/반복되는 작업하기 위해 집합체(컬렉션 객체)나 배열 사용 -> 여기서는 그냥 배열로 진행하기로 함
        동일한/반복되는 작업하기 위해 배열(26개 동일한 거니까) 필요

        알파벳 character의 특징 = ASCII 코드 값으로 되어있음
        대문자 A의 코드 값 = 65 -> B는 1 증가해서 66..
        소문자 a의 코드 값 = 97 -> b는 1 증가해서 98.. -> z는 122

        fileText.charAt(i)으로 나오는 알파벳의 ASCII 코드 값과 배열의 첨자의 연관성 짓기
        e.g. a는 배열의 첨자(index) 0에 저장
         */
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
                if (text.charAt(i) == alphabetToCheck || text.charAt(i) == (alphabetToCheck + 32)) { // 텍스트에서 바깥 for문으로 현재 확인 중인 알파벳이 A/a, B/b, C/c..(내부 for문으로 확인 중인 알파벳)이면
                    countsOfAlphabet[j][1]++; // 해당 알파벳의 출현 회수를 1만큼 증가시킴
                }
            }
        }

//        System.out.println(Arrays.deepToString(countsOfAlphabet)); // 2차원 배열 출력(https://hianna.tistory.com/511)해서 자료들 잘 저장되었는지 확인

        int numOfAlphabetsInTheText = 0;
        for (int i = 0; i < NUM_OF_ALPHABETS; i++) {
            numOfAlphabetsInTheText += countsOfAlphabet[i][1];
        }

//        System.out.println("텍스트 파일에 포함된 알파벳의 전체 개수 = " + numOfAlphabetsInTheText); // 6458
//        System.out.println("텍스트 파일의 전체 길이(공백, 특수문자 등 포함) = " + text.length()); // 8010 -> 문제에서 주어진 출력에서는 이 숫자 대비 각 알파벳의 출현 회수 비중 계산했음 vs 강사님 해설 강의에서는 전체 알파벳(o) 문자열(x) 개수 중 비율 구하는 것이라고 정의해주심

        // 자료 구조에 저장된 자료를 사용자의 요구에 맞게 가공해서 출력 -> 2022.8.14(일) 0h30 테스트 완료
        /* 강사님 설명 = formatting은 C, Java, Python 등 거의 비슷 -> %d 정수. %f 실수/부동 소수점 형식 숫자, %c 문자, %s 문자열

         */
        for (int i = 0; i < NUM_OF_ALPHABETS; i++) {
            int countOfAlphabet = countsOfAlphabet[i][1];
            System.out.printf("%c =\t\t%3d개,\t%5.2f%%\n", (char)countsOfAlphabet[i][0], countOfAlphabet, (float)countOfAlphabet / numOfAlphabetsInTheText * 100);
        }
    } // main() 종료
}
