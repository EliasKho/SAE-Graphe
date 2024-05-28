COSSON Alexandre et KHODJAOUI Elias

algorithme
fonction pointFixe(Graphe g InOut, Noeud depart)
    i = 0
    taille = size(g)
    noeud = depart

    //initialisation
    L(depart) -> 0
    noeud = suivant(depart)
    pour i de 0 à taille faire
        L(noeud) -> +∞
        noeud = suivant(noeud)
    fpour

    //Etape 1
    noeud -> depart
    pour i de 0 à taille faire

        tab[i] -> L(noeud)
        noeud -> suivant(noeud)

