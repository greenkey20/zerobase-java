package exercises.src.codestates.unit6;

// 2022.8.30(화) 13h35
public class TypeInteger {
    public static void main(String[] args) {
        byte b1 = 125;
        byte b2 = -125;

        byte b3 = (byte) (b1 + 10);
        byte b4 = (byte) (b2 - 10);

        System.out.println(b1 + 10); // 135 -> 왜 이렇게 정상적으로 연산이 되지?
        System.out.println(b3); // -121, byte 타입의 오버플로우

        System.out.println(b2 - 10); // -135
        System.out.println(b4); // 121
    }
}
