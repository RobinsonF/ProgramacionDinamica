/**
 * Paquete modelo
 */
package co.edu.unbosque.model;

/**
 * 
 * @author Jhoan Ricardo Cuevas Pani?o, Robinson Jos? Guti?rrez Solano, Omar
 *         Felipe Ladino Guezaguan
 *
 */
public class Algoritmo {

	/**
	 * Constructor de la clase Algoritmo.
	 */
	public Algoritmo() {

	}

//----------------------------------------FLOYD-----------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------
	/**
	 * A partir de una matriz de recorridos, halla una matriz con las rutas mas
	 * cortas entre todos los nodos.
	 * 
	 * @param matrizRecorridos: matriz con los valores de la distancia entre los
	 *                          nodos.
	 * @return devuelve la matriz con los recorridos m?s cortos entre todos los
	 *         nodos.
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

//----------------------------------------ASIGNACI?N DE TAREAS-----------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------

	/**
	 * M?todo encargado de representar el n?mero m?s ?ptimo de tareas que se pueden
	 * realizar en n d?as.
	 * 
	 * @param high son los pesos de las tareas de alto esfuerzo.
	 * @param low  son los pesos de las tareas de bajo esfuerzo.
	 * @param n    son los d?as en que se van a realizar las tareas.
	 * @return el numero de de tareas que se pueden realizar en los n d?as.
	 */
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

	/**
	 * Metodo encargado de determinar el n?mero de subconjuntos de tama?o k que se
	 * pueden crear a partir de un conjunto n.
	 * 
	 * @param n es el tama?o del conjunto base.
	 * @param k es el tama?o que deber?n tener los subconjuntos.
	 * @return el n?mero de subconjuntos de tama?o k que se pueden crear a partir de
	 *         un conjunto n.
	 */
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
	 * Resuelve el valor ?ptimo
	 * 
	 * @param p: matriz de informaci?n de dimensi?n de matriz
	 * @param m: almacena la matriz de valores ?ptimos, tri?ngulo superior
	 * @param s: la matriz que almacena el sub?ndice de la posici?n dividida
	 * @return devuelve el valor ?ptimo
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
	 * Salida del orden de c?lculo ?ptimo de A [i: j]
	 * 
	 * @param i, j: sub?ndice de matriz de multiplicaci?n continua
	 * @param s: la matriz que almacena el sub?ndice de la posici?n dividida
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

	/**
	 * Metodo encargado de determinar si la cadena contiene solo valores numericos.
	 * 
	 * @param numero es la cadena a filtrar.
	 * @return valor falso o verdadero
	 */
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

	/**
	 * Metodo encargado de determinar si la cadena contiene solo valores numericos.
	 * 
	 * @param numero es la cadena a filtrar.
	 * @return valor falso o verdadero
	 */
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

	/**
	 * M?todo encargado de determinar si la cadena contiene solo valores num?ricos.
	 * 
	 * @param n?mero es la cadena a filtrar.
	 * @throws ExcepcionNumero devuelve mensaje de la excepci?n.
	 */
	public void verificarNumero2(String numero) throws ExcepcionNumero {
		if (!soloNumeros2(numero)) {
			throw new ExcepcionNumero("Caracter Invalido");
		}
	}

	/**
	 * M?todo encargado de determinar si la cadena contiene solo valores num?ricos.
	 * 
	 * @param n?mero es la cadena a filtrar.
	 * @throws ExcepcionNumero devuelve mensaje de la excepci?n.
	 */
	public void verificarNumero(String numero) throws ExcepcionNumero {
		if (!soloNumeros(numero)) {
			throw new ExcepcionNumero("Caracter Invalido");
		}
	}
}
