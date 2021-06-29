package Practica2;

public class arboles {

	public static void main(String[] args) {
		ABS<String> arbol = new ABS<>();
	
		arbol.add("A");
		arbol.add("G");
		arbol.add("B");
		arbol.add("R");
		arbol.add("Y");
		arbol.add("Q");
		arbol.add("L");
		arbol.add("P");
		arbol.add("U");
		arbol.add("V");
		arbol.add("C");
		arbol.add("D");
		arbol.add("K");
		arbol.add("S");
		
		System.out.println("Arbol creado (forma jerarquica)");
		arbol.mostrar(arbol.getRoot());

		System.out.println("Imprimimos los elementos de los nodos del ultimo nivel del arbol");
		arbol.verNivel(arbol.getRoot(), arbol.height(arbol.getRoot()));
		
	}


}
