import org.junit.jupiter.api.Test;

public class TestGraphe {
    @Test
    public void test_GrapheListe_constructeur(){
        GrapheListe grapheListe = new GrapheListe();

        grapheListe.ajouterArc("A", "B", 3);
        grapheListe.listeNoeuds();
    }
}
