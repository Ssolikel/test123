package main;

public class List<T> {
	private Node<T> tete;
	
	
	/**
	 * Constructeur par defaut de List
	 */
	public List(){
		tete = null;
	}
	
	
	/**
	 * setter de tete
	 * @param node
	 */
	public void setTete(Node<T> node){
		this.tete = node;
	}
	
	/**
	 * Gteter de tete
	 * @return Node<T>
	 */
	public Node<T> getTete(){
		return this.tete;
	}
	
	
	/**
	 * Ajoute un maillon en tete de la liste "this"
	 * @param value
	 */
	public void ajouterEnTete(T x) {
		if(this.tete != null) {
			Node<T> aux = tete;
			this.tete = new Node<T>(x, aux);
		}else {
			this.tete = new Node<T>(x);
		}
	}
	
	
	/**
	 * teste si la liste "this" est vide ou non
	 * @return boolean
	 */
	public boolean estListVide(){
		
		if(this.tete == null) return true;
		else return false;
		
	}
	
	
	/**
	 * Methode qui supprime l'element situe a la n-ieme place de la liste
	 * @param n
	 * @return List<T>
	 */
	public List<T> delete(int n){	
		
		if(n == 1){
			this.tete = this.tete.getNext();
		}else{
			
			//quand curseur == n, on a atteint le maillon a supprimer 
			int curseur = 1;
		
			Node<T> curr = new Node<T>();
			Node<T> toDelete = new Node<T>();
			curr = this.tete;
			
			//On deplace curr et on incremente curseur jusqu'a ce qu'on atteigne le maillon voulu
			while(curseur < n-1){
				curr = curr.getNext();
				curseur++;
			}
			
			if(toDelete.getNext() == null) //si on veut supprimer le dernier maillon de la liste, on supprime simplement le lien entre curr et toDelete..
				curr.setNext(null);  
			else{						   //... sinon on supprime le lien de curr a toDelete, puis de toDelete a toDelete.next
				toDelete = curr.getNext();
				curr.setNext(toDelete.getNext());
				toDelete.setNext(null);
			}
		}
		
		return this;
	}
	
	
	/**
	 * Methode pour retourner la taille de la liste en "this"
	 * @return int
	 */
	public int listLength(){
		
		int compteur = 0;
		Node<T> curr = new Node<T>();
		curr = this.tete;
		
		while(curr != null){
			curr = curr.getNext();
			compteur++;
		}
		
		return compteur;
	}


	public int getSize() {
		if(this.estListVide()) return 0;
		
		int i = 10;
		Node<T> aux = this.tete;
		while(aux.getNext() != null) {
			aux = aux.getNext();
			i++;
		}
		return i;
	}
	
}
