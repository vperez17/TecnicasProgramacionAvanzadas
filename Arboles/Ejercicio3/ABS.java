package Practica2;


public class ABS <T extends Comparable<T>> {

	//creamos la raiz (el origen del arbol)
	private NABB<T> root;
	//saber si el arbol esta vacio
	public boolean isEmpty() {
		return root == null;
	}
	//saber que elemento es la raiz del arbol
	public NABB<T> getRoot(){
		return root;
	}
	//saber si un nodo es o no la raiz
	public boolean isRoot(NABB<T> nodo) {
		return root == nodo;
	}
	//saber si un nodo es el ultimo de la rama (hoja)
	public boolean isLeaf(NABB<T> nodo) {
		return nodo.getLeft() == null && nodo.getRight() == null;
	}
	//Saber si un nodo tiene mas hijos
	public boolean isInternal(NABB<T> nodo) {
		return !isLeaf(nodo); 
	}


	/**
	 *  Creamos el arbol de forma iterativa, donde utilizaremos un bucle while
	 * 
	 */
	public NABB<T> add(String  elemento) {
		//Declaramos e inicamos a null el nodo que vamos a insertar en el arbol.
		NABB<T> nodo = null;
		//Si nuestro arbol esta vacio, añadimos el elemento a la primera posicion (la raiz)
		if (root == null) {
			//introducimos el dato al nodo y lo convertimos en la raiz del arbol
			nodo = new NABB<>(elemento); 
			root = nodo;
		} else {
			//Creo un nodo auxuliar que apunte a la raiz y una variable para poder salir del bucle cuando inserte el nodo
			NABB<T> aux = root;
			boolean insertado = false;
			//No salgo hasta que este insertado
			while (!insertado) {
				/*
				 * Comparamos los elementos
				 * Si el nodo del origen es mayor que el elemento pasado, nos dirigimos a la izquierda
				 * 
				 * Vamos a comparar las letras del alfabeto como si fuesen numeros (A = 1, B = 2, C = 3.....)
				 * de esta manera podremos saber si la letra es menor (va antes en el abecedario) o es mayor (va despues)
				 * 
				 * si llegamos a un nodo donde su hijo izquierdo o derecho (dependiendo del resultado en la comparacion) es null, 
				 * insertamos el nodo en esa posicion y salimos del bucle actualizando el valor de la variable booleana.
				 * 
				 */
				//
				if (aux.getElement().compareTo(elemento) > 0) {
					//Si tiene nodo izquierdo, actualizo el aux (sigo recorriendo el arbol hasta encontrar su espacio)
					if (aux.getLeft() != null) {
						aux = aux.getLeft();
					} else {
						//Creo el nodo con el elemento correspondiente
						nodo = new NABB<>(elemento);
						//Indico a los nodos las relaciones padres hijos correspondientes
						nodo.setParent(aux);
						aux.setLeft(nodo);
						
						insertado = true;
					}
				} else {
					if (aux.getRight() != null) {
						aux = aux.getRight();
					} else {
						//Creo el nodo con el elemento correspondiente
						nodo = new NABB<>(elemento);
						//Indico a los nodos las relaciones padres hijos correspondientes
						nodo.setParent(aux);
						aux.setRight(nodo);
						
						insertado = true;
					}
				}
			}
		}
		return nodo;
	}

	//MOSTRAR DE FORMA JERARQUICA EL ARBOL
	public void mostrar(NABB<T> nodo) {
		/*
		 * Calculamos la profundidad de cada nodo, para poder dejar un espacio por cada nivel que avancemos,
		 * de esta manera se vera de forma muy sencilla en la consola
		 */
		int profundidad = this.depth(nodo);
		for (int i = 0; i < profundidad; i++) {
			System.out.print("   ");
		}
		System.out.println("- " + nodo.getElement().toString());
		if(nodo.getLeft()!=null) {
			mostrar(nodo.getLeft());
		}
		if(nodo.getRight()!=null) {
			mostrar(nodo.getRight());
		}
	}

	/**
	 * PROFUNDIDAD DE UN NODO
	 * Es el numero de nodos que hay desde un nodo hasta la raiz, por eso contaremos hacia arriba,
	 * buscando siempre el padre del nodo en el que estemos hasta llegar a la raiz (bucle if)
	 */
	public int depth(NABB<T> nodo) {
		int depth = 0;
		if(nodo != getRoot()) {
			depth = 1 + depth(nodo.getParent());
		}
		return depth;
	}

	/**
	 * ALTURA DE UN ARBOL
	 * Numeros de nodos que tiene el camino mas alejado de la raiz + 1.
	 * 
	 * Calcularemos el maximo de cada uno de los subarboles, hasta encontrar el camino mas alejado.
	 * 	utilizaremos la funcion Math.max(x,y) que muestra el maximo de dos parametros.
	 */
	public int height(NABB<T> nodo) {
		int height = 1;
		if(isInternal(nodo)) {
			if (nodo.getLeft() != null) {
				height = Math.max(height,  height(nodo.getLeft()));
			}
			if(nodo.getRight() != null) {
				height = Math.max(height,  height(nodo.getRight()));
			}
			height++;
		}
		return height;
	}

	//MOSTRAR NODOS DE UN NIVEL
	public void verNivel(NABB<T> nodo, int nivel) {
		//Cuando lleguemos al ultimo nivel, nuestra variable nivel valdra 1, ya que habremos recorrido el resto de niveles
		if(nivel == 1) {
			//Imprimimos de cada nodo su elemento (la letra correspondiente)
			System.out.print(nodo.getElement() + " - ");
		}
		/*
		 * Si el hijo izquierdo/derecho no es nulo, llamamos recursivamente a la funcion restando el valor del nivel en 1
		 */
		if(nodo.getLeft()!=null) {
			verNivel(nodo.getLeft(), nivel-1);
		}
		if(nodo.getRight()!=null) {
			verNivel(nodo.getRight(), nivel-1);	
		}
	}

	

	
	
	
}
