package clique;

public class Sommet {
    public String nomSommet;

    public Sommet(String nomSommet) {
        this.nomSommet = nomSommet;
    }

    @Override
    public String toString() {
        return " sommet d'id = " + nomSommet;
    }    
    

    public void ColorierRouge(){
        FXML_Clique.cref.colorierRouge(this);
    }
    
    public void ColorierVert(){
        FXML_Clique.cref.colorierVert(this);
    }
    
    public void ColorierJaune(){
        FXML_Clique.cref.colorierJaune(this);
    }
    
    public void ColorierGris(){
        FXML_Clique.cref.colorierGris(this);
    }
}
