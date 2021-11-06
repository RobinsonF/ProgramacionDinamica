package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import co.edu.unbosque.controller.Controller;

public class Vista extends JFrame{
	
	private PanelBotones panelBotones;
	
	private PanelProductoMatriz panelProductoMatriz;
	
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
	
	
}
