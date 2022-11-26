import java.util.ArrayList;

public class ValuesSorter {

    // Java program for implementation of QuickSort

    /* This function takes last element as pivot,
    places the pivot element at its correct
    position in sorted array, and places all
    smaller (smaller than pivot) to left of
    pivot and all greater elements to right
    of pivot */
    static int partition(ArrayList<float[]> arr, int low, int high) {
        low = 0;
        high = arr.size() - 1;
        float pivot = arr.get(high)[2];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr.get(j)[2] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                float[] temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        float[] temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }


    /* The main function that implements QuickSort()
    arr[] --> Array to be sorted,
    low --> Starting index,
    high --> Ending index */
    static void quickSort(ArrayList<float[]> arr, int low, int high) {
        if (low < high) {
			/* pi is partitioning index, arr[pi] is
			now at right place */
            int pi = partition(arr, low, high);

            if (pi - low <= high - (pi + 1)) {
                quickSort(arr, low, pi);
                low = pi + 1;
            } else {
                quickSort(arr, pi + 1, high);
                high = pi;
            }
        }
    }

    static void bubbleSort(ArrayList<float[]> arr) {
        int n = arr.size();
        float[] temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if ((arr.get(j - 1)[1] > arr.get(j)[1]) ||
                        ((arr.get(j - 1)[1] == arr.get(j)[1]) && (arr.get(j - 1)[2] > arr.get(j)[2])) ||
                        ((arr.get(j - 1)[1] == arr.get(j)[1]) && (arr.get(j - 1)[2] == arr.get(j)[2]) && (arr.get(j - 1)[0] > arr.get(j)[0]))) {
                    //swap elements
                    temp = arr.get(j - 1);
                    arr.set(j - 1, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        int debug = 0;
    }
}

