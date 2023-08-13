package exercises.src.jumptojava.exception;

// 2023.8.13(일) 18h

/**
 * main() 메서드로 예외 처리 던짐
 */
public class Sample1 {
    public void sayNickname(String nickname) throws FoolException {
//        try {
        if (nickname.equals("바보")) {
            throw new FoolException(); // 적극적으로 예외 발생시킴
        }

        System.out.println("당신의 별명은 " + nickname + "입니다");
//        } catch (FoolException e) {
//            throw new RuntimeException(e);
//            System.out.println("FoolException이 발생했습니다");
//        }
    }

    public static void main(String[] args) {
        Sample1 sample1 = new Sample1();
        try {
            sample1.sayNickname("바보");
            sample1.sayNickname("초록꼬마");
        } catch (FoolException e) {
            System.out.println("FoolException이 발생했습니다");
        }
    }
}

class FoolException extends /*Runtime*/Exception {

}
