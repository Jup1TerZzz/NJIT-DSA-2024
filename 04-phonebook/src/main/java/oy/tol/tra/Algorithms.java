package oy.tol.tra;

import java.util.function.Predicate;

public class Algorithms {
    //The generic method for reversing an array: reverse
    // Reverses the order of elements in the given array.
    public static <T> void reverse(T[] array) {
        int i = 0;
        // Iterates through the array until reaching the midpoint, swapping elements.
        while (i < array.length / 2) {
            swap(array, i, array.length - i - 1); // Swaps elements at positions i and array.length-i-1
            i++;
        }
    }

    //Bubble sort is replaced by quick sort!!!
    //The generic method for sorting an array: sort (bubble sort)
    // Sorts the array using the bubble sort algorithm.
    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1); // Swaps elements if they are in the wrong order
                }
            }
        }
    }

    // The generic method for sorting an array: sort (quick sort)
    // Sorts the array using the quick sort algorithm.
    public static <E extends Comparable<E>> void fastSort(E[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        quickSort(array, 0, array.length - 1); // Initiates quicksort algorithm
    }

    //The body part of quicksort, using recursion
    // Recursively sorts the array using the quick sort algorithm.
    public static <E extends Comparable<E>> void quickSort(E[] array, int begin, int end) {
        if (begin < end) {
            int q = partition(array, begin, end); // Partitions the array and returns the pivot index
            quickSort(array, begin, q - 1); // Sorts the left sub-array
            quickSort(array, q + 1, end); // Sorts the right sub-array
        }
    }

    //The core part of quicksort
    // Partitions the array and returns the pivot index.
    private static <E extends Comparable<E>> int partition(E[] array, int begin, int end) {
        int i = begin - 1;
        for (int leftIndex = begin; leftIndex < end; leftIndex++) {
            if (array[leftIndex].compareTo(array[end]) < 0) {
                i++;
                swap(array, i, leftIndex); // Swaps elements if they are less than the pivot
            }
        }
        swap(array, i + 1, end); // Places the pivot element at its correct position
        return i + 1; // Returns the pivot index
    }

    //The generic method used to swap two elements of an array: swap
    // Swaps two elements in the given array.
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Performs binary search on the given array within the specified range.
    public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            return -1; // Returns -1 if the value is not found
        }

        int middle = (fromIndex + toIndex) / 2;

        if (aValue.compareTo(fromArray[middle]) == 0) {
            return middle; // Returns the index if the value is found at the middle position
        } else if (aValue.compareTo(fromArray[middle]) < 0) {
            return binarySearch(aValue, fromArray, fromIndex, middle - 1); // Searches in the left half of the array
        } else {
            return binarySearch(aValue, fromArray, middle + 1, toIndex); // Searches in the right half of the array
        }

    }

    // Partitions the array based on the given rule.
    public static <T> int partitionByRule(T[] array, int count, Predicate<T> rule) {
        // Find first element rules applies to.
        // Index of that element will be in variable index.
        int index = 0;
        for (; index < count; index++) {
            if (rule.test(array[index])) {
                break;
            }
        }
        // If went to the end, nothing was selected so quit here.
        if (index >= count) {
            return count; // Returns count if no elements satisfy the rule
        }
        // Then start finding not selected elements starting from next from index.
        // If the element is not selected, swap it with the selected one.
        int nextIndex = index + 1;
        // Until end of array reached.
        while (nextIndex != count) {
            if (!rule.test(array[nextIndex])) {
                swap(array, index, nextIndex); // Swaps elements if the rule is not satisfied
                // If swapping was done, add to index since now it has non-selected element.
                index++;
            }
            nextIndex++;
        }
        return index; // Returns the index after partitioning
    }

}
