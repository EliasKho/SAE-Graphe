import org.junit.jupiter.api.Test;

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
        BellmanFord.resoudre(g, "A");
    }
}