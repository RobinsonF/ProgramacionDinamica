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
public class ExcepcionNumero extends Exception{
	
	/**
	 * Constructor clase ExcepcionNumero.
	 */
	public ExcepcionNumero() {

	}
	
	/**
	 * Constructor clase ExcepcionNumero.
	 * @param mensaje, mensaje capturado de excepci?n.
	 */
	public ExcepcionNumero(String mensaje) {
		super(mensaje);
	}
}
