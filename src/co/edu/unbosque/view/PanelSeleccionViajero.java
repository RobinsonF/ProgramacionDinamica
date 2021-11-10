package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelSeleccionViajero extends JPanel{
	
	private final String COMANDO_CONFIRMAR = "CONFIRMAR3";
	
	private JLabel labelNumCiudad;
	private JTextField txtNumCiudad;
	private JButton btnConfirmar;
	
	public PanelSeleccionViajero() {
		setLayout(new GridLayout(3, 1));
		labelNumCiudad = new JLabel("Ingrese el n�mero de ciudades");
		txtNumCiudad = new JTextField();
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setActionCommand(COMANDO_CONFIRMAR);
		add(labelNumCiudad);
		add(txtNumCiudad);
		add(btnConfirmar);
	}

	/**
	 * @return the labelNumCiudad
	 */
	public JLabel getLabelNumCiudad() {
		return labelNumCiudad;
	}

	/**
	 * @param labelNumCiudad the labelNumCiudad to set
	 */
	public void setLabelNumCiudad(JLabel labelNumCiudad) {
		this.labelNumCiudad = labelNumCiudad;
	}

	/**
	 * @return the txtNumCiudad
	 */
	public JTextField getTxtNumCiudad() {
		return txtNumCiudad;
	}

	/**
	 * @param txtNumCiudad the txtNumCiudad to set
	 */
	public void setTxtNumCiudad(JTextField txtNumCiudad) {
		this.txtNumCiudad = txtNumCiudad;
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
