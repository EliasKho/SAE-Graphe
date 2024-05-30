import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
//    fonction resoudre(Graphe g InOut, Noeud depart)
//    debut
//    Q <- {} // utilisation d’une liste de noeuds `a traiter
//    Pour chaque sommet v de G faire
//    v.valeur <- Infini

//    Q <- Q U {v} // ajouter le sommet v `a la liste Q
//    Fin Pour
//    A.valeur <- 0
//    Tant que Q est un ensemble non vide faire
//    u <- un sommet de Q telle que u.valeur est minimal
//// enlever le sommet u de la liste Q
//    Q <- Q \ {u}
//    Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
//    d <- u.valeur + poids(u,v)
//    Si d < v.valeur
//    // le chemin est plus interessant
//    Alors v.valeur <- d
//    v.parent <- u
//    Fin Si
//    Fin Pour
//    Fin Tant que
//    Fin

    //lexique à faire

    /**
     * methode pour trouver le nombre de chemins minimaux avec l'algorithme de Dijkstra
     * @param g graphe sur leuque on veut la liste des chemins minimaux
     * @param depart noeud de depart
     * @return objet Valeur contenant la liste des chemins minimaux
     */
    /**
     * Classe representant un arc partant d'un noeud
     */
    public static Valeur resoudre(GrapheListe g, String depart) {
        Valeur valeur = new Valeur();
        List<String> Q = new ArrayList<>();

        for (String noeud : g.listeNoeuds()) {
            valeur.setValeur(noeud, Double.MAX_VALUE);
            valeur.setParent(noeud, null);
            Q.add(noeud);
        }
        valeur.setValeur(depart, 0.0);

        while (!Q.isEmpty()) {
            String u = null;
            double minValeur = Double.MAX_VALUE;
            for (String noeud : Q) {
                double noeudValeur = valeur.getValeur(noeud);
                if (noeudValeur < minValeur) {
                    minValeur = noeudValeur;
                    u = noeud;
                }
            }

            Q.remove(u);

            if (u == null) break;

            List<Arc> arcs = g.suivants(u);
            for (Arc arc : arcs) {
                String v = arc.getDest();
                if (Q.contains(v)) {
                    double poids = arc.getCout();
                    double d = valeur.getValeur(u) + poids;
                    if (d < valeur.getValeur(v)) {
                        valeur.setValeur(v, d);
                        valeur.setParent(v, u);
                    }
                }
            }
        }

        return valeur;
    }

}
