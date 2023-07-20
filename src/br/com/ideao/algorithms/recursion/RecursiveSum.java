package br.com.ideao.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveSum {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(4, 6, 5, 0));
        int[] arr2 = {4, 6, 5 , 0};
        
        System.out.println(sum(arr));
        System.out.println(sum(arr2));
        
    }

    private static int sum(List<Integer> arr) {
        if(arr.isEmpty()) {
            return 0;
        }
        return arr.remove(0) + sum(arr);
    }

    private static int sum(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }
        return arr[0] + sum(Arrays.copyOfRange(arr, 1, arr.length));
    }
}