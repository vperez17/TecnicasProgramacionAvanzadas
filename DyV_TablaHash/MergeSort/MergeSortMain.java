package MergeSort;

public class MergeSortMain {
	
	/* COMENTARIOS */
	
	/* Vamos a necesitar 3 metodos: el main, el MergeSort (dividir el array en dos mitades) y el merge (para mezclar y hallar el max de cada una) */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		int[] array = { 10, 15, 600, 800 ,2222, 20, 100, 120, 200, 40, 50, 400, 500,};
		int tamano = array.length;
		/* Imprimimos el array sin ordenar */
		System.out.println("Array desordenado: ");
		for (int i=0;i<tamano;i++) {
			System.out.print(array[i]+ " ");
		}
		System.out.println(";");
		/* Imprimimos el array ordenado llamando a la funcion mergeSort que a su vez llamara a la funcion sort */
		System.out.println("Array ordenado usando el algoritmo mergesort: ");
		MergeSortMain.mergeSort(array,0,array.length-1);
		for (int i=0;i<tamano;i++) {
			System.out.print(array[i]+ " ");
		}

	}

	public static void mergeSort (int[] array, int init, int end) {
		/* Divide sucesivamente en mitades, hasta que queden mitades de 1 elemento */
		if (init < end) {
			int half = (init + end)/2;
			/* Se llema recursivamente una y otra vez actualziandose los valores de half en cada ejecucion */
			mergeSort(array,init,half);
			mergeSort(array,half+1,end);
			
			merge(array,init,end,half);
		}
	} 

	public static void merge(int[] array, int init, int end, int half) {
		int tamanio1 = half - init +1;
		int tamanio2 = end - half;

		int arrayIzquierda[] = new int [tamanio1];
		int arrayDerecha[] = new int [tamanio2];

		for (int i=0; i < tamanio1; i++) {
			arrayIzquierda[i] = array[init+i];
		}
		for (int j=0; j < tamanio2; j++) {
			arrayDerecha[j] = array[half + j + 1];
		}
		
		int i = 0, j = 0;

		int k = init;

		while (i < tamanio1 && j < tamanio2) {
			if (arrayIzquierda[i] <= arrayDerecha[j]) {
				array[k] = arrayIzquierda[i];
				i++;
			} else {
				array[k] = arrayDerecha[j];
				j++;
			}
			k++;
		}

		while (i < tamanio1) {
			array[k] = arrayIzquierda[i];
			i++;
			k++;
		}
		while (j < tamanio2) {
			array[k] = arrayDerecha[j];
			j++;
			k++;
		}
	}

}
