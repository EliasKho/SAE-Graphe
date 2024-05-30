import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestBellmanFord {
    @Test
    public void test_resoudre(){
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A","B",2);
        g.ajouterArc("A","C",4);
        g.ajouterArc("B","D",2);
        g.ajouterArc("C","D",4);
        g.ajouterArc("E","D",5);
        g.ajouterArc("C","E",3);

        Valeur vObtenue = BellmanFord.resoudre(g, "A");

        Valeur vAttendue = new Valeur();
        vAttendue.setValeur("A", 0);
        vAttendue.setValeur("B", 2);
        vAttendue.setParent("B", "A");
        vAttendue.setValeur("C", 4);
        vAttendue.setParent("C", "A");
        vAttendue.setValeur("D", 4);
        vAttendue.setParent("D", "B");
        vAttendue.setValeur("E", 7);
        vAttendue.setParent("E", "C");


//        assertEquals(vAttendue, vObtenue);
        // cette assertion de fonctionne pas donc je test un valeur par valeur et parent par parent, c'est pas pratique

        assertEquals(vAttendue.getValeur("A"), vObtenue.getValeur("A"));
        assertEquals(vAttendue.getParent("A"), vObtenue.getParent("A"));
        assertEquals(vAttendue.getValeur("B"), vObtenue.getValeur("B"));
        assertEquals(vAttendue.getParent("B"), vObtenue.getParent("B"));
        assertEquals(vAttendue.getValeur("C"), vObtenue.getValeur("C"));
        assertEquals(vAttendue.getParent("C"), vObtenue.getParent("C"));
        assertEquals(vAttendue.getValeur("D"), vObtenue.getValeur("D"));
        assertEquals(vAttendue.getParent("D"), vObtenue.getParent("D"));
        assertEquals(vAttendue.getValeur("E"), vObtenue.getValeur("E"));
        assertEquals(vAttendue.getParent("E"), vObtenue.getParent("E"));

        //modif

    }
}
