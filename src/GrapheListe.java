import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe{
    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;

    public GrapheListe(){
        this.noeuds= new ArrayList<>();
        this.adjacence= new ArrayList<>();
    }

    public int getIndice(String n) {
        for (int i = 0; i < noeuds.size(); i++) {
            if (noeuds.get(i).equals(n)) {
                return i;
            }
        }
        return -1;
    }

    public void ajouterArc(String depart, String destination, double cout){
        if(!noeuds.contains(depart)){
            noeuds.add(depart);
            adjacence.add(new Arcs(new ArrayList<>()));
        }
        if(!noeuds.contains(destination)){
            noeuds.add(destination);
            adjacence.add(new Arcs(new ArrayList<>()));
        }
        this.adjacence.get(this.getIndice(depart)).ajouterArc(new Arc(destination,cout));
    }
        //on ne peut pas recuperer l'élément de la liste adjacente car elle est vide

    public List<String> listeNoeuds(){
        ArrayList<String> ls = new ArrayList<>();
        for(int i=0;i<this.noeuds.size();i++){
            ls.add(this.noeuds.get(i));
        }
        return ls;
    }

    public List<Arc> suivants(String n) {
        int indice = getIndice(n);
        if (indice != -1) {
            return new ArrayList<>(adjacence.get(indice).getArcs());
        }
        return new ArrayList<>();
    }

    public String toString() {
        String s="";
        for(int i=0;i<this.noeuds.size();i++){
            s+="Partant de "+this.noeuds.get(i)+":\n";
            for(int j=0;j<this.adjacence.get(i).getArcs().size();j++){
                s+="-----"+this.adjacence.get(i).getArcs().get(j).toString()+"\n";
            }
        }
        return s;
    }
}
