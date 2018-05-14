/**
 * TODO implementer le relancement d'une partie sans recreer les joueurs
 */

/**
 * @author DrCrozz
 * https://framagit.org/Ssolikel/Projet-L1-S2-Simon-Gabriel-Guillaume.git
 * @Version 0.1
 *
 */

package main;
public class Board {
	
	/**
	 * Sert a avoir un tableau vide pour le switch de la fonction game
	 * @return
	 */
	public static int[] createBoard() {
		int[] board = new int[0];
		return board;
	}
	
	
	/**Cree le tableau de jeu d'apres la formule 2*n+1 pour le nombre d'allumettes, chaque case du tableau contenant le nombre d'allumettes de sa ligne
	 * @param n
	 * @return Board
	 * 
	 */
	public static int[] createBoard(int n){
		
		int board[]= new int[n];
			
		for(int k=0;k<n;k++){
			board[k]=2*k+1;
		}
		
		return board;
		
	}
	
	/** 
	 * Donne l'etat du plateau de jeu
	 * @param n
	 * @param m
	 * @param board
	 * @return board
	 */
	public static int[] stateBoard(int n, int m, int board[]){
		
		board[n]=board[n]-m;
		
		return board;
	}
	/**
	 * 
	 * @param joueur1
	 * @param joueur2
	 * @param board
	 */
	public static void jcj(HumanPlayer joueur1, HumanPlayer joueur2, int[] board){
		
		
		//Creation du plateau de jeu
		board = createBoard(Console.getSize());
		
		System.out.println("C'est parti !");
		
		boolean joueurActif = true; 		//true = joueur1 et false = joueur2
		HumanPlayer joueur = joueur1; 		//joueur correspond à qui joue à un instant t
		
		while(!GameState.victoire(board)){
					
			Console.showBoard(board); 	 //On affiche les allumettes
			
			GameState.burnMatches(board, joueur); //On cree le "move" et on l'execute
			
			
			joueurActif = !joueurActif; 	//On change quel joueur est en train de jouer
			if(joueurActif)
				joueur = joueur1;			// les objets joueur 1 et 2 sont rediriges vers l'objet joueur en fonction du joueurActif
			else
				joueur = joueur2;
			System.out.println();
		}
		
		
		Console.showWinner(joueur.getNom());   //On affiche le gagnant
		joueur.changePoints();
		
		
		//Gestion du renouvellement de la partie
		if (Console.newGame())
			jcj(joueur1, joueur2, board);
		else{
			Console.grandGagnant(joueur1.getPoints(), joueur2.getPoints(), joueur1.getNom(), joueur2.getNom());
		}
	}
	
	public static void jcIAEasy(HumanPlayer joueur1, IAEasy IAplayer, int board[]){
		
		
		//Creation du plateau de jeu
		
		board = createBoard(Console.getSize());
		
		System.out.println("C'est parti !");
		
		//true quand joueur 1 joue, false quand c'est l'IA
		boolean activePlayer = true; 
		
		while(!GameState.victoire(board)){
			
			if(activePlayer){
				Console.showBoard(board); 	 //On affiche les allumettes
			
				GameState.burnMatches(board, joueur1);	
			}else{
				GameState.burnMatchesIA(board, IAplayer);
			}
			activePlayer = !activePlayer; 	//On change quel joueur est en train de jouer
			
		}
		if(activePlayer){
			Console.showWinner(joueur1.getNom());   //On affiche le gagnant
			joueur1.changePoints();
		}else{
			Console.showWinner(IAplayer.getNom());   //On affiche le gagnant
			IAplayer.changePoints();
		}
		
		//Creation des joueurs ici pour se resservir d'eux plus tard
		if (Console.newGame())
			jcIAEasy(joueur1, IAplayer, board);
		else{
			Console.grandGagnant(joueur1.getPoints(), IAplayer.getPoints(), joueur1.getNom(), IAplayer.getNom());
		}
	}
	
	
	/** 
	 * Methode qui execute la partie
	 * @param args
	 */
	public static void main(String[] args){
		
		/* --------------------------------- TEST ---------------------------------------
		List<Integer> test = new List<Integer>();
		int bidule1 = 1;
		int bidule2 = 2;
		test.add(bidule1);
		test.add(bidule2);
		
		
		System.out.println(test.getTete().getValue());
		System.out.println(test.getTete().getNext().getValue());
		/* ------------------------------- FIN TEST -------------------------------------*/
		int n = Console.menu();
		
		//Creation du joueur 1
		HumanPlayer joueur1 = new HumanPlayer();     	

			int[] board = createBoard();		

			joueur1 = Console.createPlayer(1, joueur1);
			
			switch(n){
			
			//------------------------------------------ Cas de la partie contre un joueur humain --------------------------------------
			case 1:	
				//Creation du joueur 2
				HumanPlayer joueur2 = new HumanPlayer();
				joueur2 = Console.createPlayer(2, joueur2);
				jcj(joueur1,joueur2,board);				//Gere la partie en joueur contre joueur
				break;
				
				//------------------------------------------ Cas de la partie avec IA facile -----------------------------------------------
			case 2:
				//Creation de l'IA
				IAEasy IAplayer = new IAEasy();
				 
				jcIAEasy(joueur1, IAplayer, board);
				break;
				
			//------------------------------------------ Cas de la partie avec IA difficile --------------------------------------------
			case 3:
				//JCIA2
				break;
				
			}
	}

}
