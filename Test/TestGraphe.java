import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGraphe {
    @Test
    public void test_GrapheListe_ajouterArc_OK(){
        GrapheListe grapheListe = new GrapheListe();
        grapheListe.ajouterArc("A", "B", 3);
        assertEquals(2, grapheListe.listeNoeuds().size(), "il doit y avoir 2 noeuds");
        assertEquals("A", grapheListe.listeNoeuds().get(0));
        assertEquals("B", grapheListe.listeNoeuds().get(1));

    }
    @Test
    public void test_GrapheListe_ajouterArc_arcsVides(){
        GrapheListe grapheListe = new GrapheListe();
        assertEquals(0, grapheListe.listeNoeuds().size(), "il doit y avoir 0 arc");
    }
    @Test
    public void test_GrapheListe_getIndice(){
        GrapheListe grapheListe = new GrapheListe();
        grapheListe.ajouterArc("A", "B", 3);
        assertEquals(0, grapheListe.getIndice("A"), "l'indice du noeud A doit être 0");
        assertEquals(1,grapheListe.getIndice("B") , "l'indice du noeud B doit être 1");
    }
    @Test
    public void test_GrapheListe_suivants(){
        GrapheListe grapheListe = new GrapheListe();
        grapheListe.ajouterArc("A", "B", 3);

        assertEquals(0, grapheListe.getIndice("A"), "l'indice du noeud A doit être 0");
        assertEquals(1, grapheListe.getIndice("B"), "l'indice du noeud B doit être 1");

        assertEquals("B", grapheListe.suivants("A").get(0).getDest(), "le successeur de A doit être B");
    }
    @Test
    public void test_GrapheListe_toString(){
        GrapheListe grapheListe = new GrapheListe();
        grapheListe.ajouterArc("A", "B", 3);
        grapheListe.ajouterArc("A", "C", 1);
        grapheListe.ajouterArc("B", "E", 11);
        assertEquals("A -> B(3) C(1) \n" + "B -> E(11) \n" + "C -> \n" + "E -> \n", grapheListe.toString());
    }




}
