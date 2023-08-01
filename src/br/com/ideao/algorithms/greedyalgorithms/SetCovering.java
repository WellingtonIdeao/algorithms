package br.com.ideao.algorithms.greedyalgorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class SetCovering {
    
    public static void main(String[] args) {
        Set<String> statesNeeded = new HashSet<>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        Map<String, Set<String>> stations = new LinkedHashMap<>();

        Set<String> finalStations = new HashSet<>();

       
        stations.put("kone", new HashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("ktwo", new HashSet<>(Arrays.asList("wa", "id", "mt")));
        stations.put("kthree", new HashSet<>(Arrays.asList("or", "nv", "ca")));
        stations.put("kfour", new HashSet<>(Arrays.asList("nv", "ut")));
        stations.put("kfive", new HashSet<>(Arrays.asList("ca", "az")));

        while (!statesNeeded.isEmpty()) {
            String bestStation = null;
            Set<String> statesCovered = new HashSet<>();

            for(Entry<String, Set<String>> station: stations.entrySet()) {
                var covered = new HashSet<>(statesNeeded);
                covered.retainAll(station.getValue()); //intersection

                if (covered.size() > statesCovered.size()) {
                    bestStation = station.getKey();
                    statesCovered = covered;
                }
            }
            statesNeeded.removeIf(statesCovered::contains);

            if (bestStation != null) {
                finalStations.add(bestStation);
            }    
        }
         System.out.println(finalStations); // [ktwo, kone, kthree, kfive]
        
        
       // Set<String> set1 = new HashSet<>(stations.get("kone"));
       // Set<String> set2 = new HashSet<>(stations.get("ktwo"));
        
        // set1.addAll(set2); // union
        // System.out.println("union set1 e set2: "+ set1);

        // set1.retainAll(set2); // intersection
        //System.out.println("intersection set1 e set2: "+ set1);
        
       // set1.removeAll(set2); // difference
       // System.out.println("difference set1 e set2: "+ set1);
        
    }
}
