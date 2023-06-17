package exercises.src.JavaJeongseok.exercises.ch5;

// 2023.6.18(일) 0h35
public class Ex5_4 {
    public static void main(String[] args) {
        int[][] arr = {
                {5, 5, 5, 5, 5},
                {10, 10, 10, 10, 10},
                {20, 20, 20, 20, 20},
                {30, 30, 30, 30, 30}};

        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
                count++;
            }
        }

        double average = (double) sum / count;

        System.out.println("sum = " + sum);
        System.out.println("average = " + average);
    }
}
