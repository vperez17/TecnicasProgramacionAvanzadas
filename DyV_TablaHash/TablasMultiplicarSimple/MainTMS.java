package TablasMultiplicarSimple;
import java.util.Scanner;

public class MainTMS {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int opcion;
		int numero;
		int limite = 1;
		
		System.out.println("Ingrese una opcion: ");
		System.out.println(" 1/ Imprimir tabla de multiplicar");
		System.out.println(" 2/ Imprimir todas las tablas de multiplicar");
		System.out.println(" 3/ Imprimir tablas de multiplicar de los primeros numeros enteros");
		System.out.println(" 4/ Salir del programa");
		opcion = sc.nextInt();

		
		while(opcion > 0 && opcion < 4) {
			System.out.println("Ingrese un numero :");
			numero = sc.nextInt();
			
			if(opcion == 1) {
				// T(inicio) + Sumatorio (i=o hasta 10) (T (condicion) + T(cuerpo) + T(incremento)) + T(condicion)
				// 1 + S(i=o hasta 10) (1+6+1) + 1
				// 1 + 8(10-0+1) + 1 = 90 -> O(1)
				
				for(int i=1; i<11; i++) {
					System.out.println(i + " x " + numero + " = " + (numero*i));
				}
				System.out.println("Esta es la tabla de multiplicar del "+numero);
				System.out.println(" ");
				
			}else if(opcion == 2) {
				
				while (limite <= numero) {
					for(int i=1; i<11; i++) {
						System.out.println(i + " x " + limite + " = " + (limite*i));
					}
					System.out.println(" ");
					limite++;
				}
				
			}else if (opcion == 3) {
				for(int i=1; i<=numero;i++) {
					System.out.println(i + " x " + i + " = " + (i*i));
				}
				System.out.println(" ");
			}
			
			System.out.println("Ingrese una opcion: ");
			System.out.println(" 1/ Imprimir tabla de multiplicar");
			System.out.println(" 2/ Imprimir todas las tablas de multiplicar");
			System.out.println(" 3/ Imprimir tablas de multiplicar de los primeros numeros enteros");
			System.out.println(" 4/ Salir del programa");
			opcion = sc.nextInt();
			if (opcion == 4) {
				System.out.println("Hasta pronto");
			}
		}
	}

}
