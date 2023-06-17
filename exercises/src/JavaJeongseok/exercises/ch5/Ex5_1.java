package exercises.src.JavaJeongseok.exercises.ch5;

// 2023.6.18(일) 0h20
/* 배열 = 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것
 */
public class Ex5_1 {
    public static void main(String[] args) {
        int[] arr1[];
        arr1 = new int[2][];

        int[] arr2 = {1, 2, 3, };

        int[] arr3 = new int[5];

//        int[] arr4 = new int[5] {1, 2, 3, 4, 5}; // 오류 -> 아래와 같이 사용해야 함
        int[] arr4a = new int[]{1, 2, 3, 4, 5, };
        int[] arr4b = {1, 2, 3, 4, 5, };

//        int arr5[5]; // 배열 선언 시에는 배열의 크기 지정할 수 없음 -> 오류
        int arr5[];
        arr5 = new int[5];

        int[] arr6[] = new int[3][];
    }
}
