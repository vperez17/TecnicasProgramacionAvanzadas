package BusquedaBinaria;

import java.util.Scanner;

public class MainBB3 {

	public static void main(String[] args) {
		int[] miarray= {1,2,3,4,5,6,7,8,9,10,11,12};

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero para buscar: ");
		int x = sc.nextInt();

		System.out.println("El numero " + x + " esta en la posicion del array: [" + BusBin(miarray,x) +"]");

	}

	//divide y venceras
	public static int BusBin(int array[], int x) {
		if(x > array.length) {
			return -1;
		}else {
			System.out.println(array.length);
			return BusBinDV(array, x, 0, array.length);	
		}
	}

								//miarray, posicion, inicio, final
	public static int BusBinDV(int array[], int x, int i, int j) {

		if(i==j) {
			return array[i];
		}else {
			//contamos los numeros entre j e i para calcular los tercios
			int num = j-i;
			int tercio1 = i+(num/3);
			int tercio2 = i+(2*num/3);

			//X es el primer tercio
			if(x==tercio1) {
				return tercio1;
			//X es el segundo tercio
			}else if(x==tercio2) {
				return tercio2;
			//X es el tercer tercio (final)
			}else if(x==j) {
				return j;
				
			}else if(i < x && x < tercio1) {
				System.out.println("Primer tercio");
				//Inicial = i; Final = i + tercio1 - 1 
				return BusBinDV(array, x, i, i+tercio1-1);
				
			}else if(x > tercio1 && tercio2 > x) {
				System.out.println("Segundo tercio");
				return BusBinDV(array, x, i+tercio1+1, j-tercio1-1);
				
			}else {
				System.out.println("Tercer tercio");
				return BusBinDV(array, x, j-tercio1+1, j);
			}
				
		}
	}
}
