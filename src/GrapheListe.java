import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe{
    /**
     * attribut liste des noeuds du graphe
     */
    private ArrayList<String> noeuds;
    /**
     * attribut liste des arcs reliant les noeuds du graphe
     */
    private ArrayList<Arcs> adjacence;

    /**
     * constructeur vide créant une liste d'arc et de noeuds vide
     */
    public GrapheListe(){
        this.noeuds= new ArrayList<>();
        this.adjacence= new ArrayList<>();
    }

    public GrapheListe(String fichier) throws IOException {
        this.noeuds= new ArrayList<>();
        this.adjacence= new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(fichier));

        // lecture des lignes du fichier (stocke dans une liste)
        String line = null;
        String[] tab;
        try {
            line = br.readLine();
            while ( line != null){
                tab = line.split("\t");
                this.ajouterArc(tab[0], tab[1], Double.parseDouble(tab[2]));

                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            // erreur lors de la lecture du fichier
            throw new Error("Erreur I/O de lecture du Fichier "+fichier);
        }
    }


    /**
     * methode qui renvoie l'indice du noeud en paramatetre. Renvoie -1 si noeud non présent
     * @param n noeud dont on cherche l'indice
     * @return indice du noeud
     */
    public int getIndice(String n) {
        for (int i = 0; i < noeuds.size(); i++) {
            if (noeuds.get(i).equals(n)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * methode qui permet d'ajouter un arc au graphe
     * @param depart noeud de depart
     * @param destination noeud final
     * @param cout cout de l'arc
     */
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

    /**
     * methode qui renvoie la liste de tous les noeuds du graphe
     * @return liste des noeuds
     */
    public List<String> listeNoeuds(){
        ArrayList<String> ls = new ArrayList<>();
        for(int i=0;i<this.noeuds.size();i++){
            ls.add(this.noeuds.get(i));
        }
        return ls;
    }

    /**
     * methode qui renvoie une liste des arcs auxquels l'on peut acceder depuis l'arc de nom n
     * @param n Nom de l'arc
     * @return liste des arcs adjacents
     */
    public List<Arc> suivants(String n) {
        int indice = getIndice(n);
        if (indice != -1) {
            return new ArrayList<>(adjacence.get(indice).getArcs());
        }
        return new ArrayList<>();
    }

    /**
     * override de la methode toString affichant le graphe sous forme
     * A -> B(12) D(87)
     * @return chaine de caractere toString pour l'utilisateur
     */
    public String toString() {
        String s="";
        for(int i=0;i<this.noeuds.size();i++){
            s+=this.noeuds.get(i)+" -> ";
            for(int j=0;j<this.adjacence.get(i).getArcs().size();j++){
                s+=this.adjacence.get(i).getArcs().get(j).toString()+" ";
            }
            s+="\n";
        }
        return s;
    }

}
