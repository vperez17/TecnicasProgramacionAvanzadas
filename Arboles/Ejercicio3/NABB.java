package Practica2;

public class NABB<T extends Comparable<T>> {

	// Creamos el elemento (nodo)
	private String  element;
	
	// Tenemos tres tipos de nodos
	private NABB<T> parent;
	private NABB<T> left;
	private NABB<T> right;
	
	//creamos el constructor
	public NABB(String  element){
		this.element = element;
	}

	//Constructor
	public NABB(String  element, NABB<T> parent, NABB<T> left,NABB<T> right) {
		super();
		this.element = element;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}


	//creamos getters y setters
	public String  getElement() {
		return element;
	}

	public void setElement(String  element) {
		this.element = element;
	}

	public NABB<T> getParent() {
		return parent;
	}

	public void setParent(NABB<T> parent) {
		this.parent = parent;
	}

	public NABB<T> getLeft() {
		return left;
	}

	public void setLeft(NABB<T> left) {
		this.left = left;
	}

	public NABB<T> getRight() {
		return right;
	}

	public void setRight(NABB<T> right) {
		this.right = right;
	}

	
}
