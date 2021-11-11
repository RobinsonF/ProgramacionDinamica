/**
 * Paquete vista
 */
package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
 * 
 * @author Jhoan Ricardo Cuevas Paniño, Robinson José Gutiérrez Solano, Omar
 *         Felipe Ladino Guezaguan
 *
 */
public class PanelSeleccionViajero extends JPanel {

	private final String COMANDO_CONFIRMAR = "CONFIRMAR3";

	private JLabel labelNumCiudad;
	private JTextField txtNumCiudad;
	private JButton btnConfirmar;

	/**
	 * Este método se encarga de inicializar todos los componentes del panel.
	 */
	public PanelSeleccionViajero() {
		setLayout(new GridLayout(3, 1));
		Font font = new Font("SansSerif", Font.BOLD, 30);
		labelNumCiudad = new JLabel("Ingrese el número de ciudades");
		txtNumCiudad = new JTextField();
		txtNumCiudad.setFont(font);
		txtNumCiudad.setHorizontalAlignment(SwingConstants.CENTER);
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setActionCommand(COMANDO_CONFIRMAR);
		add(labelNumCiudad);
		add(txtNumCiudad);
		add(btnConfirmar);
	}

	/**
	 * Este método se encarga de verificar las entradas obtenidas. 
	 * @return, retorna las entradas validadas o con su respectivo mensaje de
	 * advertencia.
	 */
	public String[] verificarEntradas() {
		String[] salidas = new String[2];
		salidas[0] = "0";
		if (!"".equals(txtNumCiudad.getText())) {
			if (!"0".equals(txtNumCiudad.getText())) {
				salidas[1] = txtNumCiudad.getText();
			} else {
				salidas[0] = "1";
				salidas[1] = "El número de ciudades tiene que ser mayor a cero";
			}
		} else {
			salidas[0] = "1";
			salidas[1] = "Por favor ingrese un número de ciudades";
		}
		
		return salidas;
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
