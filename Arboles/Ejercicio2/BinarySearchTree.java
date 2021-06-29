package DDR_Arboles;


public class BinarySearchTree<T extends Comparable<T>> {

	//creamos la raiz (el origen del arbol)
	private NodoArbolBinario<T> root;

	//saber si el arbol esta vacio
	public boolean isEmpty() {
		return root == null;
	}

	//saber que elemento es la raiz del arbol
	public NodoArbolBinario<T> getRoot(){
		return root;
	}

	//saber si un nodo es o no la raiz
	public boolean isRoot(NodoArbolBinario<T> nodo) {
		return root == nodo;
	}

	//saber si un nodo es el ultimo de la rama (hoja)
	public boolean isLeaf(NodoArbolBinario<T> nodo) {
		return nodo.getLeft() == null && nodo.getRight() == null;
	}

	//Saber si un nodo tiene mas hijos
	public boolean isInternal(NodoArbolBinario<T> nodo) {
		return !isLeaf(nodo); 
	}


	/**AÑADIR ELEMENTOS
	 * 
	 */
	//Forma recursiva
	public void add(NodoArbolBinario<T> origen, T elemento) {

		//si el arbol esta vacio, creamos el primer elemento
		if(root == null) {
			root = new NodoArbolBinario<>(elemento);
		}
		else if(origen == null) {
			System.out.println("El origen es nulo");
		}
		else {   //comparamos donde introducimos los elementos
			//comparamos el elemento que queremos meter, con el elemetno del origen
			if(origen.getElement().compareTo(elemento) > 0) { //si origen - elemento > 0, significa que elemento es menor que origen (meter izquierda)

				//comprobamos si el origen ya tiene nodo izquierdo
				if(origen.getLeft() != null) {
					//llamamos a la misma funcion, pero ahora el nodo origen sera el hijo izquierdo del nodo oirgen principal
					add(origen.getLeft(), elemento);
				}else {
					//creamos el nodo
					NodoArbolBinario<T> nodo = new NodoArbolBinario<>(elemento);
					nodo.setParent(origen); //indicamos quien es el padre(origen)
					origen.setLeft(nodo); 	//indicamos al padre (origen) quien es su hijo izquierdo
				}

			}else {

				//comprobamos si el origen ya tiene nodo derecho
				if(origen.getRight() != null) {
					//llamamos a la misma funcion, pero ahora el nodo origen sera el hijo derecho del nodo origen principal
					add(origen.getRight(), elemento);
				}else {
					//creamos el nodo
					NodoArbolBinario<T> nodo = new NodoArbolBinario<>(elemento);
					nodo.setParent(origen); //indicamos quien es el padre(origen)
					origen.setRight(nodo); 	//indicamos al padre (origen) quien es su hijo derecho
				}
			}

		}


	}
	//Forma iterativa
	public NodoArbolBinario<T> add(T elemento) {

		NodoArbolBinario<T> nodo = null;
		//Si el root es nulo, lo aÃ±ade el primero
		if (root == null) {
			nodo = new NodoArbolBinario<>(elemento);
			root = nodo;
		} else {

			//Creo un nodo auxuliar
			NodoArbolBinario<T> aux = root;
			boolean insertado = false;
			//No salgo hasta que este insertado
			while (!insertado) {

				//Comparamos los elementos
				//Si el nodo del origen es mayor que el elemento pasado, pasa a la izquierda
				if (aux.getElement().compareTo(elemento) > 0) {

					//Si tiene nodo izquierdo, actualizo el aux
					if (aux.getLeft() != null) {
						aux = aux.getLeft();
					} else {
						//Creo el nodo
						nodo = new NodoArbolBinario<>(elemento);
						//Indico que el padre del nodo creado
						nodo.setParent(aux);
						aux.setLeft(nodo);
						//indico que lo he insertado
						insertado = true;
					}

				} else {

					if (aux.getRight() != null) {
						aux = aux.getRight();
					} else {
						//Creo el nodo
						nodo = new NodoArbolBinario<>(elemento);
						//Indico que el padre del nodo creado
						nodo.setParent(aux);
						aux.setRight(nodo);
						//indico que lo he insertado
						insertado = true;
					}

				}

			}

		}

		return nodo;

	}


