package oy.tol.tra;

import java.util.Arrays;

/**
 * A simple array of student grades to be used in testing
 * misbehaving algorithm for reversing the array.
 */
public class Grades {
   
   private Integer [] grades = null;

   /**
    * A constructor for building IntArrays.
    * @param grades the plain Java integer array with numbers to add.
    */
   public Grades(Integer [] grades) {
      this.grades = new Integer [grades.length];
      for (int counter = 0; counter < grades.length; counter++) {
         this.grades[counter] = grades[counter];
      }
   }

   /**
    * The method to reverse the internal Java int array.
    */
   public void reverse() {
      /* TODO:
       1. Edit the test data files to see if the reverse() really works or not.
       2. Execute the IntArrayTests to see that some of them fail.
       3. Study the code below and try to find what is the issue.
       4. Use the debugger to see the execution and variable values if necessary.
       5. Fix the issue.
       6. Transform the algorithm to <strong>use</strong> the generic one from Algorithms.java, as instructed in the readme file.
      */


     /* int i = 0;
      //Change1 i <= grades.length/2 ——> i < grades.length/2
      while (i < grades.length/2) {
         int temp = grades[i];
         grades[i] = grades[grades.length-i-1];
         grades[grades.length-i-1] = temp;
         i++;
     }*/


      //Use static methods in Algorithms classes to reverse arrays
      Algorithms.reverse(grades);
   }

   /**
    * Sorts the array to ascending order.
    */
   public void sort() {
      /* TODO:
       1. Edit the test data files to see if the sort() really works or not.
       2. Execute the IntArrayTests to see that some of them fail.
       3. Study the code below and try to find what is the issue.
       4. Use the debugger to see the execution and variable values if necessary.
       5. Fix the issue.
       6. Transform the algorithm to <strong>use</strong> the generic one from Algorithms.java as instructed in the readme file.
      */


      /*int i = grades.length-1;
      while (i > 0) {
         if (grades[i] < grades[i-1]) {
            int tmp = grades[i];
            grades[i] = grades[i-1];
            grades[i-1] = tmp;
         }
         i--;
      }*/


      //Change2 This is a bubble sort
      /*for (int i=0;i<grades.length-1;i++){
         for (int j=0;j<grades.length-1-i;j++){
            if (grades[j] > grades[j+1]) {
               int tmp = grades[j];
               grades[j] = grades[j+1];
               grades[j+1] = tmp;
            }
         }
      }*/


      //Use static methods in Algorithms classes to sort arrays
      Algorithms.sort(grades);
   }

   /**
    * Returns the plain Java int [] array for investigation.
    * @return The int array.
    */
   public Integer [] getArray() {
      return grades;
   }
}
