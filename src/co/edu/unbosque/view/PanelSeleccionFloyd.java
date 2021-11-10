package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelSeleccionFloyd extends JPanel{
	
	private final String COMANDO_CONFIRMAR = "CONFIRMAR6";
	
	private JLabel labelNumNodos;
	private JTextField txtNumNodos;
	private JButton btnConfirmar;
	
	public PanelSeleccionFloyd() {
		setLayout(new GridLayout(3, 1));
		labelNumNodos = new JLabel("Ingrese el número de nodos");
		txtNumNodos = new JTextField();
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setActionCommand(COMANDO_CONFIRMAR);
		add(labelNumNodos);
		add(txtNumNodos);
		add(btnConfirmar);
	}

	/**
	 * @return the labelNumCiudad
	 */
	public JLabel getLabelNumNodos() {
		return labelNumNodos;
	}

	/**
	 * @param labelNumCiudad the labelNumCiudad to set
	 */
	public void setLabelNumNodos(JLabel labelNumNodos) {
		this.labelNumNodos = labelNumNodos;
	}

	/**
	 * @return the txtNumCiudad
	 */
	public JTextField getTxtNumNodos() {
		return txtNumNodos;
	}

	/**
	 * @param txtNumCiudad the txtNumCiudad to set
	 */
	public void setTxtNumCiudad(JTextField txtNumNodos) {
		this.txtNumNodos = txtNumNodos;
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
	 * @return the COMANDO_CONFIRMAR
	 */
	public String getCOMANDO_CONFIRMAR() {
		return COMANDO_CONFIRMAR;
	}

}
