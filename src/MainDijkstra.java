public class MainDijkstra {
    public static void main(String[] args) {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A","B",2);
        g.ajouterArc("A","C",4);
        g.ajouterArc("B","D",2);
        g.ajouterArc("C","D",4);
        g.ajouterArc("E","D",5);
        g.ajouterArc("C","E",3);

        Valeur vObtenue = Dijkstra.resoudre(g, "A");

        System.out.println(vObtenue);
    }

}
