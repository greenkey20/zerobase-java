package exercises.src.jumptojava.exception;

// 2023.8.13(일) 18h30

/**
 * sayNickname() 메서드에서 예외 처리
 */
public class Sample2 {
    public void sayNickname(String nickname) {
        try {
            if (nickname.equals("바보")) {
                throw new FoolException();
            }

            System.out.println("당신의 별명은 " + nickname + "입니다");

        } catch (FoolException e) {
            System.out.println("FoolException이 발생했습니다");
        }
    }

    public static void main(String[] args) {
        Sample2 sample2 = new Sample2();
        sample2.sayNickname("바보");
        sample2.sayNickname("아기곰");
    }
}
