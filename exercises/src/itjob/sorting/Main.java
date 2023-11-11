package exercises.src.itjob.sorting;

import static exercises.src.itjob.sorting.BubbleSort.bubbleSort;
import static exercises.src.itjob.sorting.QuickSort.quickSort;
import static exercises.src.itjob.sorting.SelectionSort.selectionSort;

public class Main {
    public static void main(String[] args) {
        System.out.println("----selection sort----");
        int[] list = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        selectionSort(list);

        System.out.println("----bubble sort----");
        list = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        bubbleSort(list);

        System.out.println("----quick sort----");
        list = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int left = 0;
        int right = 8;
        quickSort(list, left, right);


    }
}
