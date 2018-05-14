package main;

public class IAEasy extends IA{
	private List<Move> listMoves;
	
	/**
	 * Cree la liste des coups possibles dans un tableau regroupant la ligne et le nombre d'allumettes retirables.
	 * @param board
	 * @return int[]
	 */
	public void createListMoves(int[] board){
		Node<Move> previous = new Node<Move>();
		this.listMoves = new List<Move>();
		
		for(int i = 0; i < board.length; i++)
		{
			if(board[i] >= 3){
		    	for(int k = 1; k <= 3; k++)	{
		    		previous = this.listMoves.getTete();
		    		this.listMoves.setTete(new Node<Move>(new Move(i, k), previous));
				}
			}
		    else if(board[i] == 2) {
		    	for(int k = 1; k <= 2; k++)	{
		    		previous = this.listMoves.getTete();
		    		this.listMoves.setTete(new Node<Move>(new Move(i, k), previous));
				}
		    }else if(board[i] == 1) {
		   
		   		previous = this.listMoves.getTete();
		   		this.listMoves.setTete(new Node<Move>(new Move(i, 1), previous));
		    }
		}
	}		
	
	
	
	/**
	 * Methode permettant de recuperer le move de l'IA en le choisissant a l'aide d'un nombre aleatoire definissant la position du move qu'on veut recuperer.
	 * parmi une liste de coups possibles
	 * @param board, IA
	 * @return Move
	 */
	public Move getMoveIAEasy(int[] board){
		this.createListMoves(board);
		int listTaille = this.listMoves.listLength();
		//On cherche le n-ieme maillon de la liste
		int n = (int) (Math.random() * (listTaille - 1) + 1);
		//count sert a s'arreter, quand count == n, on a atteint le bon maillon
		int count = 1;
		Node<Move> curr = this.listMoves.getTete();
		while(count != n) {
			    count++;
			    curr = curr.getNext();
			}
			return curr.getValue();
	}
		
}

	

