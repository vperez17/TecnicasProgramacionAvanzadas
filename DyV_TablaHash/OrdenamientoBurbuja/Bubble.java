package OrdenamientoBurbuja;


import java.util.Scanner;


public class Bubble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lmatriz;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca longitud del array: ");
		/* Guardamos en la variable lmatriz el n�mero de elementos que va a tener nuestro array */
		lmatriz = sc.nextInt();

		/* Creamos el array del tama�o lmatriz (lo que pongamos por teclado) */
		int ArrayN[] = new int[lmatriz];

		/* Bucle para rellenar el array con n�meros introducidos por teclado */
		for (int i = 0; i < ArrayN.length; i++) {
			System.out.println("Introduzca n�mero para el elemento " + (i + 1) + ": ");
			ArrayN[i] = sc.nextInt();
		}

		System.out.println("Mostrando array sin ordenar..." + "\n");
		mostrarN(ArrayN);
		System.out.println("Ordenando array..." + "\n");
		ordenaBurbuja(ArrayN);

	}

	static void ordenaBurbuja(int ArrayN[]) {
		/* Bucle desde 0 hasta la longitud del array -1 */
		for (int i = 0; i < ArrayN.length - 1; i++) {
			/* Bucle anidado desde 0 hasta la longitud del array -1 */
			for (int j = 0; j < ArrayN.length - 1; j++) { 
				/* Si el n�mero almacenado en la posici�n j es mayor que el de la posici�n j+1 (el siguiente del array) */ 
				if (ArrayN[j] > ArrayN[j + 1]) {
					/* guardamos el n�mero de la posicion j+1 en una variable (el menor) */
					int menor = ArrayN[j + 1];
					/* Lo intercambiamos de posici�n */
		 			ArrayN[j + 1] = ArrayN[j];
					ArrayN[j] = menor;
					/* y volvemos al inicio para comparar los siguientes hasta que todos se hayan comparado*/
					/* de esta forma vamos dejando los n�meros mayores al final del array en orden*/
				}
			}
		}
		/* Llama al m�todo mostrarN, si ordena damos por hecho que lo quiere mostrar */
		mostrarN(ArrayN);
	}


	static void mostrarN(int ArrayN[]) {
		System.out.println("|-----------------------|");
		/* Recorremos el array y vamos mostrando el dato guardado */
		for (int i = 0; i < ArrayN.length; i++) { 
			System.out.print(" Posici�n: " + (i + 1) + " -----> Elemento guardado:  " + ArrayN[i] + "\n");
		}
		System.out.println("|-----------------------|" + "\n");
	}
}
