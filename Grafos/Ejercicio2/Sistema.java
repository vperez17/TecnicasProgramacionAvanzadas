package Grafos;

public class Sistema {

	public static void main(String args[]) {
		Grafo<String, String, Integer> grafoCiudades = new Grafo<String, String, Integer>();
		grafoCiudades.insertarVertice("BAR", "Barcelona");
		grafoCiudades.insertarVertice("MAD", "Madrid");
		grafoCiudades.insertarVertice("COR", "La Coruña");
		grafoCiudades.insertarVertice("SEV", "Sevilla");
		grafoCiudades.insertarVertice("VAL", "Valencia");
		grafoCiudades.insertarVertice("BIL", "Bilbao");
		grafoCiudades.insertarVertice("CUE", "Cuenca");
		grafoCiudades.insertarVertice("JAE", "Jaen");

		grafoCiudades.insertarArista("COR", "BIL", 644);
		grafoCiudades.insertarArista("COR", "MAD", 609);

		grafoCiudades.insertarArista("BIL", "BAR", 620);
		grafoCiudades.insertarArista("BIL", "MAD", 395);

		grafoCiudades.insertarArista("BAR", "BIL", 620);
		grafoCiudades.insertarArista("BAR", "VAL", 649);

		grafoCiudades.insertarArista("MAD", "COR", 609);
		grafoCiudades.insertarArista("MAD", "VAL", 352);
		grafoCiudades.insertarArista("MAD", "SEV", 538);

		grafoCiudades.insertarArista("VAL", "MAD", 352);
		grafoCiudades.insertarArista("VAL", "SEV", 697);

		grafoCiudades.insertarArista("SEV", "MAD", 538);
		
		grafoCiudades.insertarArista("CUE", "JAE", 356);

		System.out.println(grafoCiudades);
		
		System.out.println("NumVertices= " + grafoCiudades.numVertices());
		System.out.println("ListaSucesores(BAR)\n"
				+ grafoCiudades.listaSucesores("BAR"));
		System.out.println("ListaPredecesores(MAD)\n"
				+ grafoCiudades.listaPredecesores("MAD"));

		System.out.println("\n*** FIN ***");
		
	}//main
}
