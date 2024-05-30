public class Principale {
    public static void main(String[] args){

        GrapheListe g = new GrapheListe();
        g.ajouterArc("A","D",87);
        g.ajouterArc("A","B",12);
        g.ajouterArc("C","A",19);
        g.ajouterArc("D","C",10);
        g.ajouterArc("D","B",23);
        g.ajouterArc("E","D",43);
        g.ajouterArc("B","E",11);

        System.out.println(g.listeNoeuds());
        System.out.println(g.toString());

        //BellmanFord
        long dureeTotale = 0;
        long date_debut;
        long date_fin;

        date_debut = System.nanoTime();

        Valeur v = BellmanFord.resoudre(g, "A");
        System.out.println(v);

        date_fin = System.nanoTime();

        dureeTotale += date_fin - date_debut;//duree en nanosecondes

        System.out.println(dureeTotale*10E-9);//duree en secondes


    }

}
