package main;

public class IA {
	
	private String nom;
	private int points;
	
	
	/**
	 * Constructeur de l'IA.
	 */
	public IA(){
		nom = "IA";
		points = 0;
	}
	
	/**
	 * setter de points
	 * @param points
	 */
	public void setPoints(int points){
		this.points = points;
	}
	
	/**
	 * getter de points
	 * @return int
	 */
	public int getPoints(){
		return this.points;
	}
	
	/**
	 * getter de nom
	 * @return String
	 */
	public String getNom(){
		return this.nom;
	}
	
	/**
	 * Methode incrementant les points en cas de victoire.
	 */
	public void changePoints(){
		int a = this.getPoints()+1;
		this.setPoints(a);
	}
	
	
	
	/**
	 * ajoute listeCoups : tous les coups possibles.
	 * @param board
	 * @param listCoups
	 * @return List<int[]>
	 */
	public List<int[]> coupsIaSerious(int[] board, List<int[]> listCoups){
		
		int testFin = 0;
		
		for(int k=0; k<board.length;k++){
			for(int i=1; i<4;i++){
				if(i-board[k]>=0){
					board[k]=i-board[k];
					listCoups.ajouterEnTete(board);
				}
			}
			testFin = testFin+board[k];
			}
		if(testFin==1){return listCoups;}
		else{return coupsIaSerious(board, listCoups);}
	}

	
}
