package SumarElementosMatrices;

public class MainSM {
	
	//Tiempo de ejecucion -> 4MN + 4N + 6
	//Orden de ejecucion -> O(M*N)
	
	//Fila = N  y  Columna = M
	
	public static void main(String[] args) {
		int [][] matriz = {{2,4,4},{6,6,9},{8,10,1}};  	
		int suma = 0;								

		for (int x=0; x < matriz.length; x++) {			
			for (int y=0; y < matriz[x].length; y++) {							
				suma = suma + matriz[x][y];							
			}
		}
		
		System.out.println("La suma del array es: " + suma);	
	}
}