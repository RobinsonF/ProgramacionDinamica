/**
 * Paquete vista
 */
package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author Jhoan Ricardo Cuevas Paniño, Robinson José Gutiérrez Solano, Omar
 *         Felipe Ladino Guezaguan
 *
 */
public class PanelBotones extends JPanel {

	private final String COMANDO_FLOYD = "FLOYD";
	private final String COMANDO_VIAJERO = "VIAJERO";
	private final String COMANDO_MATRICES = "MATRICES";
	private final String COMANDO_TAREAS = "TAREAS";
	private final String COMANDO_BINOMIO = "BINOMIO";
	private JButton btnFloyd, btnViajero, btnMatrices, btnTareas, btnBinomio;

	/**
	 * Inicializa todos los botones de la parte izquierda del programa
	 * correspondiente a la eleccion de los algoritmos. 
	 */
	public PanelBotones() {
		setLayout(new GridLayout(5, 1));
		btnFloyd = new JButton("Algoritmo de Floyd");
		btnViajero = new JButton("El problema del viajero");
		btnMatrices = new JButton("Producto de matrices");
		btnTareas = new JButton("Asignacion de tareas");
		btnBinomio = new JButton("Coeficientes binomiales");
		add(btnFloyd);
		add(btnViajero);
		add(btnMatrices);
		add(btnTareas);
		add(btnBinomio);
		btnFloyd.setActionCommand(COMANDO_FLOYD);
		btnViajero.setActionCommand(COMANDO_VIAJERO);
		btnMatrices.setActionCommand(COMANDO_MATRICES);
		btnTareas.setActionCommand(COMANDO_TAREAS);
		btnBinomio.setActionCommand(COMANDO_BINOMIO);
	}

	/**
	 * @return the btnFloyd
	 */
	public JButton getBtnFloyd() {
		return btnFloyd;
	}

	/**
	 * @param btnFloyd the btnFloyd to set
	 */
	public void setBtnFloyd(JButton btnFloyd) {
		this.btnFloyd = btnFloyd;
	}

	/**
	 * @return the btnViajero
	 */
	public JButton getBtnViajero() {
		return btnViajero;
	}

	/**
	 * @param btnViajero the btnViajero to set
	 */
	public void setBtnViajero(JButton btnViajero) {
		this.btnViajero = btnViajero;
	}

	/**
	 * @return the btnMatrices
	 */
	public JButton getBtnMatrices() {
		return btnMatrices;
	}

	/**
	 * @param btnMatrices the btnMatrices to set
	 */
	public void setBtnMatrices(JButton btnMatrices) {
		this.btnMatrices = btnMatrices;
	}

	/**
	 * @return the btnTareas
	 */
	public JButton getBtnTareas() {
		return btnTareas;
	}

	/**
	 * @param btnTareas the btnTareas to set
	 */
	public void setBtnTareas(JButton btnTareas) {
		this.btnTareas = btnTareas;
	}

	/**
	 * @return the btnBinomio
	 */
	public JButton getBtnBinomio() {
		return btnBinomio;
	}

	/**
	 * @param btnBinomio the btnBinomio to set
	 */
	public void setBtnBinomio(JButton btnBinomio) {
		this.btnBinomio = btnBinomio;
	}

	/**
	 * @return the cOMANDO_FLOYD
	 */
	public String getCOMANDO_FLOYD() {
		return COMANDO_FLOYD;
	}

	/**
	 * @return the cOMANDO_VIAJERO
	 */
	public String getCOMANDO_VIAJERO() {
		return COMANDO_VIAJERO;
	}

	/**
	 * @return the cOMANDO_MATRICES
	 */
	public String getCOMANDO_MATRICES() {
		return COMANDO_MATRICES;
	}

	/**
	 * @return the cOMANDO_TAREAS
	 */
	public String getCOMANDO_TAREAS() {
		return COMANDO_TAREAS;
	}

	/**
	 * @return the cOMANDO_BINOMIO
	 */
	public String getCOMANDO_BINOMIO() {
		return COMANDO_BINOMIO;
	}

}
