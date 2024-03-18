package task_4;

import java.util.Comparator;

public class Sort {
    public static void main(String[] args) {
        int[] data = new int[]{2, 6, 8, 9, 5, 15, 12, 12, 13, 10};
        boolean[] fixed = new boolean[]{false, true, false, true, false, false, false, false, false, false};

       // modifiedSortForT(data, fixed);
        modifiedSort(data, fixed);
    }

    public static <T> void modifiedSortForT(T[] data, boolean[] fixed, Comparator<T> c) {
        int size = data.length;
        for (int i = 0; i < size - 1; i++) {
            if (fixed[i]) {
                continue;
            }
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (fixed[j]) {
                } else if (c.compare(data[j], data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
        for (T val : data) {
            System.out.print(val + " ");
        }
    }

    public static void modifiedSort(int[] data, boolean[] fixed) {
        int size = data.length;
        for (int i = 0; i < size - 1; i++) {
            if (fixed[i]) {
                continue;
            }
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (fixed[j]) {
                } else if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
        for (int val : data) {
            System.out.print(val + " ");
        }
    }
}
