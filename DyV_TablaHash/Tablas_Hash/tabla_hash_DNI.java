package Tablas_Hash;

public class tabla_hash_DNI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = new int [100];
		int prueba_dni = 05334530;

		insertarLineal(prueba_dni,array,9098);
		insertarLineal(prueba_dni,array,12212);
		System.out.println(array[h(prueba_dni)]);
		System.out.println(array[h(prueba_dni)+1]);
	}

	//creo mi funcion hash
	public static int h (int c) {
		//clave entre el tamaño (del array), nos da un resto
		//pasa a ser la llave
		return (c%100);
	}

	//comprobar si esta ocupada o no
	public static boolean ocupado (int pos, int [] array) {
		if (array[pos] == 0) // si es igual a 0 significa que no esta ocupado
			return false;
		else 
			return true;// en otro caso esta ocupado por lo que no se podria insertar
	}

	/*
	 * funcion insertar lineal : metodo para resolver colisiones
	 * si esta ocupada la posicion donde queria insertarlo lo pongo en la siguiente
	 */
	public static void insertarLineal (int c, int [] array, int colocar) {
		int pos = h(c); // asignamos la llave a la pos donde insertar que será el indice
		if ( !ocupado (pos,array)) // indice libre ??
			array[pos]=colocar; // lo coloco en esa posicion
		else {
			while ( ocupado(pos,array)) { // recorremos hasta ver la siguiente pos libre 
				pos++;
			}
			// cuando ya tenemos la siguiente pos libre
			array[pos] = colocar; // lo colocamos
		}
	}

	/*
	 * funcion insertar cuadratico : metodo 2 para resolver las colisiones
	 * en vez de mirar la siguiente pos (como hace la lineal) busca en intervalos mas grandes
	 * para evitar colisiones locales y mas cercanas
	 */
	public static void insertarCuadratico (int c, int [] array, int colocar) {
		int pos = h(c); // asignamos la llave a la pos donde insertar que será el indice
		if ( !ocupado (pos,array)) // indice libre ??
			array[pos]=colocar; // lo coloco en esa posicion
		else {
			int i = 0;
			int probar = pos;
			while ( ocupado(pos,array)) { // recorremos hasta ver la siguiente pos libre 
				i++;
				probar = pos + i^2; // en vez de mirar en pos +1 miro en posicion *i^2
			}
			// cuando ya tenemos la siguiente pos libre
			array[probar] = colocar; // lo colocamos
		}
	}

}
