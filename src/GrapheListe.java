import java.util.ArrayList;

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
        if(trouve==false)
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

    }
}
