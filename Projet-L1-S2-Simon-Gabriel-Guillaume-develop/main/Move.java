package main;
public class Move {
	private int ligne;
	private int nbrAllus;
	
	/**
	 * Constructeur par defaut de Move
	 */
	public Move(){
		ligne = 0;
		nbrAllus = 0;
	}
	
	/**
	 * Constructeur de Move
	 * @param ligne
	 * @param nbrAllus
	 */
	public Move(int ligne, int nbrAllus){
		this.ligne = ligne;
		this.nbrAllus = nbrAllus;
	}

	/**
	 * Getter de la ligne du move	
	 * @return int
	 */
	public int getLigne() {
		return ligne;
	}

	/**
	 * Setter de la ligne du move
	 * @param ligne
	 */
	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	
	/**
	 * Getter du nombre d'allumettes a enlever
	 * @return int
	 */
	public int getNbrAllus() {
		return nbrAllus;
	}

	/**
	 * Setter du nombre d'allumettes a enleveré
	 * @param nbrAllus
	 */
	public void setNbrAllus(int nbrAllus) {
		this.nbrAllus = nbrAllus;
	}
	
	
	/**
  	 * Test de la validite du mouvement
  	 * @param move
  	 * @param board
  	 * @return boolean
  	 */
  	public static boolean testMove(Move move, int[] board){
		if((move.getLigne() < 0)){
			if((move.getLigne() > board.length)){
				if((move.getNbrAllus() > 3)) {
					if((board[move.getLigne()-1] < move.getNbrAllus())){
						if((move.getNbrAllus() <= 0)) {
							Console.invalidMove(move);
							return false;
						}
					}
				}
			}
			
		}
		return true;

	}


}
