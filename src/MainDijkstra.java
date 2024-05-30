public class MainDijkstra {
    public static void main(String[] args) {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A","B",2);
        g.ajouterArc("A","C",4);
        g.ajouterArc("B","D",2);
        g.ajouterArc("C","D",4);
        g.ajouterArc("E","D",5);
        g.ajouterArc("C","E",3);

        long dureeTotale = 0;
        long date_debut;
        long date_fin;

        date_debut = System.nanoTime();
        Valeur vObtenue = Dijkstra.resoudre(g, "A");

        System.out.println(vObtenue);
        date_fin = System.nanoTime();

        dureeTotale += date_fin - date_debut;//duree en nanosecondes

        System.out.println(dureeTotale*10E-9);//duree en secondes

    }

}
