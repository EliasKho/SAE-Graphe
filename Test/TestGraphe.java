import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGraphe {
    @Test
    public void test_GrapheListe_ajouterArc_OK(){
        GrapheListe grapheListe = new GrapheListe();
        grapheListe.ajouterArc("A", "B", 3);
        assertEquals(grapheListe.listeNoeuds().size(), 1, "il doit y avoir 1 arc");
        assertEquals(grapheListe.listeNoeuds().getFirst(), "A");
        //bug

    }
    @Test
    public void test_GrapheListe_ajouterArc_arcsVides(){
        GrapheListe grapheListe = new GrapheListe();
        assertEquals(grapheListe.listeNoeuds().size(), 0, "il doit y avoir 0 arc");
    }
    @Test
    public void test_GrapheListe_getIndice(){
        GrapheListe grapheListe = new GrapheListe();
        grapheListe.ajouterArc("A", "B", 3);
        assertEquals(grapheListe.getIndice("A"), 0, "l'indice du noeud A doit être 0");
        assertEquals(grapheListe.getIndice("B"), 1, "l'indice du noeud B doit être 1");
    }
    @Test
    public void test_GrapheListe_suivants(){
        GrapheListe grapheListe = new GrapheListe();
        grapheListe.ajouterArc("A", "B", 3);

        assertEquals(grapheListe.getIndice("A"), 0, "l'indice du noeud A doit être 0");
        assertEquals(grapheListe.getIndice("B"), 1, "l'indice du noeud B doit être 1");

        assertEquals(grapheListe.suivants("A").getFirst().getDest(), "B", "le successeur de A doit être B");
    }




}
