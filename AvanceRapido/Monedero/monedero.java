package AvanceRapido;

public class monedero {
	public static void main(String[] args) {

		double monedas[] = {2,1,0.5,0.2,0.1,0.05,0.02,0.01};
		int monedero[] = new int[8];
		double cantidad = 5.89;
		double moneditas = 0;
		int a = 0;

		for(int i=0; i<monedas.length; i++) {
			while(cantidad > moneditas) {
				moneditas = moneditas + monedas[i]; 
				a++;
			}
			moneditas = moneditas - monedas[i]; 
			a = a-1;
			monedero[i] = a;
			a=0;
		}

		for(int i=0; i<monedero.length; i++) {
			System.out.print(monedero[i] + "  ");
		}
	}
}
