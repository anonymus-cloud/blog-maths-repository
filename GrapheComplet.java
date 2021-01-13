package clique;

import java.util.Arrays;
import java.util.List;

public class GrapheComplet {

    public static boolean SousGraphComplet(Graphe G, Sommet[] sommets){
        GrapheColor.ChoisirSousGraphe(sommets);
        WaitDelay();
        int i = 0;
        while (i < sommets.length) {
            for(int j = i + 1;j < sommets.length;j++){
                GrapheColor.ChoisirSousGraphe(sommets);
                if(!G.edgeExists(sommets[i], sommets[j])){
                    GrapheColor.ChoisirAreteManquante(sommets[i], sommets[j]);
                    WaitDelay();
                    return false;
                }
                else{
                    GrapheColor.ChoisirAreteExistante(sommets[i], sommets[j]);
                    WaitDelay();
                }
            }
            i++;
        }
        return true;
    }
    

    public static boolean SousGraphComplet(Graphe G, List<Sommet> sommets){
        return SousGraphComplet(G, sommets.toArray(new Sommet[0]));
    }
    

    public static List<Sommet> CliqueMaximale(Graphe G, Sommet[] sommets){

        if(sommets == null || sommets.length == 0){
            return null;
        }
        int i = sommets.length;
        while (i > 1) {
            FXML_Clique.cref.SetUIText(0, "Parcours des sous-graphes de taille : " + i);
            List<List<Sommet>> sousGraphes = Combinaisons.FindCombinations(sommets, i);
            for(List<Sommet> l : sousGraphes){
                GrapheColor.InitGraphColor(sommets);
                if(SousGraphComplet(G, l)){
                    return l;
                }
            }
            i--;
        }
        return Arrays.asList(new Sommet[]{sommets[0]});
    }

    public static List<Sommet> CliqueMaximale(Graphe G, List<Sommet> sommets){
        return CliqueMaximale(G, sommets.toArray(new Sommet[0]));
    }
    
    private static Thread currentThread = null;
    
    public static void TrouverCliqueMaximale(Graphe graphe){
        currentThread = Thread.currentThread();
        Sommet[] l = CliqueMaximale(graphe, graphe.nodeList()).toArray(new Sommet[0]);
        GrapheColor.InitGraphColor(graphe.nodeList());
        GrapheColor.CliqueTrouvee(l
                );
    }
    
    public static void WaitDelay(){
        try
        {
           Thread.sleep(1000);
        }
        catch(Exception e){}
        finally{
            if(!FXML_Clique.cref.playing || currentThread != Thread.currentThread()){
                WaitDelay();
            }
        }
    }
}