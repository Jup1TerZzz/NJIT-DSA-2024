package oy.tol.tra;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Algorithms {
    /**
     * The generic method for reversing an array: reverse
     */
    public static <T> void reverse(T[] array) {
        int i = 0;
        while (i < array.length / 2) {
            swap(array, i, array.length - i - 1);
            i++;
        }
    }


    /**
     * The generic method for sorting an array: sort (bubble sort)
     */
//    public static <T extends Comparable<T>> void sort(T[] array) {
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = 0; j < array.length - 1 - i; j++) {
//                if (array[j].compareTo(array[j + 1]) > 0) {
//                    swap(array, j, j + 1);
//                }
//
//            }
//        }
//    }


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


    //This is quick sort for later tasks
   /* public static <T extends Comparable<T>> void sort(T [] array){
        if (array == null || array.length <= 1){
            return;
        }
        quickSort(array,0,array.length-1);
    }

    //The body part of quicksort, using recursion
    private static <T extends Comparable<T>> void quickSort(T [] array,int left,int right){
        if (left < right){
            int q = partition(array,left,right);
            quickSort(array,left,q-1);
            quickSort(array,q+1,right);
        }
    }

    //The core part of quicksort
    private static <T extends Comparable<T>> int partition(T [] array,int left,int right){
        int i = left-1;
        for (int leftIndex = left;leftIndex<right;leftIndex++){
            if (array[leftIndex].compareTo(array[right])<0){
                i++;
                swap(array,i,leftIndex);
            }
        }
        swap(array,i+1,right);
        return i+1;
    }*/

    //The generic method used to swap two elements of an array: swap
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
