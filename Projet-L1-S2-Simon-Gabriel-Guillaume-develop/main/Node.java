package main;

public class Node<T> {
	private T value;
	private Node<T> next;
	
	
	/**
	 * getter de value
	 * @return T
	 */
	public T getValue(){
		return this.value;
	}
	
	
	/**
	 * setter de value
	 * @param value
	 */
	public void setValue(T value){
		this.value = value;
	}
	
	
	/**
	 * setter de next
	 * @param next
	 */
	public void setNext(Node<T> next){
		this.next = next;
	}
	
	
	/**
	 * getter de next
	 * @return
	 */
	public Node<T> getNext(){
		return this.next;
	}
	
	/**
	 * Constructeur vide de Node
	 */
	public Node(){
		value = null;
		next = null;
	}
	
	
	/**
	 * Constructeur de Node avec une valeur T
	 * @param value
	 */
	public Node(T value) {
		this.value = value;
		next = null;
	}
	
	
	/**
	 * Constructeur de Node avec une valeur T et un Maillon node en next
	 * @param value
	 * @param node
	 */
	public Node(T value, Node<T> next){
		this.value = value;
		this.next = next;
	}
}
