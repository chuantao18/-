package algrotithm.sort;

import org.junit.Test;

public class SimpleSort {

    public void insertSort(int a[], int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    //data remove
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            //insert data
            a[j + 1] = value;
        }
        for (int value : a) {
            System.out.print(value + " ,");
        }
    }

    public void selectionSort(int a[], int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
        for (int value : a) {
            System.out.print(value + " ,");
        }
    }

    @Test
    public void testInsertSort() {
        int a[] = {4, 5, 7, 6, 1, 2, 3};
        insertSort(a, 7);
    }

    @Test
    public void testSelectSort() {
        int a[] = {4, 5, 7, 6, 1, 2, 3,8};
        selectionSort(a, 8);
    }

}
