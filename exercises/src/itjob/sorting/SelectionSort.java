package exercises.src.itjob.sorting;

import java.util.Arrays;

// 2023.10.31(화) 20h10
public class SelectionSort {

    /**
     * 목록의 첫번째 위치부터 최소값을 찾아서 앞으로 이동
     * 목록의 크기가 작으면 빠름 vs 목록의 크기가 커질수록 속도가 매우 느려짐
     *
     * @param list
     */
    static void selectionSort(int[] list) {
        int indexMin, tempValue;
        int listLength = list.length;

        for (int outLoop = 0; outLoop < listLength - 1; outLoop++) {
            indexMin = outLoop;

            System.out.println("outLoop = " + outLoop + " -> list = " + Arrays.toString(list)); // todo

            for (int inLoop = outLoop + 1; inLoop < listLength; inLoop++) {
                if (list[inLoop] < list[indexMin]) indexMin = inLoop;
            }

            // outLoop 뒤의 요소 중 가장 작은 요소와 outLoop 요소의 자리를 바꿈
            tempValue = list[indexMin];
            list[indexMin] = list[outLoop];
            list[outLoop] = tempValue;
        }
    }
}
