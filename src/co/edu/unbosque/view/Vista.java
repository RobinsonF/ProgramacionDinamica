package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import co.edu.unbosque.controller.Controller;

public class Vista extends JFrame{
	
	private PanelBotones panelBotones;
	
	private PanelProductoMatriz panelProductoMatriz;
	
	private PanelCoeficienteBinomial panelCoeficienteBinomial;
	
	private PanelViajero panelViajero;
	
	private JSplitPane splitPane;
	
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
		splitPane = new JSplitPane();
		splitPane.setLeftComponent(panelBotones);
		getContentPane().add(splitPane);
		asignarOyentes(controller);
		repaint();
		revalidate();
	}
	
	public void asignarOyentes(Controller controller) {
		panelBotones.getBtnFloyd().addActionListener(controller);
		panelBotones.getBtnViajero().addActionListener(controller);
		panelBotones.getBtnMatrices().addActionListener(controller);
		panelBotones.getBtnTareas().addActionListener(controller);
		panelBotones.getBtnBinomio().addActionListener(controller);
		panelProductoMatriz.getBtnConfirmar().addActionListener(controller);
		panelProductoMatriz.getPanelSeleccion().getBtnConfirmar().addActionListener(controller);
		panelProductoMatriz.getPanelSeleccion2().getBtnConfirmar2().addActionListener(controller);
		panelCoeficienteBinomial.getBtnConfirmar().addActionListener(controller);
		panelViajero.getPanelSeleccionViajero().getBtnConfirmar().addActionListener(controller);
		panelViajero.getBtnConfirmar().addActionListener(controller);

	}
	
	public void mostrarMensajeAdvertencia(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Mensaje de advertencia", JOptionPane.WARNING_MESSAGE);
	}
	
	public void mostrarMensajeInformacion(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public String pedirDato(String mensaje) {
		return JOptionPane.showInputDialog(mensaje);
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
	
}
