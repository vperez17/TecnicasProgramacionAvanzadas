package MinMaxDyVMatriz;

public class MainDVM {

	public static void main(String[] args) {

		int [][] matriz = {{-2,4,17,5},{6,8,9,78},{3,10,1,-6}}; 
		
		int fila = 0; int columna = 0;
		for(int j=0; j<matriz.length; j++) {
			for(int i=0; i<matriz[j].length; i++) {
				fila++;
			}
			columna++;
		}
		
		int [] array = new int [fila*columna];
		int indice = 0;
		
		for(int j=0; j<matriz.length; j++) {
			for(int i=0; i<matriz[j].length; i++) {
				array [indice]  = matriz[j][i];
				System.out.println(array[indice]);
				indice++;
			}
		}
		

		int minimo = min(0, array.length-1,array);
		int maximo = max(0, array.length-1,array);

		System.out.println("Minimo: "+minimo);
		System.out.println("Maximo: "+maximo);
	}
	
	public static int min(int init, int end, int[] matriz) {
		if (init == end) {
			return matriz[init];
		} else {
			int half = (init + end) / 2;
			int x = min(init,half,matriz);
			int y = min(half+1,end,matriz);
			/* Tenemos que hacer que cuando tengamos los 2, si x es menor q y, retorne x y sino que retorne y.*/
			if (x < y) {
				return x;
			} else {
				return y;
			}
		}
	}
	
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
