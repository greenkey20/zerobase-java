package exercises.src.JavaJeongseok.exercises.ch5;

// 2023.6.18(일) 0h30
public class Ex5_2 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.println("배열 arr의 원소의 합 = " + sum);
    }
}
