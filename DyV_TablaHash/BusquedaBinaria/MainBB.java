package BusquedaBinaria;

import java.util.Scanner;

public class MainBB {

	public static void main(String[] args) {
		int[] miarray= {0,1,2,3,4,5,6,7,8,9,10};

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero para buscar: ");
		int x = sc.nextInt();
		
		System.out.println("El numero " + x + " es el: " + buscarX(miarray,x) + " numero de la lista");
		System.out.println("El numero " + x + " esta en la posicion del array: [" + buscarProfe(miarray,x) +"]");
		System.out.println("El numero " + x + " esta en la posicion del array: [" + BusBin(miarray,x) +"]");

	}

	//divide y venceras
	public static int BusBin(int array[], int x) {
		if(x > array.length-1) {
			return -1;
		}else {
			//System.out.println(array.length);
			return BusBinDV(array, x, 0, array.length);	
		}
	}

								//miarray, posicion, inicio, final
	public static int BusBinDV(int array[], int x, int i, int j) {

		if(i==j) {
			return array[i];
		}else {
			int mitad = (i+j)/2;
			System.out.println("mitad = " + mitad);
			if(x==array[mitad]) {
				return mitad;
			}else {
				//si x mayor que mitad
				if(x > array[mitad]) {
					return BusBinDV(array, x, mitad+1, j);
				}else if (x < array[mitad]) { //si x menor que mitad;¡
					return BusBinDV(array, x, i, mitad-1);
				}else {
					return mitad;
				}
			}
		}
	}

	public static int buscarX (int array[], int x) {
		int posicion = 1;
		for(int i=0; i<array.length; i++) {
			if(x == array[i]) {
				return posicion;
			}
			posicion++;
		}

		return -1;
	}

	public static int buscarProfe(int array[], int x) {
		boolean salir = false;
		int i = 0;

		System.out.println(array.length);
		
		while(x < array.length && salir == false) {
			i++;
			if (x < array[i]) {
				salir = true;
				i=0;
			}else if (x == array[i]) {
				salir = true;
				return i;
			}
		}

		return -1;
	}


}
