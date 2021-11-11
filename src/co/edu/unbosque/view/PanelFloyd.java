/**
 * Paquete vista
 */
package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
/**
 * 
 * @author Jhoan Ricardo Cuevas Paniño, Robinson José Gutiérrez Solano, Omar
 *         Felipe Ladino Guezaguan
 *
 */
public class PanelFloyd extends JPanel {

	private final String COMANDO_CONFIRMAR = "CONFIRMAR7";

	private PanelSeleccionFloyd panelSeleccionFloyd;
	private PanelMatriz panelMatriz;
	private PanelMatriz panelMatriz1;
	private JButton btnConfirmar;
	private JSplitPane splitPane;
	private JPanel panel;

	/**
	 * Este método se encarga de inicializar todos los componentes del panel.
	 */
	public PanelFloyd() {
		setLayout(new GridLayout(1, 1));
		panelSeleccionFloyd = new PanelSeleccionFloyd();
		panelMatriz = new PanelMatriz();
		panelMatriz1 = new PanelMatriz();
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setActionCommand(COMANDO_CONFIRMAR);
		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.add(panelMatriz);
		panel.add(btnConfirmar);
		splitPane = new JSplitPane();
		splitPane.setLeftComponent(panelSeleccionFloyd);
		splitPane.setRightComponent(panel);
		add(splitPane);
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
	 * @return the panelSeleccionViajero
	 */
	public PanelSeleccionFloyd getPanelSeleccionFloyd() {
		return panelSeleccionFloyd;
	}

	/**
	 * @param panelSeleccionViajero the panelSeleccionViajero to set
	 */
	public void setPanelSeleccionFloyd(PanelSeleccionFloyd panelSeleccionFloyd) {
		this.panelSeleccionFloyd = panelSeleccionFloyd;
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
