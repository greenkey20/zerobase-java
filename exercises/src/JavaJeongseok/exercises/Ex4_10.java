package exercises.src.JavaJeongseok.exercises;

// 2022.8.10(수) 23h50
public class Ex4_10 {
    public static void main(String[] args) {
        int num = 12345;
        int sum = 0;

        String numString = String.valueOf(num);

        for (int i = 0; i < numString.length(); i++) { // cf. String.valueOf(num).length()
            sum += num % 10;
            num = num / 10;
        }

        System.out.println("sum = " + sum);
    }
}
