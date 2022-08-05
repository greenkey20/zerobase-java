package linear.array;

// 선형 자료구조 - 배열

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // 2022.8.5(금) 23h15 수업

//      1차원 배열
        System.out.println("== 1차원 배열 ==");
        int[] arr = {1, 2, 3, 4, 5}; // 자료형[대괄호], 중괄호 { }로 데이터 만들어줌 -> 초기화한 개수에 맞춰 int형 자료형이 1차원 형태로 쭈욱 만들어짐
        for (int item: arr) { // 각각의 데이터 받을 수 있게 자료형 맞춰서 써줌: 배열 이름
            System.out.println("item = " + item);
        }

        arr[1] = 100;
        System.out.println("arr = " + arr);


//      2차원 배열
        System.out.println("== 2차원 배열 ==");
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(arr2[0][1]);

        for(int[] row: arr2) {
            for(int item: row) {
                System.out.println("item = " + item);
            }
        }


//      ArrayList - 1차원, 2차원
        System.out.println("== ArrayList ==");
        ArrayList list1 = new ArrayList(Arrays.asList(1, 2, 3));
        System.out.println("list1 = " + list1);
        list1.add(4);
        list1.add(5);
        System.out.println("list1 = " + list1);
        list1.remove(2);
        System.out.println("list1 = " + list1);
        list1.remove(Integer.valueOf(2));
        System.out.println("list1 = " + list1);

        ArrayList list2d = new ArrayList();
        ArrayList list1d1 = new ArrayList(Arrays.asList(1, 2, 3));
        ArrayList list1d2 = new ArrayList(Arrays.asList(4, 5, 6));
        list2d.add(list1d1);
        list2d.add(list1d2);
        System.out.println("list1d1 = " + list1d1);
        System.out.println("list1d2 = " + list1d2);
        System.out.println("list2d = " + list2d);
    }
}