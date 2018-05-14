package main;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Console {

	static Scanner in  = new Scanner(System.in);
	static Scanner sc  = new Scanner(System.in);
	
	
	

	/**
	 * Choix des parametres de jeux : jeu contre IA ou Joueur contre Joueur
	 * @param void
	 * @return int
	 */
	public static int menu(){
		int choix_menu = 0;
		System.out.println("Bienvenue dans le jeu de Nim. \n");
		System.out.println("1 : Joueur contre Joueur");
		System.out.println("2 : Joueur contre IA (debutant)");
		System.out.println("3 : Joueur contre IA (difficile)");
		do {
			System.out.println("Choississez votre type de jeu.");
			choix_menu = in.nextInt();
		} while(choix_menu > 5 && choix_menu < 0);
			return choix_menu;
	}
	
	
	
	/**
	 * Methode qui cree les joueurs
	 * @param int nbrJoueur
	 * @param HumanPlayer joueur
	 * @return HumanPlayer
	 */
	public static HumanPlayer createPlayer(int nbrJoueur, HumanPlayer joueur){	
		
		System.out.println("Choisissez un nom pour le joueur" + nbrJoueur + ".");
		joueur.setNom(sc.nextLine());
		return joueur;	
	}


	
	
	/**
	 * Permet d'avoir une taille pour le plateau
	 * @return int
	 */
    public static int getSize() {
    	int nbrLignes;
    	System.out.println("Inserer nombre de lignes desirees pour la partie : ");
    	do{
            nbrLignes = in.nextInt();
            if(nbrLignes <= 0){
                System.out.println("Veuillez entrer une valeur superieure a 0.");
            }
        }while(nbrLignes <= 0);
    	return nbrLignes;
    }
    
    
    /**
	 * Demande a quelle ligne le joueur veut supprimer des allumettes, et combien d'allumettes il veut supprimer
	 * @param name
	 * @return Move
	 */
	public static Move getMove(String name) {
		System.out.println("\n" + name + ", a quelle ligne voulez-vous enlever des allumettes ? Et combien d'allumettes ? \n(Ecrire sous la forme \"M N\" avec M les lignes et N le nombre d'allumettes a enlever) ");
			

		String choixMove = sc.nextLine(); 
				
		
		StringTokenizer st = new StringTokenizer(choixMove);
		
		//trycatch permet de verifier que le getMove soit au bon format : M N
		try{
			//On recupere 2 String, subLignes avec le nombre de lignes et subAllus avec le nombre d'allumettes a enlever	
			String subLignes = st.nextToken();
			String subAllus = st.nextToken();
			
			//On transforme les String en int
			int lignes = Integer.parseInt(subLignes);
			int allus = Integer.parseInt(subAllus);
			
			//verifie que la chaine de caractere ne soit pas composé de + de 2 chiffres
			if (st.hasMoreTokens()){
				System.out.println("Erreur, votre choix contient plus de 2 chiffres");
				return getMove(name);
			}
			
			Move move = new Move(lignes, allus);
			return move;
		}
		catch (Exception e){
			System.out.println("Votre choix est invalide");
			return getMove(name);
		}				

	}
	
	
	/**
	 * 
	 * @param board
	 */
	public static void showBoard(int[] board) {
		for(int i=0;i<board.length;i++){
			System.out.print(i+1 + " : ");
			for(int j=0;j<board[i];j++){
				System.out.print("|");
			}
			System.out.println();
		}
	}

  
	/**
	 * Message d'erreur si le mouvement est invalide
	 * @param Move
	 */
	public static void invalidMove(Move move){
  		System.out.println("Supprimer " + move.getNbrAllus() + " allumette(s) a la ligne " + move.getLigne() + " n'est pas faisable.");
  	}
  	
  	
  	/**
  	 * Methode qui affiche le nom du vainqueur
  	 * @param namePerdant
  	 */
  	public static void showWinner(String nameGagnant) {
  		System.out.println(nameGagnant + " a gagne la partie.");
  		}
  	
  	
  	
  	
  	/**
  	 * Demande au joueur si il veut relancer une partie ou quitter le jeu
  	 * @return boolean
  	 */
  	public static boolean newGame() {
  		
  		int replay = 0;
  		
  		do{
  		System.out.println("Voulez-vous rejouer contre votre adversaire ? (Repondre par \"1\" pour oui et \"2\" pour non. \n Si non, le jeu est clos)");
  		replay = in.nextInt();
  		}while(replay > 3 || replay < 0);
  		
  		if(replay == 1)
  			return true;
  		else
  			return false;	
  	}
  	
  	
  	/**
  	 * Determine qui a remporte le plus de victoires
  	 * @param points1
  	 * @param points2
  	 * @param nom1
  	 * @param nom2
  	 */
  	public static void grandGagnant(int points1, int points2, String nom1, String nom2) {
  		if(points1 < points2) {
  			System.out.println(nom2 + " a remporte la victoire contre " + nom1 + " avec " + points2 + " points contre " + points1 + " ! \n Bien joue a vous !");
  		}else if(points1 > points2) {
  			System.out.println(nom1 + " a remporte la victoire contre " + nom2 + " avec " + points1 + " points contre " + points2 + " ! \n Bien joue a vous !");
  		}else if(points1==points2) {
  			System.out.println("Il y a egalite avec " + points1 + " points des deux cotes ! \n A une prochaine fois pour vous demarquer !");
  		}
  	}

}
