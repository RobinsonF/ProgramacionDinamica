/**
 * Paquete vista
 */
package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import co.edu.unbosque.controller.Controller;
/**
 * 
 * @author Jhoan Ricardo Cuevas Paniño, Robinson José Gutiérrez Solano, Omar
 *         Felipe Ladino Guezaguan
 *
 */
public class Vista extends JFrame {

	private PanelBotones panelBotones;

	private PanelProductoMatriz panelProductoMatriz;

	private PanelCoeficienteBinomial panelCoeficienteBinomial;

	private PanelViajero panelViajero;

	private PanelFloyd panelFloyd;
	
	private PanelTareas panelTareas;

	private JSplitPane splitPane;

	private JPanel panel;

	/**
	 * Este método se encarga de inicializar todos los componentes del panel.
	 */
	public Vista(Controller controller) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(900, 400);
		this.setTitle("Producto Matrices");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		panelBotones = new PanelBotones();
		panelProductoMatriz = new PanelProductoMatriz();
		panelCoeficienteBinomial = new PanelCoeficienteBinomial();
		panelViajero = new PanelViajero();
		panelFloyd = new PanelFloyd();
		panelTareas = new PanelTareas();
		splitPane = new JSplitPane();
		panel = new JPanel();
		splitPane.setLeftComponent(panelBotones);
		splitPane.setRightComponent(panel);
		getContentPane().add(splitPane);
		asignarOyentes(controller);
		repaint();
		revalidate();
	}

	/**
	 * Método encargado de asignar los oyentes a los botones.
	 * @param controller es la clase controlador
	 */
	public void asignarOyentes(Controller controller) {
		panelBotones.getBtnFloyd().addActionListener(controller);
		panelBotones.getBtnViajero().addActionListener(controller);
		panelBotones.getBtnMatrices().addActionListener(controller);
		panelBotones.getBtnTareas().addActionListener(controller);
		panelBotones.getBtnBinomio().addActionListener(controller);
		panelProductoMatriz.getBtnConfirmar().addActionListener(controller);
		panelCoeficienteBinomial.getBtnConfirmar().addActionListener(controller);
		panelViajero.getPanelSeleccionViajero().getBtnConfirmar().addActionListener(controller);
		panelViajero.getBtnConfirmar().addActionListener(controller);
		panelFloyd.getPanelSeleccionFloyd().getBtnConfirmar().addActionListener(controller);
		panelFloyd.getBtnConfirmar().addActionListener(controller);
		panelTareas.getBtnConfirmar().addActionListener(controller);

	}
	
	/**
	 * Método encargado de mostrar un mensaje de advertencia.
	 * @param mensaje
	 */
	public void mostrarMensajeAdvertencia(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Método encargado de mostrar un mensaje informativo.
	 * @param mensaje
	 */
	public void mostrarMensajeInformacion(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Método encargado de mostrar un mensaje de error.
	 * @param mensaje
	 */
	public void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Método encargado de solicitar datos al usuario.
	 * @param mensaje es el texto informativo acerca del dato solicitado.
	 * @return el dato solicitado.
	 */
	public String pedirDato(String mensaje) {
		String n = JOptionPane.showInputDialog(mensaje);
		if (n == null) {
			n = "Accion Cancelada";
		}else if("".equals(n)) {
			n = "Por favor digite un valor";
		}
		return n;
	}
	
	
	/**
	 * @return the panelTareas
	 */
	public PanelTareas getPanelTareas() {
		return panelTareas;
	}

	/**
	 * @param panelTareas the panelTareas to set
	 */
	public void setPanelTareas(PanelTareas panelTareas) {
		this.panelTareas = panelTareas;
	}

	/**
	 * @return the panelCoeficienteBinomial
	 */
	public PanelCoeficienteBinomial getPanelCoeficienteBinomial() {
		return panelCoeficienteBinomial;
	}

	/**
	 * @param panelCoeficienteBinomial the panelCoeficienteBinomial to set
	 */
	public void setPanelCoeficienteBinomial(PanelCoeficienteBinomial panelCoeficienteBinomial) {
		this.panelCoeficienteBinomial = panelCoeficienteBinomial;
	}

	/**
	 * @return the panelBotones
	 */
	public PanelBotones getPanelBotones() {
		return panelBotones;
	}

	/**
	 * @param panelBotones the panelBotones to set
	 */
	public void setPanelBotones(PanelBotones panelBotones) {
		this.panelBotones = panelBotones;
	}

	/**
	 * @return the splitPane
	 */
	public JSplitPane getSplitPane() {
		return splitPane;
	}

	/**
	 * @param splitPane the splitPane to set
	 */
	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

	/**
	 * @return the panelProductoMatriz
	 */
	public PanelProductoMatriz getPanelProductoMatriz() {
		return panelProductoMatriz;
	}

	/**
	 * @param panelProductoMatriz the panelProductoMatriz to set
	 */
	public void setPanelProductoMatriz(PanelProductoMatriz panelProductoMatriz) {
		this.panelProductoMatriz = panelProductoMatriz;
	}

	/**
	 * @return the panelViajero
	 */
	public PanelViajero getPanelViajero() {
		return panelViajero;
	}

	/**
	 * @param panelViajero the panelViajero to set
	 */
	public void setPanelViajero(PanelViajero panelViajero) {
		this.panelViajero = panelViajero;
	}

	public PanelFloyd getPanelFloyd() {
		return panelFloyd;
	}

	public void setPanelFloyd(PanelFloyd panelFloyd) {
		this.panelFloyd = panelFloyd;
	}

}
