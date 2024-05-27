import java.util.List;

public interface Graphe {
    /**
     * methode renvoyant tous les noeuds du graphe
     * @return liste des noeuds
     */
    public List<String> listeNoeuds();

    /**
     * methode renvoyant la liste des arcs partant du noeud n passé en parametre
     * @param n
     * @return liste des arcs
     */
    public List<Arc> suivants(String n);

}
