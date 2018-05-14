package main;

public class HumanPlayer {
	
	private String nom;
	private int points;
	
	
	/**
	 * Constructeur par defaut de HumanPlayer
	 *
	 * @return void
	 */
	public HumanPlayer() {
		nom="";
		points = 0;
  }
	
	/**
	 * Constructeur de HumanPlayer
	 * @param points
	 * @param nom
	 * @return String
	 */
	public HumanPlayer(int points, String nom){
		this.nom = nom;
		this.points = points;
	}
	
	
	/**
	 * Getter du nom
	 * @return Strings
	 */
	public String getNom(){
		return nom;
	}
	
	
	/**
	 * Getter des points
	 * @return int
	 */
	public int getPoints(){
		return points;
	}
	
	
	/**
	 * Setter du nom
	 * @param nom
	 */
	public void setNom(String nom){
		this.nom = nom;
	}
	
	
	/**
	 * Setter de points
	 * @param points
	 */
	public void setPoints(int points){
		this.points = points;
	}
	
	
	/**
	 * Methode incrementant les points en cas de victoire
	 */
	public void changePoints() {
		this.points++;
	}
	
	

}
