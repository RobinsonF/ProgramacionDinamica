package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class PanelProductoMatriz extends JPanel {

	private final String COMANDO_CONFIRMAR = "CONFIRMAR2";

	private PanelSeleccion panelSeleccion;

	private PanelSeleccion panelSeleccion2;

	private PanelMatriz panelMatriz1;

	private PanelMatriz panelMatriz2;

	private PanelMatriz panelMatriz3;

	private JSplitPane splitPane;

	private JSplitPane splitPane2;

	private JSplitPane splitPane3;

	private JButton btnConfirmar;

	public PanelProductoMatriz() {
		setLayout(new GridLayout(1, 3));
		panelSeleccion = new PanelSeleccion();
		panelSeleccion.inicializarComponentes();
		panelSeleccion2 = new PanelSeleccion();
		panelSeleccion2.inicializarComponentes2();
		panelMatriz1 = new PanelMatriz();
		panelMatriz2 = new PanelMatriz();
		panelMatriz3 = new PanelMatriz();
		btnConfirmar = new JButton("Hallar Producto");
		btnConfirmar.setActionCommand(COMANDO_CONFIRMAR);
		splitPane = new JSplitPane();
		splitPane2 = new JSplitPane();
		splitPane3 = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane2.setEnabled(false);
		splitPane3.setEnabled(false);
		splitPane.setRightComponent(panelMatriz1);
		splitPane.setLeftComponent(panelSeleccion);
		splitPane2.setRightComponent(panelMatriz2);
		splitPane2.setLeftComponent(panelSeleccion2);
		splitPane3.setLeftComponent(btnConfirmar);
		splitPane3.setRightComponent(panelMatriz3);
		add(splitPane);
		add(splitPane2);
		add(splitPane3);
	}

	/**
	 * @return the panelSeleccion
	 */
	public PanelSeleccion getPanelSeleccion() {
		return panelSeleccion;
	}

	/**
	 * @param panelSeleccion the panelSeleccion to set
	 */
	public void setPanelSeleccion(PanelSeleccion panelSeleccion) {
		this.panelSeleccion = panelSeleccion;
	}

	/**
	 * @return the panelSeleccion2
	 */
	public PanelSeleccion getPanelSeleccion2() {
		return panelSeleccion2;
	}

	/**
	 * @param panelSeleccion2 the panelSeleccion2 to set
	 */
	public void setPanelSeleccion2(PanelSeleccion panelSeleccion2) {
		this.panelSeleccion2 = panelSeleccion2;
	}

	/**
	 * @return the panelMatriz1
	 */
	public PanelMatriz getPanelMatriz1() {
		return panelMatriz1;
	}

	/**
	 * @param panelMatriz1 the panelMatriz1 to set
	 */
	public void setPanelMatriz1(PanelMatriz panelMatriz1) {
		this.panelMatriz1 = panelMatriz1;
	}

	/**
	 * @return the panelMatriz2
	 */
	public PanelMatriz getPanelMatriz2() {
		return panelMatriz2;
	}

	/**
	 * @param panelMatriz2 the panelMatriz2 to set
	 */
	public void setPanelMatriz2(PanelMatriz panelMatriz2) {
		this.panelMatriz2 = panelMatriz2;
	}

	/**
	 * @return the panelMatriz3
	 */
	public PanelMatriz getPanelMatriz3() {
		return panelMatriz3;
	}

	/**
	 * @param panelMatriz3 the panelMatriz3 to set
	 */
	public void setPanelMatriz3(PanelMatriz panelMatriz3) {
		this.panelMatriz3 = panelMatriz3;
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
	 * @return the splitPane2
	 */
	public JSplitPane getSplitPane2() {
		return splitPane2;
	}

	/**
	 * @param splitPane2 the splitPane2 to set
	 */
	public void setSplitPane2(JSplitPane splitPane2) {
		this.splitPane2 = splitPane2;
	}

	/**
	 * @return the splitPane3
	 */
	public JSplitPane getSplitPane3() {
		return splitPane3;
	}

	/**
	 * @param splitPane3 the splitPane3 to set
	 */
	public void setSplitPane3(JSplitPane splitPane3) {
		this.splitPane3 = splitPane3;
	}

	/**
	 * @return the btnConfirmar
	 */
	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	/**
	 * @param btnConfirmar the btnConfirmar to set
	 */
	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}

	/**
	 * @return the cOMANDO_CONFIRMAR
	 */
	public String getCOMANDO_CONFIRMAR() {
		return COMANDO_CONFIRMAR;
	}	
	
}
