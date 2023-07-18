package br.com.ideao.algorithms.recursion;

public class Recursion {
    
    public static void main(String[] args) {
        countdown(10);
        System.out.println(fat(5));
    }

    private static void countdown(int i) {
        System.out.println(i);
        //base case
        if(i <= 0){
            return;
        }
        else {
            //recursive case
            countdown(i-1);
        }    
    }
    private static int fat(int n) {
        if(n == 1){
            return 1;
        }else {
            return n * fat(n-1);
        }
    }
}
