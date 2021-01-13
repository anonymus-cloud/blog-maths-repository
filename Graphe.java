package clique;


import java.util.*;


public class Graphe {

    private final Map<Sommet, Set<Sommet>> adjencList = new HashMap<>();

    public Graphe(List<FXMLCanvas.Noeud> l1, List<FXMLCanvas.Bord> l2) {
        for(FXMLCanvas.Noeud n: l1){
            Sommet s = new Sommet(n.id.getText());
            n.sommet = s;
            addNode(s);
        }
        
        for(FXMLCanvas.Bord e: l2){
            edge(e.node1.sommet, e.node2.sommet);
        }
    }
    
    public void addNode(Sommet node) {
        if (!adjencList.containsKey(node)) {
            adjencList.put(node, new HashSet<>());
        }
    }

    public void edge(Sommet node1, Sommet node2) {
        addNode(node1);
        addNode(node2);
        adjencList.get(node1).add(node2);
        adjencList.get(node2).add(node1);
    }


    public Set<Sommet> adjencNodes() {
        return Collections.<Sommet>unmodifiableSet(adjencList.keySet());
    }


    public boolean edgeExists(Sommet node1, Sommet node2) {
        if (!adjencList.containsKey(node1)) {
            return false;
        }

        if (!adjencList.containsKey(node2)) {
            return false;
        }

        return adjencList.get(node1).contains(node2);
    }

    public int size() {
        return adjencList.size();
    }
    
    public Sommet[] nodeList(){
        return adjencList.keySet().toArray(new Sommet[0]);
    }
}

