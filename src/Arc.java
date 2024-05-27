/**
 * Classe representant un arc partant d'un noeud
 */
public class Arc {
    /**
     * nom du noeud destination de l'arc
     */
    private String dest;
    /**
     * cout (ou poids) de l'arc
     */
    private double cout;

    /**
     * construit un arc
     * @param dest
     * @param cout
     */
    public Arc(String dest, double cout){
        this.dest = dest;
        if (cout > 0){
            this.cout = cout;
        }
        else {
            this.cout = 1;
        }

    }

}
