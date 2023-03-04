# jeux_IA
Deux jeux de stratégie pure (Nim et TicTacToe), avec un algorithme d'intelligence artificielle implémenté

* Présentation des deux jeux :

Jeux : Nim et Tic Tac Toe

- Le jeu de Nim et l'un des jeux de stratégie pure, à deux joueurs. 
Il en existe plusieurs variantes. Ils se jouent avec des graines, des billes, des jetons,
mais dans ce dépôt j'ai utliser des allumettes.

- L'autre jeu que j'ai créé en Java est une version du célèbre jeu Tic Tac Toe, 
également connu sous le nom de morpion. Ce jeu de plateau classique est conçu pour deux joueurs, 
qui alternent entre placer des "X" et des "O" sur un tableau de 3x3 cases jusqu'à ce qu'un joueur 
ait réussi à aligner trois de ses pièces horizontalement, verticalement ou en diagonale.

Les deux jeux utilise la programmation orientée objet de Java pour créer une structure de classe propre et extensible, 
ce qui facilite la maintenance et les mises à jour. 
Les aspects abstraits de la POO sont également utilisés pour permettre l'extension facile de nouvelles fonctionnalités au jeu.

En outre, j'ai également implémenté une IA qui utilise l'algorithme negamax pour jouer contre les joueurs.
Cette IA est conçue pour toujours gagner ou au moins, pour atteindre un match nul contre un joueur humain.
L'algorithme negamax est un algorithme d'exploration de l'arbre de jeu qui est capable de trouver la meilleure solution possible 
pour le joueur qui joue en premier (le joueur X dans le cas du Tic Tac Toe).

* Point technique : 

Le dossier build contient tout les fichiers byte-code. Pour chaque package (nim et tictactoe), les classes
Test.class et Main.class sont exécutables (noté avec un 'x').

Le dossier lib contient les jars.

Le dossier src contient le source code, il y a également 

- un script .bash est met en place pour pour faciliter l'exécution et la compilation du code
(ce qui peut être difficile lorsque l'on ne connaît pas l'arborescence du code), 
vous pouvez également utiliser un IDE tel que Eclipse qui détectera automatiquement 
le "Main" et se chargera de l'exécution, ceci fonctionne en prenant en parametre un package (nim ou tictactoe),
compile toute les classes à l'intérieur exécute le Test.class puis le Main.class.
