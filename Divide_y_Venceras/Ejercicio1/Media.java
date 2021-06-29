package Ejercicios;

public class Media {


	public static void main(String[] args) {

//				float[][] m1 = {{1,2,3,4},
//								{4,5,6,7},
//								{7,8,9,10},
//								{10,11,12,13}};
		int [] m1 = {1,2,3,4,5,6,7,8};

		if(comprobarPotencia(m1.length)) {
			System.out.println("Usando Divide y Venceras : ");
			System.out.println("  " + media(m1, 0, m1.length-1));
			System.out.println(" ");
			System.out.println("Usando forma iterativa : ");
			System.out.println("  " + media2(m1));
		}else {
			System.out.println("La dimension del array no es potencia de dos");
		}


		System.out.println(comprobarPotencia(m1.length));
	}
	
	/**
	 * Funcion donde comprobamos si el numero es potencia de dos o no
	 * Vamos a dividir entre la mitad el tamaño hasta que lleguemos a 1, comprobando que todos los numeros sean pares
	 * 
	 * 		Esto se deve a que cualquier numero que sea potencia de dos, siempre que se divide entre dos va a dar un numero para hasta que llegue a 1
	 * 			16 -> 8 - 4 - 2 - 1
	 * 		Sin embargo, cualquier otro numero, al dividirlo entre dos varias veces, el resultado sera un numero impar
	 * 			20 -> 10 - 5
	 * 		Comprobando esto, sabremos si el tamaño de nuestro array es potencia de dos o no
	 * 
	 * @param longitud
	 * @return
	 */
	public static boolean comprobarPotencia(int longitud) {
		while(longitud > 1) {
			if(longitud%2!=0) {
				return false;
			}
			longitud = longitud/2;
		}
		return true;
	}
	/**
	 * Funcion a la cual le pasamos el array, su inicio y su fin.
	 * Dividiremos el array tantas veces hasta que obtener un solo 
	 * elemento, este se lo sumaremos 
	 * a su correspondiente e iremos calculando la media de estos. 
	 * De esta manera obtendremos la media
	 * de cada la parte izquierda (x) y la parte derecha (y) y 
	 * las sumaremos, consiguiendo la media del array
	 * 
	 * @param array,inicio,fin
	 * @return
	 */
	public static float media(int []array, int inicio, int fin) {
		if(inicio == fin) {
			return array[inicio];
		}else {
			int mitad = (inicio + fin)/2;
			float x = media(array, inicio, mitad);
			float y = media(array, mitad+1, fin);
			return (x+y)/2;
		}
	}

	/**
	 * En esta funcion tenemos dos variables inicializadas a cero, 
	 * que nos indicaran la posicion en la que nos encontramos
	 * y donde almacenaremos la suma de los elementos recorridos
	 * 
	 * Recorremos la lista con un bucle while. Una vez recorrida
	 * y obtenida la suma de todos los elementos, devolvemos esa
	 * suma dividida entre la longitud del array, es decir,
	 * devolvemos la media del array
	 * 
	 * @param m1
	 * @return
	 */
	public static float media2(int []m1) {
		float suma = 0;
		int posicion = 0;
		while(posicion < m1.length) {
			suma = suma + m1[posicion];
			posicion++;
		}
		return suma/m1.length;
	}

}
