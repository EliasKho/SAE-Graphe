COSSON Alexandre et KHODJAOUI Elias

algorithme
fonction pointFixe(Graphe g InOut, Noeud depart)

    taille = size(getnoeuds(g))
    noeud = depart
    arcs = getArcs(g)

    //initialisation
    L(depart) -> 0
    noeud = suivant(depart)

    pour i de 0 à taille -1 faire
        L(noeud) -> +∞
        noeud = suivant(noeud)
    fpour

    //Etapes
    pour i de 1 à taille - 1 faire
        pour j de 0 à size(arcs) - 1 faire
            u <- getDepart(arcs[j])
            a <- getArrivee(arcs[j])
            poids <- getCout(arcs[j])
            si L(u) + poids < L(a) alors
                L(a) <- L(u) + poids
                parent(a) <- u
            fsi
        fpour
    fpour

    retourne L
fin

Lexique:
taille : entier, nombre de noeuds dans le graphe
arcs : Arc, liste des arcs du graphe
L(X) : Valeur, valeur du noeud X
u : Noeud, noeud avec lequel on test si c'est plus aventageux de passer par celui-ci
a : Noeud, noeud de l'arc actuel dont on veut réduire la distance minimale en trouvant un autre arc
poids : decimal, poids de larc dont on veut voir si il est plus aventageux






