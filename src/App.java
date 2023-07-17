import br.com.ideao.algoritmos.BinarySearch;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Algoritmo busca binaria");
        int[] lista = {1,2,3,4,5, 6, 22};
        BinarySearch bs = new BinarySearch();
        int pos = bs.search(lista, 1);
        System.out.println(lista[pos]);
    }
}
