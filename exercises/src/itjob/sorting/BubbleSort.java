package exercises.src.itjob.sorting;

import java.util.Arrays;

// 2023.11.11(토) 13h25
public class BubbleSort {

    /**
     * 목록의 첫번째 위치부터 바로 다음 값과 비교해서 작은 값을 왼쪽에, 큰 값을 오른쪽에 오도록 위치를 바꿈
     *
     * @param list
     */
    static void bubbleSort(int[] list) {
        int tempValue;
        int listLength = list.length;

        for (int outLoop = 0; outLoop < listLength; outLoop++) {
            System.out.println("outLoop = " + outLoop + " -> list = " + Arrays.toString(list));

            for (int inLoop = 1; inLoop < listLength; inLoop++) {
                if (list[inLoop] < list[inLoop - 1]) {
                    tempValue = list[inLoop - 1];
                    list[inLoop - 1] = list[inLoop];
                    list[inLoop] = tempValue;
                }
            }
        }
    }
}
