public class BellmanFord {

    public static Valeur resoudre(Graphe g, String depart) {
        Valeur valeur = new Valeur();
        for (String noeud : g.listeNoeuds()) {
            valeur.setValeur(noeud, Double.MAX_VALUE);
            valeur.setParent(noeud, null);
        }
        valeur.setValeur(depart, 0);

        boolean changed;
        do {
            changed = false;
            for (String u : g.listeNoeuds()) {
                for (Arc arc : g.suivants(u)) {
                    String v = arc.getDest();
                    double cout = arc.getCout();
                    if (valeur.getValeur(u) + cout < valeur.getValeur(v)) {
                        valeur.setValeur(v, valeur.getValeur(u) + cout);
                        valeur.setParent(v, u);
                        changed = true;
                    }
                }
            }
        } while (changed);

        return valeur;
    }
}