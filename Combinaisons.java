package clique;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Combinaisons {

    public static List<List<Sommet>> FindCombinations(Sommet[] value, int k){
        return FindCombinations(value, 0, k, new ArrayList<>());
    }
    

    public static List<List<Sommet>> FindCombinations(List<Sommet> value, int k){
        return FindCombinations(value.toArray(new Sommet[0]), 0, k, new ArrayList<>());
    }
    

    private static List<List<Sommet>> FindCombinations(Sommet[] value, int start, int k, List<Sommet> ret){
        int n = value.length - start;
        if(k == 1){
            List<List<Sommet>> result = new ArrayList<>();
            IntStream.rangeClosed(start, start + n - k).forEach(i -> {
                List<Sommet> r2 = new ArrayList<>(ret);
                r2.add(value[i]);
                result.add(r2);
            });
            return result;
        }
        else
        {
            List<List<Sommet>> result = new ArrayList<>();
            IntStream.rangeClosed(start, start + n - k).forEach(i -> {
                List<Sommet> ret2 = new ArrayList<>(ret);
                ret2.add(value[i]);
                result.addAll(FindCombinations(value, i + 1, k - 1, ret2));
            });
            return result;
        }
    }
    
}
