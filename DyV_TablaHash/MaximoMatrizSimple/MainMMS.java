package MaximoMatrizSimple;

public class MainMMS {
	
	public static void main(String[] args) {
		
		int[] miarray= {1,6,2,9,3,4,8,5,7,9,1};
		int mayorM = 0;
		
		for(int i=0;i<=miarray.length;i++) {
			if(i>mayorM) {
				mayorM = i;
			}
		}
		
		System.out.println("El numero mayor del array es: " + mayorM);

	}
}
