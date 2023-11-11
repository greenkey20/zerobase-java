package exercises.src.itjob.sorting;

import java.util.Arrays;

// 2023.11.11(토) 13h50
public class InsertionSort {

    /**
     * 목록이 부분적으로 정렬되어있는 상태에서, 정렬되어있는 부분을 사이사이에 삽입
     * @param list
     */
    static void insertionSort(int[] list) {
        int listLength = list.length;

        for (int outLoop = 1; outLoop < listLength; outLoop++) {
            System.out.println("outLoop = " + outLoop + " -> list = " + Arrays.toString(list));

            int tempValue = list[outLoop];
            int position = outLoop - 1;

            while ((position >= 0) && (list[position] > tempValue)) {
                list[position + 1] = list[position];
                position--;
            }

            list[position + 1] = tempValue;
        }
    }
}
