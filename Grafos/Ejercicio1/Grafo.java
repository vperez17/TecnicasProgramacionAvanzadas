package Grafos;

public class Grafo<Clave, InfoVertice, Coste> {

	protected class NodoVertice {
		Clave clave;
		InfoVertice vertice;
		int gradoEntrada;
		int gradoSalida;

		public NodoVertice(Clave c, InfoVertice v) {
			clave = c;
			vertice = v;
			gradoEntrada = 0;
			gradoSalida = 0;
		}

	}

	protected class NodoArista {
		NodoVertice destino;
		Coste coste;

		public NodoArista(NodoVertice d) {
			destino = d;
			coste = null;
		}

		public NodoArista(NodoVertice d, Coste c) {
			destino = d;
			coste = c;
		}
	}

	Lista<NodoVertice> vertices;

	Lista<Lista<NodoArista>> aristas;

	public Grafo() {
		vertices = new Lista<NodoVertice>();
		aristas = new Lista<Lista<NodoArista>>();
	}
	public boolean esVacio() {
		return vertices.longitud() == 0;
	}
	public void insertarVertice(Clave c, InfoVertice v) {
		vertices.insertar(1, new NodoVertice(c, v));
		aristas.insertar(1, new Lista<NodoArista>());
	}
	/* no estaba en el TAD*/
	public void modificarVertice(Clave c, InfoVertice v) {
		int i = 1;
		while (i <= vertices.longitud()
				&& !vertices.consultar(i).clave.equals(c))
			i++;
		if (i <= vertices.longitud())
			vertices.consultar(i).vertice = v;
	}
	public void eliminarVertice(Clave c) {
		int i = 1;

		// Busca el vertice que se le indique
		while (i <= vertices.longitud()
				&& !vertices.consultar(i).clave.equals(c))
			i++;

		// Si el vertice a eliminar existe, se elimina, junto con todas las
		// aristas relacionadas.
		if (i <= vertices.longitud()) {
			vertices.borrar(i);
			// Borra las aristas de salida
			aristas.borrar(i);

			// Borra las aristas de entrada
			for (int j = 1; j <= aristas.longitud(); j++) {
				int k = 1;
				boolean aristaEliminada = false;
				while (!aristaEliminada && k <= aristas.consultar(j).longitud()) {
					if (aristas.consultar(j).consultar(k).destino.clave.equals(c)) {
						aristas.consultar(j).borrar(k);
						aristaEliminada = true;
					} else
						k++;
				}
			}
		}
	}
	public boolean existeVertice(Clave c) {
		int i = 1;
		while (i <= vertices.longitud()
				&& !vertices.consultar(i).clave.equals(c))
			i++;
		return i <= vertices.longitud();
	}
	public void insertarArista(Clave o, Clave d, Coste c) {
		int i = 1;
		// Busca el vertice origen
		while (i <= vertices.longitud()
				&& !vertices.consultar(i).clave.equals(o))
			i++;

		int j = 1;
		// Busca el vertice destino
		while (j <= vertices.longitud()
				&& !vertices.consultar(j).clave.equals(d))
			j++;

		// Si existe, introduce la arista
		if (i <= vertices.longitud() && j <= vertices.longitud()) {
			aristas.consultar(i).insertar(1,new NodoArista(vertices.consultar(j), c));
			// Actualiza el grado de salida del vertice origen
			vertices.consultar(i).gradoSalida++;

			// Actualiza el grado de entrada del vertice destino
			vertices.consultar(j).gradoEntrada++;
		}

	}
	public void modificarArista(Clave o, Clave d, Coste c) {
		int i = 1;

		// Busca el vertice origen
		while (i <= vertices.longitud()
				&& !vertices.consultar(i).clave.equals(o))
			i++;

		// Si existe, busca el vertice destino y modifica el peso de la arista
		if (i <= vertices.longitud()) {
			int j = 1;
			boolean aristaModificada = false;
			while (!aristaModificada && j <= aristas.consultar(i).longitud()) {
				if (aristas.consultar(i).consultar(j).destino.clave.equals(d)) {
					aristas.consultar(i).consultar(j).coste = c;
					aristaModificada = true;
				}
				j++;
			}
		}
	}
	public void eliminarArista(Clave o, Clave d) {
		int i = 1;

		// Busca el vertice origen
		while (i <= vertices.longitud()
				&& !vertices.consultar(i).clave.equals(o))
			i++;

		// Si existe, busca el vertice destino y elimina la arista
		if (i <= vertices.longitud()) {
			int j = 1;
			boolean aristaEliminada = false;
			while (!aristaEliminada && j <= aristas.consultar(i).longitud()) {
				if (aristas.consultar(i).consultar(j).destino.clave.equals(d)) {
					// Actualiza el grado de salida del vertice origen
					vertices.consultar(i).gradoSalida--;

					// Actualiza el grado de entrada del vertice destino
					aristas.consultar(i).consultar(j).destino.gradoSalida--;

					// Borra el vertice 
					aristas.consultar(i).borrar(j);
				} else
					j++;
			}
		}
	}

