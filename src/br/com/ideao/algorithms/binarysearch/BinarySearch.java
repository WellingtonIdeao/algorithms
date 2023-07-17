package br.com.ideao.algorithms.binarysearch;

public class BinarySearch {

    public static void main(String[] args) throws Exception{
        int[] myList = {21, 45, 87, 93};
        System.out.println(binarySearch(myList, 87));
        System.out.println(binarySearch(myList, 16));
        
    }

    private static int binarySearch(int[] list, int item) { // lista ordenada
        
        if(isListEmpty(list)) {
            return -1;
        }

        int low = 0; // indice/elemento na posicao mais a esquerda/primeiro elemento.
        int high = list.length - 1; // indice/elemento na posicao mais a direita/ultimo elemento.
        
        
        while (low <= high) { // cada tentativa, você testa para o elemento central.
            int mid = (low + high)/ 2; // indice central. 
            int guess = list[mid]; // elemento central/Chute.
            
            if(guessEqualsItem(guess, item)) { // item encontrado no elemento central(meio) - retorna a posicao.
                return mid;
            }else if(guessGreaterItem(guess, item)) { // chute muito alto, atualiza "alto" proporcionalmente / corta parte direita da lista
                high = mid - 1;
            }else if(guessLessItem(guess, item)) { // chute < item) - chute muito baixo atualiza "baixo" proporcionalmente / corta parte esquerda da lista
                low = mid +1;
            }
        }
        return -1;
    }
    private static boolean isListEmpty(int[] myList) {
        return myList.length == 0 ? true: false;
    }

    private static boolean guessEqualsItem(int guess, int item){
        return guess == item ? true: false;
    }

    private static boolean guessGreaterItem(int guess, int item) {
        return guess > item ? true: false;
    }
    private static boolean guessLessItem(int guess, int item) {
        return guess < item ? true: false;
    }



}
