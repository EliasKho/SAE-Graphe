public class BellmanFord {
    /**
     * Mehode renvoyant le chemin le plus court pour aller d'un noeud depart vers tous les autres noeuds du graphe g
     * utilisant la methode du point fixe de BellmanFord
     * @param g
     * @param depart
     * @return
     */
    /*
    algorithme
fonction pointFixe(Graphe g InOut, Noeud depart)

    taille = size(getnoeuds(g))
    noeud = depart
    arcs = getArcs(g)

    //initialisation
    L(depart) -> 0
    noeud = suivant(depart)

    pour i de 0 à taille -1 faire
        L(noeud) -> +∞
        noeud = suivant(noeud)
    fpour

    //Etapes
    pour i de 1 à taille - 1 faire
        pour j de 0 à size(arcs) - 1 faire
            u <- getDepart(arcs[j])
            a <- getArrivee(arcs[j])
            poids <- getCout(arcs[j])
            si L(u) + poids < L(a) alors
                L(a) <- L(u) + poids
                parent(a) <- u
            fsi
        fpour
    fpour

    retourne L
fin

Lexique:
taille : entier, nombre de noeuds dans le graphe
arcs : Arc, liste des arcs du graphe
L(X) : Valeur, valeur du noeud X
u : Noeud, noeud avec lequel on test si c'est plus aventageux de passer par celui-ci
a : Noeud, noeud de l'arc actuel dont on veut réduire la distance minimale en trouvant un autre arc
poids : decimal, poids de larc dont on veut voir si il est plus aventageux
     */
    public static Valeur resoudre(Graphe g, String depart) {
        Valeur valeur = new Valeur();
        //on initialise les valeurs des noeuds a l'infini
        for (int i=0;i<g.listeNoeuds().size();i++) {
            valeur.setValeur(g.listeNoeuds().get(i), Double.MAX_VALUE);
            valeur.setParent(g.listeNoeuds().get(i), null);
        }
        //la valeur du depart a 0
        valeur.setValeur(depart, 0);

        boolean changer=true;
        while(changer){
            changer = false;
            //pour tous les noeuds, on cherche le meilleur chemin vers le sommet suivant
            for (int i=0;i<g.listeNoeuds().size();i++) {
                for (int j=0;j<g.suivants(g.listeNoeuds().get(i)).size();j++) {
                    String v = g.suivants(g.listeNoeuds().get(i)).get(j).getDest();
                    double cout = g.suivants(g.listeNoeuds().get(i)).get(j).getCout();
                    if (valeur.getValeur(g.listeNoeuds().get(i)) + cout < valeur.getValeur(v)) {
                        valeur.setValeur(v, valeur.getValeur(g.listeNoeuds().get(i)) + cout);
                        valeur.setParent(v, g.listeNoeuds().get(i));
                        changer = true;
                    }
                }
            }
        }
        return valeur;
    }
}