	public Coste costeArista(Clave o, Clave d) {
		int i = 1;
		Coste coste = null;

		// Busca el vertice origen
		while (i <= vertices.longitud()
				&& !vertices.consultar(i).clave.equals(o))
			i++;

		// Si existe, busca el vertice destino y devuelve el peso de la arista
		if (i <= vertices.longitud()) {
			int j = 1;
			boolean aristaEncontrada = false;
			while (!aristaEncontrada && j <= aristas.consultar(i).longitud()) {
				if (aristas.consultar(i).consultar(j).destino.clave.equals(d)) {
					coste = aristas.consultar(i).consultar(j).coste;
					aristaEncontrada = true;
				}
				j++;
			}
		}

		return coste;
	}

	public int gradoEntrada(Clave v) {
		int i = 1;

		// Busca el vertice
		while (i <= vertices.longitud()
				&& !vertices.consultar(i).clave.equals(v))
			i++;

		// Si lo encuentra, devuelve su grado de entrada. Si no, devuelve cero
		if (i <= vertices.longitud())
			return vertices.consultar(i).gradoEntrada;
		else
			return 0;
	}
	public int gradoSalida(Clave v) {
		int i = 1;

		// Busca el vertice
		while (i <= vertices.longitud()
				&& !vertices.consultar(i).clave.equals(v))
			i++;

		// Si lo encuentra, devuelve su grado de salida. Si no, devuelve cero
		if (i <= vertices.longitud())
			return vertices.consultar(i).gradoSalida;
		else
			return 0;
	}

	public Lista<Clave> listaSucesores(Clave v) {
		int i = 1;
		Lista<Clave> sucesores = new Lista<Clave>();

		// Busca el vertice
		while (i <= vertices.longitud()
				&& !vertices.consultar(i).clave.equals(v))
			i++;

		// Si lo encuentra, introduce sus sucesores a la lista
		if (i <= vertices.longitud())
			for (int j = 1; j <= aristas.consultar(i).longitud(); j++)
				sucesores.insertar(j,aristas.consultar(i).consultar(j).destino.clave);

		return sucesores;
	}
	public Lista<Clave> listaPredecesores(Clave v) {
		Lista<Clave> predecesores = new Lista<Clave>();

		// Busca la aparicion del vertice como posible destino de otros vertices
		for (int i = 1; i <= vertices.longitud(); i++) {
			int j = 1;
			boolean verticeEncontrado = false;
			// Si encuentra el vertice v como destino de un vertice o, no
			// aparece mas veces como destino de o
			while (!verticeEncontrado && j <= aristas.consultar(i).longitud()) {
				if (v.equals(aristas.consultar(i).consultar(j).destino.clave)) {
					predecesores.insertar(1, vertices.consultar(i).clave);
					verticeEncontrado = true;
				} else
					j++;
			}
		}

		return predecesores;
	}

	public int numVertices() {
		return vertices.longitud();
	}

	public Lista<Clave> listaVertices() {
		Lista<Clave> listaVertices = new Lista<Clave>();

		for (int i = 1; i <= vertices.longitud(); i++)
			listaVertices.insertar(1, vertices.consultar(i).clave);

		return listaVertices;
	}

