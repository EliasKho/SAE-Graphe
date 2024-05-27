package laby;

import java.util.List;

public class Arcs {
    private List<Arc> arcs;

    public Arcs(List<Arc> arcs) {
        this.arcs = arcs;
    }

    public void ajouterArc(Arc a){
        this.arcs.add(a);
    }

    public List<Arc> getArcs() {
        return arcs;
    }
}
