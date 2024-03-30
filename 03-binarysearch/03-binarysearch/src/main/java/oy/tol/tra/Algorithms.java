package oy.tol.tra;

public class Algorithms {
    /**
     * Swaps two elements in a generic array.
     *
     * @param array The array in which elements are to be swapped.
     * @param i     Index of the first element to be swapped.
     * @param j     Index of the second element to be swapped.
     * @param <T>   The type of elements in the array.
     */
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i]; // Store the value of the first element in a temporary variable.
        array[i] = array[j]; // Assign the value of the second element to the first.
        array[j] = temp; // Assign the value stored in the temporary variable to the second element.
    }


    /**
     * A generic method to reverse an array.
     *
     * @param array The array to be reversed.
     * @param <T>   The type of elements in the array.
     */
    public static <T> void reverse(T[] array) {
        int i = 0; // Initialize the left pointer.
        while (i < array.length / 2) { // Loop until the left pointer exceeds half of the array.
            swap(array, i, array.length - i - 1); // Swap elements at left and right positions.
            i++; // Move the left pointer to the next position.
        }
    }


    /**
     * The generic method for sorting an array: sort (selection sort)
     */
    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(array, i, minIndex);
            }
        }
    }

    /**
     * Sorts the given array using quicksort algorithm.
     * The elements in the array must implement Comparable interface.
     *
     * @param array The array to be sorted.
     * @param <E>   The type of elements in the array.
     */
    public static <E extends Comparable<E>> void fastSort(E[] array) {
        if (array == null || array.length <= 1) { // Base case: if array is null or has only one element, it's already sorted.
            return;
        }
        quickSort(array, 0, array.length - 1); // Call the quickSort method to perform the sorting.
    }

    /**
     * Helper method for quickSort. Recursively sorts the sub arrays.
     *
     * @param array The array to be sorted.
     * @param begin The index of the first element of the subarray.
     * @param end   The index of the last element of the subarray.
     * @param <E>   The type of elements in the array.
     */
    public static <E extends Comparable<E>> void quickSort(E[] array, int begin, int end) {
        if (begin < end) { // Base case: if begin index is less than end index, the subarray is valid.
            int q = partition(array, begin, end); // Partition the array and get the pivot index.
            quickSort(array, begin, q - 1); // Recursively sort the left subarray.
            quickSort(array, q + 1, end); // Recursively sort the right subarray.
        }
    }


    /**
     * Partitions the array around a pivot element and returns the index of the pivot element.
     * This method is used in the quicksort algorithm.
     *
     * @param array The array to be partitioned.
     * @param begin The index of the first element of the subarray.
     * @param end   The index of the last element of the subarray.
     * @param <E>   The type of elements in the array.
     * @return The index of the pivot element after partitioning.
     */
    private static <E extends Comparable<E>> int partition(E[] array, int begin, int end) {
        int i = begin - 1; // Initialize the index of the smaller element.
        for (int leftIndex = begin; leftIndex < end; leftIndex++) {
            if (array[leftIndex].compareTo(array[end]) < 0) { // Compare the current element with the pivot (last element).
                i++; // Increment the index of the smaller element.
                swap(array, i, leftIndex); // Swap the current element with the element at index i.
            }
        }
        swap(array, i + 1, end); // Swap the pivot element (last element) with the element at index (i + 1).
        return i + 1; // Return the index of the pivot element after partitioning.
    }


    /**
     * Performs a binary search on a sorted array to find the index of a given value.
     *
     * @param aValue    The value to search for.
     * @param fromArray The sorted array to search within.
     * @param fromIndex The starting index of the search range (inclusive).
     * @param toIndex   The ending index of the search range (inclusive).
     * @param <T>       The type of elements in the array, which must implement Comparable interface.
     * @return The index of the value in the array, or -1 if the value is not found.
     */
    public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
        // Base case: If fromIndex is greater than toIndex, the value cannot be found.
        if (fromIndex > toIndex) {
            return -1;
        }

        // Calculate the middle index of the search range.
        int middle = (fromIndex + toIndex) / 2;

        // If the value at the middle index matches the search value, return the index.
        if (aValue.compareTo(fromArray[middle]) == 0) {
            return middle;
        }
        // If the value is less than the value at the middle index, search in the left half of the array.
        else if (aValue.compareTo(fromArray[middle]) < 0) {
            return binarySearch(aValue, fromArray, fromIndex, middle - 1);
        }
        // If the value is greater than the value at the middle index, search in the right half of the array.
        else {
            return binarySearch(aValue, fromArray, middle + 1, toIndex);
        }
    }


}