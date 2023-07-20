package br.com.ideao.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveCount {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,3,5,4,5,6,7));
        int[] arr2 = {1,3,5,4,5,6,7};
        System.out.println(count(arr));
        System.out.println(count(arr2));


    }

    private static int count(List<Integer> arr) {
        if(arr.size() == 0) {
            return 0;
        }
        arr.remove(0);
        return 1 + count(arr);
    }

    private static int count(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }
        return 1 + count(Arrays.copyOfRange(arr, 1, arr.length));
    }
}
