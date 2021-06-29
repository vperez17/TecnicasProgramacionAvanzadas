package Ejercicios;

public class Identidad {

	// Corregir esta función
	/**
	 * En esta funcion vamos a recorrer la matriz comprobando todos los elementos.
	 * Mientras que los elementos que comprobamos coincidan con sus correspondientes posiciones de la matriz identidad,
	 * seguiremos comprobando la matriz. De esta manera, conseguimos solucionar el problema inicial de la funcion dada en el enunciado.
	 * 
	 * 
	 * @param matriz
	 * @return
	 */
	public static boolean esIdentidad_v1 (int[][] matriz) {
		boolean identidad = true;

		for (int fila = 0; fila < matriz.length; fila++) { // No editar esta línea
			for (int col = 0; col < matriz[fila].length; col++) { // No editar esta línea
				/*
				 * Añadimos este if, para que en el caso de que encuentre un valor que no corresponde con los de la matriz identidad, no entre al bucle y devuelva que la matriz no es la matriz identidad.
				 * De esta manera, conseguimos arreglar el fallo inicial
				 */
				if(identidad == true) {
					if (fila==col) {
						if (matriz[fila][col] == 1)
							identidad = true;
						else
							identidad = false;
					}
					else {
						if (matriz[fila][col] == 0)
							identidad = true;
						else
							identidad = false;
					}
				}
			}//for
		}//for
		return identidad;
		/*
		 * Al haber añadido el bucle if(identidad == true), hemos conseguido solucionar el problema.
		 * 
		 * Entrara al bucle mientras que las posiciones que haya recorrido coincidan con las de la matriz identidad, sin embargo, con la primera posicion erronea que se encuentre, ya no volvera a entrar al bucle para hacer la comprobacion.
		 * De estamanera, vamos a recorrer el array entero en cualquier caso. Sin embargo, al bucle if(identidad==true) entraremos mientras la matriz vaya coincidiendo con la matriz identidad.
		 */
	}

	/**
	 * Tenemos dos bucles for para recorrer la matriz.
	 * Cuando la fila y la columna sean iguales [x, x], compromabos si ese numero es uno o no. Si es distinto de uno, devolvemos false y salimos de la funcion.
	 * Si la fila y la columna no son iguales [x, y], comprobamos si ese numero es cero o no. Si es distinto de cero, devolvemos false y salimos de la funcion.
	 * Si conseguimos recorrer el array entero, sin devovler ningun false, sabemos que la matriz es la matriz identidad, por lo que devolvemos true.
	 * 
	 * De esta manera, hemos conseguido una funcion cuyo tiempo de ejecucion es menor, ya que si encuentra una posicion erronea, dejara de recorrer el array, mientras que la funcion esIdentidad_v1 recorre el array entero.
	 * 
	 * @param matriz
	 * @return	true(matriz identidad) 	false(matriz diferente)
	 */
	public static boolean esIdentidad_v2 (int[][] matriz) {

		for (int fila = 0; fila < matriz.length; fila++) {
			for (int col = 0; col < matriz[fila].length; col++) {
				//Cuando la fila sea igual que la columna, significa que estamos en la diagonal de la matriz
				if(fila==col) {
					//Comprobamos que si esa posicion es 1
					if(matriz[fila][col] != 1) {
						// Si entra a este bucle, sabemos que ya la matriz no es la identidad, por lo que salimos de la funcion
						return false;
					}
				}else {
					//Comprobamos si las posiciones que no son de la diagonal son 0 o no
					if(matriz[fila][col] != 0) {
						// Si entra a este bucle, sabemos que ya la matriz no es la identidad, por lo que salimos de la funcion
						return false;
					}
				}					
			}
		}	
		return true;
	}

	/**
	 * Funcion inicial donde pasamos la matriz para comprobar si es la matriz identidad o no
	 * Desde esta funcion, retronamos el valor de una funcion auxiliar a la que le pasamos la matriz, el inicio y su longitud
	 * 
	 * @param matriz
	 * @return
	 */
	public static boolean esIdentidad_DyV (int[][] matriz) {
		//Llamamos a la funcion que es capaz de aplicar la estrategia DyV
		return esIdentidad_DyV2(matriz, 0, matriz.length-1);
	}

