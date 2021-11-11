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
public class PanelSeleccionFloyd extends JPanel{
	
	private final String COMANDO_CONFIRMAR = "CONFIRMAR6";
	
	private JLabel labelNumNodos;
	private JTextField txtNumNodos;
	private JButton btnConfirmar;
	
	/**
	 * Este método se encarga de inicializar todos los componentes del panel.
	 */
	public PanelSeleccionFloyd() {
		setLayout(new GridLayout(3, 1));
		Font font = new Font("SansSerif", Font.BOLD, 30);
		labelNumNodos = new JLabel("Ingrese el número de nodos");
		txtNumNodos = new JTextField();
		txtNumNodos.setFont(font);
		txtNumNodos.setHorizontalAlignment(SwingConstants.CENTER);
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setActionCommand(COMANDO_CONFIRMAR);
		add(labelNumNodos);
		add(txtNumNodos);
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
		if (!"".equals(txtNumNodos.getText())) {
			if (!"0".equals(txtNumNodos.getText())) {
				salidas[1] = txtNumNodos.getText();
			}else {
				
				salidas[0] = "1";
				salidas[1] = "El número de nodos tiene que ser mayor a cero";
			}
		} else {
			salidas[0] = "1";
			salidas[1] = "Por favor ingrese un número de nodos";
		}
		
		return salidas;
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
