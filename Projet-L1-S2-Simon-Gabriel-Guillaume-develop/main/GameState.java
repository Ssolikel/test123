package main;

public class GameState {

	/**
	 * Methode qui supprime les allumettes du plateau
	 * @param board
	 * @param activePlayer
	 */
	public static void burnMatches(int[] board, HumanPlayer activePlayer) {
		
		Move move = new Move();
		
		do{
			move = Console.getMove(activePlayer.getNom()); 
			//Creation de l'objet avec verification de la validite du mouvement
		}while(!Move.testMove(move, board));
			
		board[move.getLigne()-1] -= move.getNbrAllus() ;
		
	}
	
	
	public static void burnMatchesIA(int[] board, IAEasy IA){
		Move move = new Move();
		
		
		
		move = IA.getMoveIAEasy(board); 
		
		System.out.println("Ligne du coup de l'IA : " + (move.getLigne() + 1) + ". NOmbre d'allumettes enlevees : " + move.getNbrAllus());
		board[move.getLigne()] -= move.getNbrAllus();
		
	}
	

	/**
	 * 
	 * @param board
	 * @return win si toutes les lignes de board sont vide, ce qui signifie que la partie est fini
	 */
	public static boolean victoire(int[] board){
		
		for(int i=0;i<board.length;i++){
			if (board[i]!=0)
				return false;
			}
		
		return true;
		}


}
