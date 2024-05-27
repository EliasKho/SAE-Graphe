import java.util.List;
/**
 * classe qui gere une liste d'arcs
 */
public class Arcs {
    /**
     * liste d'arcs
     */
    private List<Arc> arcs;

    /**
     * construit une liste d'arcs vides
     * @param arcs
     */
    public Arcs(List<Arc> arcs) {
        this.arcs = arcs;
    }

    /**
     * ajoute l'arc à la liste d'arcs
     * @param a
     */
    public void ajouterArc(Arc a){
        this.arcs.add(a);
    }

    /**
     * getter de l'attribut arcs
     * @return liste d'arcs
     */
    public List<Arc> getArcs() {
        return arcs;
    }
}
