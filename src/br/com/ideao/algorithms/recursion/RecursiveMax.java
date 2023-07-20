package br.com.ideao.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveMax {
    
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(7,2,3));
        int[] arr2 = {7, 2, 3, 8};
        System.out.println(max(arr));
        System.out.println(max(arr2));
    }

    private static int max(List<Integer> arr) {
        if(arr.size() == 0) {
            return 0;
        }

        int subMax = max(arr.subList(1, arr.size()));
        return arr.get(0) > subMax ? arr.get(0): subMax; 
    }
    private static int max(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }

        int subMax = max(Arrays.copyOfRange(arr, 1, arr.length));   
        return arr[0] > subMax ? arr[0] : subMax;
    }
}