	/**
	 * Este metodo es llamado desde 'esIdentidad_DyV'. A esta funcion le pasamos la matriz, el inicio (0) y la longitud de la matriz, 
	 * de esta manera cumplimos las condiciones del enunciado de no añadir parametros a las funciones iniciales, pero si pudiendo
	 * llamar a funciones adicionales creadas por nosotros
	 * 
	 * Creamos una funcion donde dividiremos la matriz en filas, para que la comprobacion sea mas sencilla
	 * 
	 * Cada vez que conseguimos una matriz con una sola fila, llamamos a la funcion comprobar, que se nos inidica si las posiciones de ese array, coinciden con el de la fila de la matriz identidad correspondiente.
	 * 
	 * @param matriz, inicio, fin
	 * @return true(matriz identidad) 	false(matriz diferente)
	 */
	private static boolean esIdentidad_DyV2 (int[][] matriz, int inicio, int fin) {
		if(inicio == fin) {
			if(matriz[inicio][inicio] != 1) {
				return false;
			}else {
				for(int i=0; i<matriz.length; i++) {
						if(matriz[inicio][i] != 0 && i!= inicio) {
							return false;
						}
				}
			}
			return true;
		}else {
			int mitad = (inicio + fin)/2;

			boolean x = esIdentidad_DyV2(matriz, inicio, mitad);
			boolean y = esIdentidad_DyV2(matriz, mitad+1, fin);

			/*
			 * Comprobamos si la parte 'x' y la parte 'y' son correctas(true). En el caso de que sean incorrectas, saldremos de la funcion y no seguiremos comprobando el resto de filas.
			 */
			if(x == false || y == false) {
				return false;
			}else {
				return true;
			}

		}
	}

	/**
	 * Este metodo es llamado desde 'esIdentidad_DyV2'. Es el encargado de comprobar si la fila
	 * en la que estamos cumple las condiciones para ser de la matriz identidad.
	 * 
	 * Para ello, necesitamos pasarle un inicio, que indica la fila de la matriz inicial en 
	 * la que nos encontramos. Gracias a esto, podremos averiguar si en la posicion en la que 
	 * deberia estar el 1 para cumplir la regla de identidad, es correcta o no.
	 * 
	 * @param matriz
	 * @param inicio
	 * @return
	 */
	private static boolean comprobar (int[][] matriz, int inicio) {
		if(matriz[inicio][inicio] == 1) {
			/*
			 * Recorremos el array que hemos conseguido en la funcion esIdentidad_DyV
			 */
			for(int i=0; i<matriz.length; i++) {
				if(i!= inicio) {
					if(matriz[inicio][i] != 0) {
						return false;
					}
				}
			}
		}else {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {

		int[][] m1 = {	{1,0,0,0},
						{0,6,0,0},
						{0,0,3,0},
						{0,0,0,8}};

		int[][] m2 = {	{1,0,0,0},
						{0,1,0,0},
						{0,0,1,0},
						{0,0,0,1}};

		int[][] m3 = {	{1,0,0,0},
						{0,1,0,0},
						{0,0,1,1},
						{0,0,0,1}};
		
		System.out.println("EJERCICIO 1: Comprobar si las siguientes matrices son la matriz identidad");
		
		System.out.println("	\nPRUEBA 1:");
		System.out.println("	 * esIdentidad_v1 (m1): " + esIdentidad_v1(m1));
		System.out.println("	 * esIdentidad_v1 (m2): " + esIdentidad_v1(m2));
		System.out.println("	 * esIdentidad_v1 (m3): " + esIdentidad_v1(m3));

		System.out.println("	\nPRUEBA 2:");
		System.out.println("	 * esIdentidad_v2 (m1): " + esIdentidad_v2(m1));
		System.out.println("	 * esIdentidad_v2 (m2): " + esIdentidad_v2(m2));
		System.out.println("	 * esIdentidad_v2 (m3): " + esIdentidad_v2(m3));

		System.out.println("	\nPRUEBA 3:");
		System.out.println("	 * esIdentidad_DyV (m1): " + esIdentidad_DyV(m1));
		System.out.println("	 * esIdentidad_DyV (m2): " + esIdentidad_DyV(m2));
		System.out.println("	 * esIdentidad_DyV (m3): " + esIdentidad_DyV(m3));

	}//main

}//class
