/**
 * Paquete modelo
 */
package co.edu.unbosque.model;

/**
 * 
 * @author Jhoan Ricardo Cuevas Paniño, Robinson José Gutiérrez Solano, Omar
 *         Felipe Ladino Guezaguan
 *
 */
public class ExcepcionNumero extends Exception{
	
	/**
	 * Constructor clase ExcepcionNumero.
	 */
	public ExcepcionNumero() {

	}
	
	/**
	 * Constructor clase ExcepcionNumero.
	 * @param mensaje, mensaje capturado de excepción.
	 */
	public ExcepcionNumero(String mensaje) {
		super(mensaje);
	}
}
