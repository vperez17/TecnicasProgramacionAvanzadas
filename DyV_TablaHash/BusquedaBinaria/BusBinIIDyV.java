package BusquedaBinaria;

import java.util.Arrays;

public class BusBinIIDyV {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int value = 400;
        int[] array = { 10, 15, 20, 40, 50, 100, 120, 200, 400, 500, 600, 800 ,2222};
        busBin(array, 0, array.length - 1, value);
        System.out.println("Se encontro el numero a buscar "+value+" en el array.");

	}

	public static boolean buscarNumDyV (int[] array, int numBuscar) {
		/* evaluamos el tamano del array */
		int tamano = array.length;
		/* miramos donde esta la mitad */
		int half = tamano/2;

		/* miramos el caso en el que nuestro X este en la mitad justamente de nuestro array*/
		if (numBuscar==array[half]) {
			return true;
		} else if (tamano==1) {
			return false;
		}
		/* Si coincide se queda en el if anterior, si no coincide se mete en los siguientes condicionales*/
		if (numBuscar>array[half]) {
			/* calibramos que si esta en la segunda mitad se llame recursivamente al metodo en la segunda mitad*/
			return buscarNumDyV (Arrays.copyOfRange(array,half+1,tamano),numBuscar);
		} else { /* es decir if (numBuscar<array[half]) */
			/* calibramos que si esta en la primera mitad se llame recursivamente al metodo en la primera mitad*/
			return buscarNumDyV (Arrays.copyOfRange(array,0,tamano),numBuscar);
		}
	}

	public static int buscarNumDyV2 (int[] array, int numBuscar, int init, int end) {
		if (init == end) {
			return array[init];
		} else {
			/* evaluamos el tamano del array */
			int tamano = array.length;
			/* miramos donde esta la mitad */
			int half = (init + end) / 2;
			
			if (numBuscar>array[half]) {
				return buscarNumDyV2(array,numBuscar,half+1,end);
			} else {
				return buscarNumDyV2(array,numBuscar,init,half-1);	
			}
		}
	}
	
	public static int busBin(int[] array, int minLimite, int maxLimite, int numBuscar) {
        if (maxLimite >= 0 && array[minLimite] <= numBuscar && array[maxLimite] >= numBuscar) {
            int mid = calcularMitad(minLimite, maxLimite);
            System.out.println(String.format("Límite inferior: %d; Límite superior: %d; Valor actual en el arreglo: %d; Valor a buscar %d;", minLimite,maxLimite,array[mid],numBuscar));
            if (array[mid] == numBuscar) {
                return mid;
            } else if (array[mid] < numBuscar) {
                return busBin(array, mid + 1, maxLimite, numBuscar);
            }
            return busBin(array, minLimite, mid - 1, numBuscar);
        }
        return -1;
    }
 
    public static int calcularMitad(int minLimite, int maxLimite) {
        return (maxLimite + minLimite) / 2;
    }

}
