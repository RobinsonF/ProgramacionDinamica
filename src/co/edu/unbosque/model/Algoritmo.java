package co.edu.unbosque.model;

public class Algoritmo {

	public Algoritmo() {

	}

//----------------------------------------FLOYD-----------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------
	/**
	 * A partir de una matriz de recorridos, halla una matriz con las rutas mas cortas entre todos los nodos.
	 * @param matrizRecorridos: matriz con los valores de la distancia entre los nodos.
	 * @return devuelve la matriz con los recorridos más cortos entre todos los nodos.
	 */
	public int[][] rutasCortas(int[][] matrizRecorridos) {
		int n = matrizRecorridos.length;
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (matrizRecorridos[i][k] + matrizRecorridos[k][j] < matrizRecorridos[i][j]) {
						matrizRecorridos[i][j] = matrizRecorridos[i][k] + matrizRecorridos[k][j];
					}
				}
			}
		}
		return matrizRecorridos;
	}

//--------------------------------------------------------------------------------------------------------------------------

//----------------------------------------ASIGNACIÓN DE TAREAS-----------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------

	public int asigTareasf(int[] high, int[] low, int n) {

		int[] task_dp = new int[n + 1];
		task_dp[0] = 0;
		task_dp[1] = high[0];

		for (int i = 2; i <= n; i++)
			task_dp[i] = Math.max(high[i - 1] + task_dp[i - 2], low[i - 1] + task_dp[i - 1]);
		return task_dp[n];
	}

//--------------------------------------------------------------------------------------------------------------------------

//----------------------------------------COEFICIENTES BINOMIALES--------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------

	public int coefBin(int n, int k) {
		int i, j;
		int[][] tabla = new int[n + 1][n + 1];

		if (k == 0 || k == n) {
			return 1;
		} else if (k > n) {
			return 0;
		} else {
			for (i = 0; i <= n; i++) {
				tabla[i][0] = 1;
			}

			for (i = 1; i <= n; i++) {
				tabla[i][1] = i;
			}

			for (i = 2; i <= k; i++) {
				tabla[i][i] = 1;
			}

			for (i = 3; i <= n; i++) {
				for (j = 2; j < n; j++) {
					if (j <= k) {
						tabla[i][j] = tabla[i - 1][j - 1] + tabla[i - 1][j];
					}
				}
			}
		}

		return tabla[n][k];
	}

//--------------------------------------------------------------------------------------------------------------------------	
//----------------------------------------MULTIPLICACION DE MATRICES--------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------

	/**
	 * Resuelve el valor óptimo
	 * 
	 * @param p: matriz de información de dimensión de matriz
	 * @param m: almacena la matriz de valores óptimos, triángulo superior
	 * @param s: la matriz que almacena el subíndice de la posición dividida
	 * @return devuelve el valor óptimo
	 **/
	public int matrixChain(int[] p, int[][] m, int[][] s) {
		int n = p.length - 1;
		for (int i = 1; i <= n; i++)
			m[i][i] = 0;
		for (int r = 2; r <= n; r++) {
			for (int i = 1; i <= n - r + 1; i++) {
				int j = i + r - 1;
				m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];
				s[i][j] = i;
				for (int k = i + 1; k < j; k++) {
					int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
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
	public String traceback(int i, int j, int[][] s, String mensaje) {
		String mensaje2 = mensaje;
		if (i == j) {
			mensaje2 += "A" + i;
			return mensaje2;
		} else {
			mensaje2 += "(";
			mensaje2 = traceback(i, s[i][j], s, mensaje2);
			mensaje2 = traceback(s[i][j] + 1, j, s, mensaje2);
			mensaje2 += ")";
		}
		return mensaje2;
	}

//--------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------

	public boolean soloNumeros(String numero) {
		for (int i = 0; i < numero.length(); i++) {
			char aux = numero.charAt(i);
			int digito = aux - '0';
			if (digito > 9 || digito < 0) {
				return false;
			}
		}
		return true;
	}

	public boolean soloNumeros2(String numero) {
		for (int i = 0; i < numero.length(); i++) {
			char aux = numero.charAt(i);
			int digito = aux - '0';
			if (digito > 9) {
				return false;
			}
		}
		return true;
	}

	public void verificarNumero2(String numero) throws ExcepcionNumero {
		if (!soloNumeros2(numero)) {
			throw new ExcepcionNumero("Caracter Invalido");
		}
	}

	public void verificarNumero(String numero) throws ExcepcionNumero {
		if (!soloNumeros(numero)) {
			throw new ExcepcionNumero("Caracter Invalido");
		}
	}
}