	/**
	 * RECORRER ARBOL
	 */
	//preorden
	
	public void preorder(NodoArbolBinario<T> nodo) {

		System.out.print(nodo.getElement().toString() + "  ");

		if(nodo.getLeft() != null) {
			preorder(nodo.getLeft());
		}

		if(nodo.getRight() != null) {
			preorder(nodo.getRight());
		}
	}
	
	//inorden
	
	public void inorder(NodoArbolBinario<T> nodo) {

		if(nodo.getLeft() != null) {
			inorder(nodo.getLeft());
		}

		System.out.print(nodo.getElement().toString() + "  ");

		if(nodo.getRight() != null) {
			inorder(nodo.getRight());
		}
	}
	
	//postorden
	
	public void postorder(NodoArbolBinario<T> nodo) {

		if(nodo.getLeft() != null) {
			postorder(nodo.getLeft());
		}

		if(nodo.getRight() != null) {
			postorder(nodo.getRight());
		}

		System.out.print(nodo.getElement().toString() + "  ");
	}
	
	//forma jerarquica
	
	public void mostrar(NodoArbolBinario<T> nodo) {
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
	 * ALTURA Y PROFUNDIDAD
	 */
	//altura = numero de nodos hasta el nodo hoja mas lejano
	public int height(NodoArbolBinario<T> nodo) {
		int height = 0;

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
	//profundidad = numero de nodos hasta la raiz
	public int depth(NodoArbolBinario<T> nodo) {
		int depth = 0;

		if(nodo != getRoot()) {
			depth = 1 + depth(nodo.getParent());
		}

		return depth;
	}


	/**
	 * ELIMINAR NODOS
	 */
	private final int NODE_LEFT = 1;
	private final int NODE_RIGHT = 2;
	private final int NODES = 3;
	public void remove(NodoArbolBinario<T> nodo) {

		if(root == null) {
			System.out.println("No hay nodos que borrar, arbol vacio");
		}else if(isLeaf(nodo)){
			removeLeaf(nodo);
		}else if(nodo.getRight() != null && nodo.getLeft() == null){	//solo tiene hijo derecho
			removeWithChild(nodo, NODE_RIGHT);
		}else if(nodo.getRight() == null && nodo.getLeft() != null){	//solo tiene hijo izquierdo
			removeWithChild(nodo, NODE_LEFT);
		}else {		//tiene dos hijos
			removeWithChild(nodo, NODES);
		}

	}
	/*
	 * El nodo que queremos eliminar es la raiz sin hijos, o el ultimo nodo de una rama
	 * Tendremos que eliminar la relacion padre hijo.
	 */
	private void removeLeaf(NodoArbolBinario<T> nodo) {

		if(isRoot(nodo)){	//el arbol solo tiene un nodo (solo raiz)
			root=null;
		}else {

			NodoArbolBinario<T> parent = nodo.getParent();

			if(parent.getLeft() == nodo){
				parent.setLeft(null);
			}

			if(parent.getRight() == nodo) {
				parent.setRight(null);
			}


			nodo = null;

		}

	}
	private void removeWithChild(NodoArbolBinario<T> nodo, int type_node) {

		NodoArbolBinario<T> siguiente = null;		//va a ser el siguiente nodo al valor menor

		//le decimos al hijo quien es su padre
		switch(type_node) {
		case NODE_LEFT:
			siguiente = nodo.getLeft();
			break;
		case NODE_RIGHT:
			siguiente = minSubTree(nodo.getRight());				
			break;
		case NODES:

			siguiente = minSubTree(nodo.getRight());

			if(siguiente.getParent() != root) {

				nodo.getLeft().setParent(siguiente);
				nodo.getRight().setParent(siguiente);

				if(siguiente.getParent().getLeft() == siguiente) {
					siguiente.getParent().setLeft(null);
				}else if(siguiente.getParent().getRight() == siguiente) {
					siguiente.getParent().setRight(null);
				}

			}

			break;
		}

		siguiente.setParent(nodo.getParent());

		//despues de decirle al hijo quien es su padre, le digo al padre quien es su hijo
		if(!isRoot(nodo)){
			if(nodo.getParent().getLeft() == nodo) {
				nodo.getParent().setLeft(siguiente);
			}else if(nodo.getParent().getRight() == nodo) {
				nodo.getParent().setRight(siguiente);
			}
		} else {
			root = siguiente;
		}


		//si el nodo tiene hijos, se los damos a siguiente
		if(nodo.getRight()!=null && nodo.getRight()!=siguiente) {
			siguiente.setRight(nodo.getRight());
		}
		if(nodo.getLeft()!=null && nodo.getLeft()!=siguiente) {
			siguiente.setLeft(nodo.getLeft());
		}

		nodo = null;

	}
	//coger el nodo mas pequeño del subarbol izquierdo
	private NodoArbolBinario<T> minSubTree(NodoArbolBinario<T> nodo){
		if(nodo!=null && nodo.getLeft()!=null) {
			while(!isLeaf(nodo)){
				nodo = minSubTree(nodo.getLeft());
			}
		}
		return nodo;
	}


	/**
	 * BUSCAR NODOS
	 */
	public NodoArbolBinario<T> getNode(NodoArbolBinario<T> nodo, T elemento){
		NodoArbolBinario<T> aux = null;
		if(nodo.getElement().compareTo(elemento) == 0) {
			aux = nodo;
		}else {
			if(nodo.getLeft() != null) {
				aux = getNode(nodo.getLeft(), elemento);
			}
			if(nodo.getRight()!=null) {
				aux = getNode(nodo.getRight(), elemento);
			}
		}
		return aux;
	}
	public T getElement(NodoArbolBinario<T> nodo, T elemento){
		NodoArbolBinario<T> aux = getNode(nodo,elemento);
		if(aux==null) {
			return null;
		}
		return aux.getElement();
	}


	/**
	 * CONTAR NODOS
	 */
	public static int cuentaNodos(NodoArbolBinario nodo) {

		int contador = 1;

		if(nodo.getLeft()!=null) {
			contador += cuentaNodos(nodo.getLeft());
		}

		if(nodo.getRight()!=null) {
			contador += cuentaNodos(nodo.getRight());
		}

		return contador;
	}
	//contar nodos hoja
	public static int cuentaHojas(BinarySearchTree<Integer> arbol, NodoArbolBinario nodo) {

		int contador = 0;

		if(arbol.isLeaf(nodo)) {
			contador++;
		}


		if(nodo.getLeft()!=null) {
			contador += cuentaHojas(arbol, nodo.getLeft());
		}

		if(nodo.getRight()!=null) {
			contador += cuentaHojas(arbol, nodo.getRight());
		}

		return contador;
	}


	/**
	 * MOSTRAR CAMINO DE BUSQUEDA
	 */
	public void busqueda(NodoArbolBinario<T> nodo, T numero) {

		if(nodo.getElement().compareTo(numero) < 0) {
			System.out.print("-"+nodo.getElement());
			if(isLeaf(nodo)) {
				System.out.println("\n El dato no se encuentra, se acaba el camino");
				return;
			}
			busqueda(nodo.getRight(), numero);
		}else if(nodo.getElement().compareTo(numero) > 0) {
			System.out.print("-"+nodo.getElement());
			if(isLeaf(nodo)) {
				System.out.println("\n El dato no se encuentra, se acaba el camino");
				return;
			}
			busqueda(nodo.getLeft(), numero);
		}else if(nodo.getElement().compareTo(numero) == 0) {
			System.out.print("-"+nodo.getElement());
		}

	}



















}



