package co.edu.unbosque.model;

public class Algoritmo {

	public Algoritmo() {
		
	}
	
	public int[][] productoMatriz(int[][] matriz1, int[][] matriz2) {
		int filas = matriz1.length;
		int columnas = matriz2[0].length;
		int[][] resultado = new int[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				for (int k = 0; k < columnas; k++) {
					int producto = matriz1[i][k] * matriz2[k][j];
					resultado[i][j] += producto;
				}
			}
		}
		return resultado;
	}
	
	public boolean soloNumeros(String numero) {
		for (int i = 0; i < numero.length(); i++) {
			char aux = numero.charAt(i);
			int digito = aux - '0';
			if (digito > 9) {
				return false;
			}
		}
		return true;
	}

	public void verificarNumero(String numero) throws ExcepcionNumero {
		if (!soloNumeros(numero)) {
			throw new ExcepcionNumero("Solo se permiten ingresar números, verifique los campos");
		}
	}
}
