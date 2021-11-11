package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class PanelViajero extends JPanel{
	
	private final String COMANDO_CONFIRMAR = "CONFIRMAR4";

	private PanelSeleccionViajero panelSeleccionViajero;
	private PanelMatriz panelMatriz;
	private JButton btnConfirmar;
	private JSplitPane splitPane;
	private JPanel panel;
	
	/**
	 * Este método se encarga de inicializar todos los componentes del panel.
	 */
	public PanelViajero() {
		setLayout(new GridLayout(1, 1));
		panelSeleccionViajero = new PanelSeleccionViajero();
		panelMatriz = new PanelMatriz();
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setActionCommand(COMANDO_CONFIRMAR);
		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.add(panelMatriz);
		panel.add(btnConfirmar);
		splitPane = new JSplitPane();
		splitPane.setLeftComponent(panelSeleccionViajero);
		splitPane.setRightComponent(panel);
		add(splitPane);
	}

	/**
	 * @return the panelSeleccionViajero
	 */
	public PanelSeleccionViajero getPanelSeleccionViajero() {
		return panelSeleccionViajero;
	}

	/**
	 * @param panelSeleccionViajero the panelSeleccionViajero to set
	 */
	public void setPanelSeleccionViajero(PanelSeleccionViajero panelSeleccionViajero) {
		this.panelSeleccionViajero = panelSeleccionViajero;
	}

	/**
	 * @return the panelMatriz
	 */
	public PanelMatriz getPanelMatriz() {
		return panelMatriz;
	}

	/**
	 * @param panelMatriz the panelMatriz to set
	 */
	public void setPanelMatriz(PanelMatriz panelMatriz) {
		this.panelMatriz = panelMatriz;
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
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * @return the cOMANDO_CONFIRMAR
	 */
	public String getCOMANDO_CONFIRMAR() {
		return COMANDO_CONFIRMAR;
	}


}
