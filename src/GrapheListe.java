import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe{
    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;

    public int getIndice(String n){
        int i=0;
        boolean trouve=false;
        while(i<noeuds.size() && !trouve){
            if(this.noeuds.get(i).equals(n))
                trouve=true;
        }
        if(!trouve)
            i=-1;
        return i;
    }

    public void ajouterArc(String depart, String destination, double cout){
        if(!noeuds.contains((String)depart)){
            noeuds.add(depart);
        }
        if(!noeuds.contains((String)destination)){
            noeuds.add(destination);
        }
        this.adjacence.get(this.getIndice(depart)).ajouterArc(new Arc(destination,cout));
    }

    public List<String> listeNoeuds(){
        ArrayList<String> ls = new ArrayList<>();
        for(int i=0;i<this.noeuds.size();i++){
            ls.add(this.noeuds.get(i));
        }
        return ls;
    }

    public List<Arc> suivants(String n){
        ArrayList<Arc> ls = new ArrayList<>();
        for(int i=0;i<this.adjacence.size();i++){
            ls.add(this.adjacence.get(this.getIndice(n)).getArcs().get(i));
        }
        return ls;
    }

}
