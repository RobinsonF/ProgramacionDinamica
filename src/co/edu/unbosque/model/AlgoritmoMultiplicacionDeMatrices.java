package co.edu.unbosque.model;


public class AlgoritmoMultiplicacionDeMatrices {

	/**
	 * Resuelve el valor óptimo
	 * 
	 * @param p: matriz de información de dimensión de matriz
	 * @param m: almacena la matriz de valores óptimos, triángulo superior
	 * @param s: la matriz que almacena el subíndice de la posición dividida
	 * @return devuelve el valor óptimo
	 **/
	public static int matrixChain(int[] p, int[][] m, int[][] s) {
		int n = p.length - 1;
		for (int i = 1; i <= n; i++)
			// en sí mismo es 0
			m[i][i] = 0; // Inicializa una matriz bidimensional
		for (int r = 2; r <= n; r++) {
			for (int i = 1; i <= n - r + 1; i++) {
				int j = i + r - 1;
				// Primero divide por i
				m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j]; // Encuentra la multiplicación continua de Ai a Aj
				s[i][j] = i; // registro de posición de división
				for (int k = i + 1; k < j; k++) {
					// Encuentra si hay un punto de división optimizable
					int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j]; // fórmula
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
	 * Salida del orden de cálculo óptimo de A [i: j]
	 * 
	 * @param i, j: subíndice de matriz de multiplicación continua
	 * @param s: la matriz que almacena el subíndice de la posición dividida
	 **/
	public static void traceback(int i, int j, int[][] s) {
		// Muestra el orden de cálculo óptimo de A [i: j]
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
		System.out.println("El valor óptimo es:" + matrixChain(p, m, s));
		traceback(1, p.length - 1, s);
	}
}