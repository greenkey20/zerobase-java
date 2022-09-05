package exercises.src.JavaJeongseok.exercises.ch13;

import java.util.Scanner;
import java.util.Vector;

// 2022.9.5(월) 0h5 텍스트 기반의 타자 연습 게임
public class Ex13_8 {
    Vector words = new Vector();
    String[] data = {"Tomi", "Miffy", "Eube", "Moomin", "Snorkmaiden", "Happy", "Hyeok", "Lori", "Panda"};

    int interval = 2 * 1000; // 2초

    WordGenerator wg = new WordGenerator();

    public static void main(String[] args) {
        Ex13_8 game = new Ex13_8();

        game.wg.start();

        Vector words = game.words;

        while (true) {
            System.out.println(words);

            String prompt = ">> ";
            System.out.print(prompt);

            // 화면으로부터 line 단위로 입력 받음 -> 사용자가 단어 입력하면 Vector에서 일치하는 단어 삭제
            Scanner s = new Scanner(System.in);
            String input = s.nextLine().trim();

            int index = words.indexOf(input);

            if (index != -1) {
                words.remove(index);
            }
        }
    }


    // Vector에 2초마다 단어 1개씩 추가하는 쓰레드
    class WordGenerator extends Thread {
        public void run() {
            while(true) {
                int ranNum =(int) (Math.random() * data.length); // 0 ~ 배열 data의 마지막 인덱스 사이 난수 생성
                words.add(data[ranNum]);

                try {
                    Thread.sleep(interval); // 2초동안 멈춤 interval 설정
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } // while문 끝
        } // run() 종료
    } // WordGenerator 클래스 영역 끝
} // Ex13_8 클래스 영역 끝