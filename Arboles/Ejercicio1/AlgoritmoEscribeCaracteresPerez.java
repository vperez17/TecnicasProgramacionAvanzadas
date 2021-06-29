package Arboles;

public class AlgoritmoEscribeCaracteresPerez {
	/*
	 *En esta funcion calcularemos cual es la altura del arbol, para asi poder imprimir los elementos del ultimo nivel
	 * 
	 * Calcularemos el maximo de cada uno de los subarboles, hasta encontrar el camino mas alejado a la raiz.
	 * 	Utilizaremos la funcion Math.max(x,y) que muestra el maximo de dos parametros.
	 */
	public static int height(ArbolBin<String> arbolBin) {
		int altura = 0;

		if(!arbolBin.esVacio()) {
			//Si el nodo tiene hijo izquierdo
			if (!arbolBin.hijoIzquierdo().esVacio()) {
				altura = Math.max(altura,  height(arbolBin.hijoIzquierdo()));
			}
			//Si el nodo tiene hijo derecho
			if(!arbolBin.hijoDerecho().esVacio()) {
				altura = Math.max(altura,  height(arbolBin.hijoDerecho()));
			}
			altura++;
		}
		return altura;
	}
	
	public static void ultimoNivel(ArbolBin<String> arbolBin, int nivel) {
		//Cuando lleguemos al ultimo nivel, nuestra variable nivel valdra 1, ya que habremos recorrido el resto de niveles
		if(nivel == 1) {
			//Imprimimos de cada nodo su elemento (la letra correspondiente)
			System.out.print(arbolBin.raiz() + " - ");
		}
		/*
		 * Si el hijo izquierdo/derecho no es vacio (existe su hijo), llamamos recursivamente a la funcion restando el valor del nivel en 1
		 */
		if(!arbolBin.hijoIzquierdo().esVacio()) {
			ultimoNivel(arbolBin.hijoIzquierdo(), nivel-1);
		}
		if(!arbolBin.hijoDerecho().esVacio()) {
			ultimoNivel(arbolBin.hijoDerecho(), nivel-1);	
		}
	}
	
	public static void main(String[] args) {
		ArbolBin<String> g = new ArbolBin<String>(new ArbolBin<String>(),"J",new ArbolBin<String>());
		ArbolBin<String> d = new ArbolBin<String>(g,"A",new ArbolBin<String>());
		ArbolBin<String> f = new ArbolBin<String>(new ArbolBin<String>(),"B",new ArbolBin<String>());
		ArbolBin<String> e = new ArbolBin<String>(new ArbolBin<String>(),"C",f);
		ArbolBin<String> b = new ArbolBin<String>(d,"D",new ArbolBin<String>());
		ArbolBin<String> c = new ArbolBin<String>(e,"E",new ArbolBin<String>());
		
		ArbolBin<String> a = new ArbolBin<String>(b,"L",c);

		a.dibujar(1);
		
		
		int ultiLevel = AlgoritmoEscribeCaracteresPerez.height(a);
		
		System.out.println("Nodos del ultimo nivel (nivel: "+ultiLevel+"):");
		AlgoritmoEscribeCaracteresPerez.ultimoNivel(a, ultiLevel);

	}
}
