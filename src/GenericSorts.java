import java.util.Arrays;

public class GenericSorts {

    // Generic Bubble Sort
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // Swap array[j] and array[j+1]
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;  // Stop if no swaps occurred in the last pass
        }
    }

    // Generic Merge Sort
    public static <T extends Comparable<T>> void mergeSort(T[] array) {
        if (array.length < 2) return;  // Base case: array is already sorted
        int mid = array.length / 2;
        T[] left = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid, array.length);
        
        mergeSort(left);  // Recursively sort the left half
        mergeSort(right); // Recursively sort the right half
        merge(array, left, right); // Merge the sorted halves
    }

    private static <T extends Comparable<T>> void merge(T[] array, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        // Copy remaining elements from left and right arrays
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Integer[] intArray = {5, 3, 8, 4, 2};
        String[] stringArray = {"Banana", "Apple", "Cherry", "Date"};

        System.out.println("Original Integer Array: " + Arrays.toString(intArray));
        bubbleSort(intArray);
        System.out.println("Sorted Integer Array with Bubble Sort: " + Arrays.toString(intArray));

        System.out.println("\nOriginal String Array: " + Arrays.toString(stringArray));
        mergeSort(stringArray);
        System.out.println("Sorted String Array with Merge Sort: " + Arrays.toString(stringArray));
    }
}
