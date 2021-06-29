package TablasMultiplicarComplejo;
import java.util.Scanner;

public class MainTMC {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);

		int opcion;
		int numero;
		int contador = 1;
		int whileFor;
		int limite = 1;

		do {
			System.out.println("Ingrese una opcion: ");
			System.out.println(" 1/ Imprimir tabla de multiplicar");
			System.out.println(" 2/ Imprimir todas las tablas de multiplicar");
			System.out.println(" 3/ Imprimir tablas de multiplicar de los primeros numeros enteros");
			System.out.println(" 4/ Salir del programa");
			opcion = sc.nextInt();
			

			switch(opcion) {
			case 1:
				System.out.println("Ingrese un numero :");
				numero = sc.nextInt();
				
				System.out.println("Utilizar bucle while (1) - Utilizar bucle for (2)");
				whileFor = sc.nextInt();
				
				if(whileFor == 1) {
					while(contador != 11) {
						System.out.println(contador + " x " + numero + " = " + (numero*contador));
						contador++;
					}
					System.out.println("Esta es la tabla de multiplicar del "+numero);
					
				}else if(whileFor == 2) {
					for(int i=1; i<11; i++) {
						System.out.println(i + " x " + numero + " = " + (numero*i));
					}
					System.out.println("Esta es la tabla de multiplicar del "+numero);
					
				}else {
					System.out.println("Opcion incorrecta");
				}

				break;

			case 2:
				System.out.println("Ingrese un numero :");
				numero = sc.nextInt();
				
				while (limite <= numero) {
					for(int i=1; i<11; i++) {
						System.out.println(i + " x " + limite + " = " + (limite*i));
					}
					System.out.println(" ");
					limite++;
				}
				
				break;

			case 3:
				System.out.println("Ingrese un numero :");
				numero = sc.nextInt();
				
				while(limite <= numero) {
					System.out.println(limite + " x " + limite + " = " + (limite*limite));
					limite++;
				}

				break;
				
			case 4:
				System.out.println("Hasta pronto");
				break;

			}
			
		}while (opcion != 0 && opcion < 4);

	
	}

}
