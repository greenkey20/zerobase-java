package exercises.src.codesquad.calendar.timesquare;

public class TimeSquare {
    public int[] calculate(int index, int number) {
        int[] results = new int[number];

        for (int i = 0; i < results.length; i++) {
            results[i] = index * (i + 1);
        }

        return results;
    }

    public void print(int[] results) {
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + " ");
        }
        System.out.println();
    }

    public void square(int number) {
        for (int i = 2; i <= number; i++) {
            System.out.println("-- " + i + "단 --");
            int[] results = calculate(i, number);
            print(results);
        }
    }
}
