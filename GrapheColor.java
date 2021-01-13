//package clique;

import java.util.Arrays;

public class GrapheColor {
    

    public static void InitGraphColor(Sommet[] sommets){
        Arrays.stream(sommets).forEach(Sommet::ColorierGris);
    }
    

    public static void ChoisirSousGraphe(Sommet[] sommets){
        Arrays.stream(sommets).forEach(Sommet::ColorierJaune);
        FXML_Clique.cref.SetUIText(1, sousGraphString(sommets));
        FXML_Clique.cref.SetUIText(2, "");
    }
    
    public static void CliqueTrouvee(Sommet[] sommets){
        Arrays.stream(sommets).forEach(Sommet::ColorierVert);
        FXML_Clique.cref.SetUIText(0, "Clique maximale trouvée de taille : " + sommets.length);
        FXML_Clique.cref.SetUIText(1, sousGraphString(sommets));
        FXML_Clique.cref.SetUIText(2, "");
    }
    

    public static void ChoisirAreteExistante(Sommet s1, Sommet s2){
        s1.ColorierVert();
        s2.ColorierVert();
        FXML_Clique.cref.SetUIText(2, "Les sommets " + s1.nomSommet + " & " + s2.nomSommet
                + " sont voisins");
    }
    

    public static void ChoisirAreteManquante(Sommet s1, Sommet s2){
        s1.ColorierRouge();
        s2.ColorierRouge();
        FXML_Clique.cref.SetUIText(2, "Les sommets " + s1.nomSommet + " & " + s2.nomSommet
                + " ne sont pas voisins");
    }
    
    private static String sousGraphString(Sommet[] s){
        if(s == null || s.length == 0){
            return "{ }";
        }
        else{
            String ret = "{ " + s[0].nomSommet;
            for (int i = 0; i < s.length; i++) {
                Sommet ss = s[i];
                if (ss != s[0])
                    ret += ", " + ss.nomSommet;
            }
            
            return ret + " }";
        }
    }
}
