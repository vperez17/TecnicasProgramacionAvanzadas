package Quicksort;

public class MainQS {

	public static void main(String[] args) {
		int[] array = {4,8,3,9,7,6,5,1,2};
		
		//pasamos el array, la posicion inicial (0) y la final (array-1)
		quicksort(array,0,array.length-1);
		
		int tamano = array.length;
		for (int i=0;i<tamano;i++) {
			System.out.print(array[i]+ " ");
		}

	}
	
	public static void quicksort(int []array, int inicio, int fin) {
		if(inicio<fin) {
			int x = pivotar(array, inicio, fin);
			quicksort(array, inicio, x-1);
			quicksort(array, x+1, fin);
		}
	}
	
	public static int pivotar(int []array, int inicio, int fin) {
		int i=inicio;
		int p = array[i];

		if(inicio < fin) {
			for(int j = inicio+1; j<=fin; j++) {
				if(array[j] < p) {
					i++;
					if (i!=j) {
						//intercambiar i con j
						int buffer = array[i];
						array[i] = array[j];
						array[j] = buffer;
					}
				}
			}
			int buffer2 = array[inicio];
			array[inicio] = array[i];
			array[i] = buffer2;
			
		}
		// i es la x de arriba
		return i;
	}

}
