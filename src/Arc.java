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
     * getter de l'attribut dest
     * @return destination de l'arc
     */
    public String getDest() {
        return dest;
    }

    /**
     * getter de l'attribut cout
     * @return cout de l'arc
     */
    public double getCout() {
        return cout;
    }

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

    /**
     * override de la methode to string pour afficher un Arc sous la forme dest(cout)
     * @return
     */
    public String toString() {
        String s = this.dest+"(";
        if(this.cout%1==0)
            s+=(int)this.cout;
        return s+")";
    }

}