	public String toString() {
		String texto = "";
		for (int i = 1; i <= vertices.longitud(); i++) {
			texto += vertices.consultar(i).clave + " --> ";
			for (int j = 1; j <= aristas.consultar(i).longitud(); j++)
				texto += aristas.consultar(i).consultar(j).destino.clave + "("
						+ aristas.consultar(i).consultar(j).coste + ") ";
			texto += "\n";
		}

		return texto;
	}

	
	
	
	//OBTENEMOS EL COSTE EN NUMERO ENTERO DE LA ARSITA
	public int costeArista2(Clave o, Clave d) {
		int i = 1;
		int coste = 0;

		// Busca el vertice origen
		while (i <= vertices.longitud()
				&& !vertices.consultar(i).clave.equals(o))
			i++;

		// Si existe, busca el vertice destino y devuelve el peso de la arista
		if (i <= vertices.longitud()) {
			int j = 1;
			boolean aristaEncontrada = false;
			while (!aristaEncontrada && j <= aristas.consultar(i).longitud()) {
				if (aristas.consultar(i).consultar(j).destino.clave.equals(d)) {
					coste = (int) aristas.consultar(i).consultar(j).coste;
					aristaEncontrada = true;
				}
				j++;
			}
		}

		return coste;
	}
	//ALGORITMO KRUSKAL
	public Lista <Par<Clave>> AlgoritmoKruskalAR (Grafo <String, String, Integer> grafo){

		Lista<Clave> visitados = new Lista<Clave>();
		Lista <Par<Clave>> sol = new Lista <Par<Clave>>();
		
		int[][] arista = new int[vertices.longitud()][vertices.longitud()];

		//crear matriz de adyacencia
		for(int i = 1; i <= vertices.longitud(); i++) {
			for(int j = 1; j <= vertices.longitud(); j++) {
				arista[i-1][j-1] = costeArista2(vertices.consultar(i).clave,vertices.consultar(j).clave);
			}
		}

		int menor = 10000;
		int costeTotal = 0;
		int verticesVistos = 1;
		//mientras no se recorran todos los vertices
		while(vertices.longitud() > verticesVistos) {
			//buscar arista mas pequeña
			for(int i = 1; i <= vertices.longitud(); i++) {
				for(int j = 1; j <= vertices.longitud(); j++) {
					if(arista[i-1][j-1] < menor && arista[i-1][j-1] != 0) {
						if(visitados.longitud() != 0) {
							menor = arista[i-1][j-1];
						}else {
							if(comprobarVisitados(visitados, vertices.consultar(i).clave, vertices.consultar(j).clave)) {
								menor = arista[i-1][j-1];
							}
						}
					}
				}
			}
			
			//buscamos vertices correspondientes
			for (int i = 1; i <= vertices.longitud(); i++) {
				for (int j = 1; j <= vertices.longitud(); j++) {
					if(arista[i-1][j-1] == menor) {
						//System.out.println(vertices.consultar(i).clave + " - " + vertices.consultar(j).clave);
						arista[i-1][j-1] = 0;
						visitados.insertar(1, vertices.consultar(i).clave);	
						visitados.insertar(1, vertices.consultar(j).clave);	
						sol.insertar(1, new Par(vertices.consultar(i).clave,vertices.consultar(j).clave));
						menor = 100000;
						verticesVistos++;
						costeTotal = costeTotal + costeArista2(vertices.consultar(i).clave,vertices.consultar(j).clave);
					}
				}
			}	
		}
		
		for (int i = 1; i <= sol.longitud(); i++) {
				System.out.println(sol.consultar(i).getOrigen()+ " --> " + sol.consultar(i).getDestino());
		}
		System.out.println("coste total = "+costeTotal);
		return sol;

	}
	//SABER SI HAY CICLO O NO
	private boolean comprobarVisitados(Lista<Clave> visitados, Clave clave, Clave clave2) {

		int aparece = 0;
		Lista<Clave> a = listaVerticesUnidos(clave);
		Lista<Clave> b = listaVerticesUnidos(clave2);
		
		for (int i = 1; i <= a.longitud(); i++) {
			if(a.consultar(i) == clave) {
				aparece++;
			}
		}
		for (int i = 1; i <= b.longitud(); i++) {
			if(b.consultar(i) == clave) {
				aparece++;
			}
		}

		if(aparece >= 2) {
			return false;
		}else {
			return true;
		}
		
	}
	//VERTICES UNIDOS ENTRE SI
	public Lista<Clave> listaVerticesUnidos(Clave v) {
		int i = 1;
		Lista<Clave> sucesores = new Lista<Clave>();

		// Busca el vertice
		while (i <= vertices.longitud()
				&& !vertices.consultar(i).clave.equals(v))
			i++;

		// Si lo encuentra, introduce sus sucesores a la lista
		if (i <= vertices.longitud())
			for (int j = 1; j <= aristas.consultar(i).longitud(); j++)
				sucesores.insertar(j,
						aristas.consultar(i).consultar(j).destino.clave);

		for (int j = 1; j <= vertices.longitud(); j++) {
			int k = 1;
			boolean verticeEncontrado = false;
			// Si encuentra el vertice v como destino de un vertice o, no
			// aparece mas veces como destino de o
			while (!verticeEncontrado && k <= aristas.consultar(j).longitud()) {
				if (v.equals(aristas.consultar(j).consultar(k).destino.clave)) {
					sucesores.insertar(1, vertices.consultar(j).clave);
					verticeEncontrado = true;
				} else
					k++;
			}
		}

		return sucesores;
	}


}//class


//Imprimir matriz de adyacencia
//for(int i = 1; i <= vertices.longitud(); i++) {
//	for(int j = 1; j <= vertices.longitud(); j++) {
//		System.out.print(arista[i-1][j-1] + " -");
//	}
//	System.out.println(" ");
//}











