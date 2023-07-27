package br.com.ideao.algorithms.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dijkstra {
    private static Map<String, Map<String, Double>> graph = new HashMap<>();
    private static List<String> processed = new ArrayList<>();
    public static void main(String[] args) {
                        // vertice vizinhos
                        //    |
                        //    v 
        graph.put("begin", new HashMap<>());
        graph.get("begin").put("a", 6.00);
        graph.get("begin").put("b", 2.00);

        graph.put("a", new HashMap<>());
        graph.get("a").put("end", 1.00);

        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3.00);
        graph.get("b").put("end", 5.00);
        graph.put("end", new HashMap<>());

        // tabela de custos
        Map<String, Double> costs = new HashMap<>();
        costs.put("a", 6.00);
        costs.put("b", 2.00);
        costs.put("end", Double.POSITIVE_INFINITY);

        //tabelas dos pais
        Map<String, String> parents = new HashMap<>();
        parents.put("a", "begin");
        parents.put("b", "begin");
        parents.put("end", null);

        
        String node = findLowestCost(costs); // busca a key do lowestCost tabela custo
        while(node != null){
            Double cost = costs.get(node); // valor do lowestCost
            Map<String, Double > neighbors = graph.get(node); //vizinhos do lowestCost no grafo.
            
            for (String n : neighbors.keySet()) { // percorre cada vizinho.
                Double newCost = cost + neighbors.get(n); // valor do lowestCost + valor do vizinho.

                if(costs.get(n) > newCost) { // valor atual do vizinho na tabela de custo > newCost.
                    costs.put(n, newCost); // atualiza o valor do vizinho na tabela de custo.
                    parents.put(n, node); //  atualiza o pai do vizinho, que será lowestCost.
                }
              
            }
             // Mark the node as processed. lowestCost
            processed.add(node); 

             // Find the next node to process, and loop
            node = findLowestCost(costs);
        }

        System.out.println(costs);
    }

    private static String findLowestCost(Map<String, Double> costs){
        Double lowestCost = Double.POSITIVE_INFINITY;
        String lowestCostNode = null;

        for (Map.Entry<String, Double> node : costs.entrySet()) {
            Double cost = node.getValue();

             // If it's the lowest cost so far and hasn't been processed yet...
            if(cost < lowestCost && !processed.contains(node.getKey()) ){
                lowestCost = cost;
                lowestCostNode = node.getKey();
            }
        }
        return lowestCostNode;
    }

}
