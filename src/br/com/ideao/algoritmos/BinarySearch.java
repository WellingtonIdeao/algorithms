package br.com.ideao.algoritmos;

public class BinarySearch {
    
    public int search(int[] lista, int item) { // lista ordenada

        int baixo = 0; // indice/elemento na posicao mais a esquerda/primeiro elemento.
        int meio = 0; // indice central
        int alto = lista.length - 1; // indice/elemento na posicao mais a direita/ultimo elemento.
        
        int chute = 0; // elemento central.

        while (baixo <= alto) { // cada tentativa, você testa para o elemento central.
            meio = (baixo + alto)/ 2; 
            chute = lista[meio]; // elemento central.
            
            if(chute == item) { // item encontrado no elemento central(meio) - retorna a posicao.
                return meio;
            }
            if(chute > item) { // chute muito alto, atualiza "alto" proporcionalmente / corta parte direita da lista
                alto = meio - 1;
            }
            else { // chute < item) - chute muito baixo atualiza "baixo" proporcionalmente / corta parte esquerda da lista
                baixo = meio +1;
            }
        }
        return -1;
    }
}
