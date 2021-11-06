package co.edu.unbosque.model;


public class AlgoritmoMultiplicacionDeMatrices {

	/**
	 * Resuelve el valor �ptimo
	 * 
	 * @param p: matriz de informaci�n de dimensi�n de matriz
	 * @param m: almacena la matriz de valores �ptimos, tri�ngulo superior
	 * @param s: la matriz que almacena el sub�ndice de la posici�n dividida
	 * @return devuelve el valor �ptimo
	 **/
	public static int matrixChain(int[] p, int[][] m, int[][] s) {
		int n = p.length - 1;
		for (int i = 1; i <= n; i++)
			// en s� mismo es 0
			m[i][i] = 0; // Inicializa una matriz bidimensional
		for (int r = 2; r <= n; r++) {
			for (int i = 1; i <= n - r + 1; i++) {
				int j = i + r - 1;
				// Primero divide por i
				m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j]; // Encuentra la multiplicaci�n continua de Ai a Aj
				s[i][j] = i; // registro de posici�n de divisi�n
				for (int k = i + 1; k < j; k++) {
					// Encuentra si hay un punto de divisi�n optimizable
					int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j]; // f�rmula
					if (t < m[i][j]) {
						m[i][j] = t;
						s[i][j] = k;
					}
				}
			}
		}
		return m[1][n];
	}

	/**
	 * Salida del orden de c�lculo �ptimo de A [i: j]
	 * 
	 * @param i, j: sub�ndice de matriz de multiplicaci�n continua
	 * @param s: la matriz que almacena el sub�ndice de la posici�n dividida
	 **/
	public static void traceback(int i, int j, int[][] s) {
		// Muestra el orden de c�lculo �ptimo de A [i: j]
		if (i == j) {
			// Salida recursiva
			System.out.print("A" + i);
			return;
		} else {
			System.out.print("(");
			// Salida recursiva a la izquierda
			traceback(i, s[i][j], s);
			// salida recursiva a la derecha
			traceback(s[i][j] + 1, j, s);
			System.out.print(")");
		}
	}

	public static void main(String[] args) {
		int[] p = new int[] { 5, 7, 4, 3, 5 };
		int[][] m = new int[p.length][p.length];
		int[][] s = new int[p.length][p.length];
		System.out.println("El valor �ptimo es:" + matrixChain(p, m, s));
		traceback(1, p.length - 1, s);
	}
}