package DDR_Arboles;

public class main {

	public static void main(String[] args) {


		BinarySearchTree<Integer> arbol = new BinarySearchTree<>();


		arbol.add(8);
		NodoArbolBinario<Integer> eliminado = arbol.add(4);
		arbol.add(arbol.getRoot(), 10);
		arbol.add(arbol.getRoot(), 12);
		arbol.add(1);
		arbol.add(3);
		arbol.add(5);
		arbol.add(7);
		arbol.add(9);
		arbol.add(11);
		arbol.add(5);
		arbol.add(4);
		arbol.add(3);
		arbol.add(9);
		arbol.add(7);
		arbol.add(8);
		arbol.add(13);
//		System.out.println("Utilizar debuguer para verlo " + arbol);

		System.out.println(" ");
		System.out.println("preorder: primero la raiz, despues hijo izquierdo y despues hijo derecho");
		arbol.preorder(arbol.getRoot());
		
		System.out.println(" ");
		System.out.println("inorder: primero hijo izquierdo, despues la raiz y despues hijo derecho");
		arbol.inorder(arbol.getRoot());
		
		System.out.println(" ");
		System.out.println("postorder: primero hijo izquierdo, despues hijo derecho y despues la raiz");
		arbol.postorder(arbol.getRoot());
		
		System.out.println(" ");
		System.out.println("forma jerarquica");
		arbol.mostrar(arbol.getRoot());

		System.out.println(" \n ");
		System.out.println("Altura del arbol: " + arbol.height(arbol.getRoot()));
		System.out.println("Profundidad del nodo: " + arbol.depth(arbol.getRoot()));
		
//		System.out.println(" \n ");
//		System.out.println("Vamos a eliminar el nodo 4: ");
//		arbol.remove(eliminado);
//
//		System.out.println("preorder: primero la raiz, despues hijo izquierdo y despues hijo derecho");
//		arbol.preorder(arbol.getRoot());
//		
		System.out.println("Busqueda de elementos");
		NodoArbolBinario<Integer> nodo = arbol.getNode(arbol.getRoot(), 10);
		if(nodo != null) {
			System.out.println("Elemento encontrado: " + nodo.getElement());
		}else {
			System.out.println("elemento no encontrado");
		}
		System.out.println(" \n ");
		System.out.println("Hay "+arbol.cuentaNodos(arbol.getRoot()) +" nodos en el arbol");
		System.out.println("Hay "+arbol.cuentaHojas(arbol, arbol.getRoot()) +"nodos hoja");
		
		System.out.println("Camimo a seguir: ");arbol.busqueda(arbol.getRoot(), 13);
		
	}

}
