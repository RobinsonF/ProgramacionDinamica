package co.edu.unbosque.model;


public class AlgortimoCoeficientesBinomiales {

	public static void main(String[] args) {
		
		System.out.println(coefBin(4,2));
	}
	
	public static int coefBin(int num1, int num2) {
	    int i,j;
	    int[][] tabla = new int[num1+1][num1+1];
	 
	    if(num2 == 0 || num2 == num1) {
	       return 1;
	    } else {
	       for (i=0; i<=num1; i++) {
	         tabla[i][0] = 1;
	       }
	 
	       for (i=1; i<=num1; i++) {
	         tabla[i][1] = i;
	       }
	 
	       for (i=2; i<=num2; i++) {
	         tabla[i][i] = 1;
	       }
	 
	       for (i=3; i<=num1;i++) {
	         for (j=2; j<num1; j++) {
	           if(j<=num2) {
	             tabla[i][j] = tabla[i-1][j-1] + tabla[i-1][j];
	           }
	         }
	       }
	   }
	 
	   return tabla[num1][num2];
	 
	 }

}
