package MaxMinDyV;

public class MinMaxDyv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int mi_array[] = {3,7,9,1,4,6,3,7};

		int minimo = min(0, mi_array.length-1,mi_array);
		int maximo = max(0, mi_array.length-1,mi_array);

		System.out.println("Minimo: "+minimo);
		System.out.println("Maximo: "+maximo);


	}

	/*nos creamos un método para calcular el minimo pasandole el inicio, el fin y el propio array */

	public static int min(int init, int end, int[] mi_array) {
		if (init == end) {
			return mi_array[init];
		} else {
			int half = (init + end) / 2;
			int x = min(init,half,mi_array);
			int y = min(half+1,end,mi_array);
			/* Tenemos que hacer que cuando tengamos los 2, si x es menor q y, retorne x y sino que retorne y.*/
			if (x < y) {
				return x;
			} else {
				return y;
			}
		}
	}

	/*nos creamos un método para calcular el maximo pasandole el inicio, el fin y el propio array */

	public static int max(int init, int end, int[] mi_array) {
		if (init == end) {
			return mi_array[init];
		} else {
			int half = (init + end) / 2;
			int x = max(init,half,mi_array);
			int y = max(half+1,end,mi_array);
			/* Tenemos que hacer que cuando tengamos los 2, si x es mayor q y, retorne x y sino que retorne y.*/
			if (x > y) {
				return x;
			} else {
				return y;
			}
		}

	}
}
