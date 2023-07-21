package br.com.ideao.algorithms.quicksort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,0, 8, 0, 2, 6, 5, 4, 3));

        for(int i: quicksort(arr)){
            System.out.println(i);
        }
    }

    public static List<Integer> quicksort(List<Integer> arr){
        if(arr.size() < 2) {
            // base case, arrays with 0 or 1 element are already "sorted"
            return arr;

        } else {
             // recursive case
            Integer pivot = arr.get(0);

            // sub-array of all the elements less than the pivot
            List<Integer> less = new ArrayList<>();
            
            // sub-array of all the elements greater than the pivot
            List<Integer> greater = new ArrayList<>();

            for(int i= 1; i < arr.size(); i++){
                if(arr.get(i) <= pivot) {
                    less.add(arr.get(i));
                }else {
                     greater.add(arr.get(i));
                }
            }
    
            List<Integer> sorted = new ArrayList<>();

            sorted.addAll(quicksort(less));
            sorted.add(pivot);
            sorted.addAll(quicksort(greater));
            
            return sorted;
        }    
    }
}    
