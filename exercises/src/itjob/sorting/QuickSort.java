package exercises.src.itjob.sorting;

import java.util.Arrays;

// 2023.11.11(토) 13h55
public class QuickSort {

    /**
     * 목록 안의 한 요소를 선택해서 이 값보다 작은 것을 왼쪽으로, 큰 것을 오른쪽으로 옮긴 후에, 그 왼쪽에 있는 목록과 오른쪽에 있는 목록에 대해 동일한 작업을 반복
     * 나눈 부분이 더 이상 분할되지 않을 때까지 정렬을 지속적으로 수행
     *
     * @param list
     * @param left
     * @param right
     */
    static void quickSort(int[] list, int left, int right) {
        System.out.println("left = " + left + ", right = " + right + ", list = " + Arrays.toString(list));

        int lowIndex, highIndex, pivot;

        if (left < right) {
            lowIndex = left;
            highIndex = right;

            pivot = list[(left + right) / 2];

            while (lowIndex < highIndex) {
                System.out.println("lowIndex = " + lowIndex + ", highIndex = " + highIndex + ", list = " + Arrays.toString(list));

                while (list[highIndex] > pivot) highIndex--;
                while ((lowIndex < highIndex) && (list[lowIndex] < pivot)) lowIndex++;

                int tempValue = list[lowIndex];
                list[lowIndex] = list[highIndex];
                list[highIndex] = tempValue;
            }

            quickSort(list, left, lowIndex - 1);
            quickSort(list, lowIndex + 1, right);
        }


    }

}
