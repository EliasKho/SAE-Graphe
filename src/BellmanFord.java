public class BellmanFord {

    public static Valeur resoudre(Graphe g, String depart) {
        Valeur valeur = new Valeur();
        for (int i=0;i<g.listeNoeuds().size();i++) {
            valeur.setValeur(g.listeNoeuds().get(i), Double.MAX_VALUE);
            valeur.setParent(g.listeNoeuds().get(i), null);
        }
        valeur.setValeur(depart, 0);

        boolean changer=true;
        while(changer){
            changer = false;
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