**Joueur contre Joueur**
==

Création des joueurs
-
L'Human Player **joueur 1** est créé avant le choix de jeu, car il sera créé dans tous les type de jeu, l'Human Player **joueur 2** est créé après le choix du mode JcJ.  
Les joueurs sont créé en tant que objets, leur nom sera demandé et leurs nombres de points sera initialisé a 0.

Nous créons aussi un **Human Player** nommé **joueur** qui nous permettra de faire la redirection des joueurs 1 et 2 en tant que joueur actif.

Création du plateau de jeu
-
Les joueurs devront rentrer le nombre de ligne présent sur le plateau de jeu.
Pour la création du tableau d'allumettes, nous prennons le nombre de ligne rentré par les joueurs que nous mettons dans une variable (**n**), qui permettra de définir la taille du tableau d'allumette.

Grâce a une boucle **For** allant de 0 jusqu'à **n**. Nous attribuerons a chaque ligne d'allumette une case du tableau, et nous lui donnerons la valeur de 2n+1.

Tour de jeu
-
Nous avons créé une variable booléen nommé **JoueurActif**, qui permet de déterminer si le joueur jouant actuellement est le joueur 1 ou le joueur 2.

Si **JoueurActif** est sur **True** cela signifie que c'est au joueur 1 de jouer, sur **False**, au joueur 2 de jouer. Ainsi à la fin de chaque tour, nous changeons juste la valeur de **JoueurActif** pour déterminer le joueur actuel.

Pour le bon enchaînements des tours de jeu, ceux-ci se déroulent dans un **while** avec pour condition de sortie, la victoire d'un des deux joueurs.

Au début de chaque tour, nous affichons le **Board** montrant le nombre d'allumettes sur chaque ligne, grâce à la fonction ShowBoard.

#### **Suppression des allumettes** #
Pour la suppression des allumettes, nous appelerons en premier la fonction **BurnMatches** qui va créer un **Move**, ensuite nous donnerons à **Move** les valeurs de **getMove**.

##### GetMove #
Pour récupérer les valeurs du **Move** correspondant au numéro de ligne et aux nombres d'allumettes à retirer sous la forme **Move(ligne,allus)**, le **getMove** va demander au joueur de rentrer un **String** qui se présentera sous la forme :  _M N_

**M** correspondant au numéro de lignes  
**N** correspondant aux nombres d'allumettes a retirer  
Séparer par un **espace**

Ensuite nous utiliserons un **StringTokenizer** qui va nous permettre de séparer les valeurs de M N, qui seront transféré en **int** grâce à la méthode **ParseInt()**.  
Nous attribuons ainsi le numéro de la ligne à la variable **int lignes** et le nombre d'allumettes à la variable **int allus**.

Puis nous retourneront **Move** prennant en parammetre **lignes** et **allus**. De la manière suivante : **Move(lignes,allus)**.

##### TestMove #
Nous nous assurerons que le **getMove** est valable.  
Les causes pouvant **invalider un Move** sont :
1. Un choix de ligne incorrect (inférieur à 0 ou supérieur au nombre de lignes du tableau)
2. un choix d'allumettes incorrect (inférieur à 1, supérieur à 3, OU supérieur au nombre d'allumettes présent sur la ligne sélectionnée. Par exemple essayer de retirer 3 allumettes sur une ligne ne possédant que deux allumettes.
3. Un String ne correspondant pas à la formulation demandé, soit des **int** sous la forme : "M N"

Une fois assuré de la validité du **Move**, nous retirons le nombre d'allumettes inscrit, de la ligne demandé.

### **Changement de joueur** #
Une fois le tour du joueur terminer, vient le tour du second joueur, pour cela nous utlisons :  
**JoueurActif = !JoueurActif**

Qui nous permets de passer **JoueurActif** à **False** si il vaut **True** et de **True** à **False** dans l'autre cas.  
Ainsi, si **JoueurActif** vaut **True**, l'Human Player **joueur** vaudra **joueur 1** et vaudra **joueur 2** pour un **JoueurActif** à **False**.

### **Fin de tour** #

Il faut maintenant vérifier si la partie est terminé, pour savoir si nous sortons du **while**.  
Pour savoir si la partie est finie, nous utilisons la fonction **victoire**.  
Cette fonction va parcourir le tableau d'allumette et regarder si il reste des allumettes sur les lignes. Si sur au moins une ligne, il reste au moins une allumette, la partie n'est pas finie.  
Ainsi vient le tour du prochain joueur.