package br.com.ideao.algorithms.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch {
    private static Map<String, List<String>> graph = new HashMap<>();
        
    public static void main(String[] args) {
        graph.put("you", Arrays.asList("alice", "bob", "claire"));
        graph.put("alice", Arrays.asList("peggy"));
        graph.put("bob", Arrays.asList("anuj", "peggy"));
        graph.put("claire", Arrays.asList("thom", "johnny"));
        
        // estas pessoas não tem vizinhos
        graph.put("anuj", Collections.emptyList());
        graph.put("peggy", Collections.emptyList());
        graph.put("thom", Collections.emptyList());
        graph.put("johnny", Collections.emptyList());

        search("you");
    }

    // tempo de execução: O(V + A).  V: números de vertices/pessoas A: números de arestas.
    private static boolean search(String name){
        Queue<String> searchQueue = new ArrayDeque<>(graph.get(name)); // colocar os nomes das pessoas na fila.
        List<String> searched = new ArrayList<>(); // mantém rastreadas as pessoas já procuradas.
        
        
        while(!searchQueue.isEmpty()) {
            String person = searchQueue.poll();
            // apenas pesquisa se esta pessoa não foi procurada
            if(!searched.contains(person)){
                if(person_is_seller(person)) {
                    System.out.println(person + " is a mango seller");
                    return true;
                } else {
                    searchQueue.addAll(graph.get(person)); // add vizinhos/vertices/arestas na fila.
                    // marcar esta pessoa como já procurada.
                    searched.add(person);
                }
            }    
        }
        return false;
        
    }
    private static boolean person_is_seller(String name){
        return name.endsWith("m");
    }
}