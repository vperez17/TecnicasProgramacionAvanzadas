package OrdenarMatriz;

public class MainOM {
	public static void main(String[] args) {
		
		//Tiempo de ejecucion -> -3N^2 + 6MN + 4M + 5
		//Orden de ejecucion -> O(N^2)
		
		//Fila = N  y  Columna = M
		
		int[] matriz= {1,6,2,9,3,4,8,5,7,10};

		for (int x=0; x < matriz.length; x++) {			
			for (int y=0; y < matriz.length-(x+1); y++) {
				if(matriz[y]>matriz[y+1]) {
					int temp = matriz[y+1];
					matriz[y+1] = matriz[y];
					matriz[y]=temp;
				}
			}
		}
		
		for (int x=0; x < matriz.length; x++) {
			System.out.println(matriz[x]);	
		}
		
	}
}
