package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelProductoMatriz extends JPanel {

	private final String COMANDO_CONFIRMAR = "CONFIRMAR2";

	private JLabel labelNumMatriz;

	private JTextField txtNumMatriz;

	private JButton btnConfirmar;

	/**
	 * Este método se encarga de inicializar todos los componentes del panel.
	 */
	public PanelProductoMatriz() {
		setLayout(new GridLayout(3, 1));
		Font font = new Font("SansSerif", Font.BOLD, 30);
		labelNumMatriz = new JLabel("Ingrese el número de matrices");
		labelNumMatriz.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumMatriz = new JTextField();
		txtNumMatriz.setFont(font);
		txtNumMatriz.setHorizontalAlignment(SwingConstants.CENTER);
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setActionCommand(COMANDO_CONFIRMAR);
		add(labelNumMatriz);
		add(txtNumMatriz);
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
		if (!"".equals(txtNumMatriz.getText())) {
			if(!"0".equals(txtNumMatriz.getText())) {
				salidas[1] = txtNumMatriz.getText();
			}else {
				salidas[0] = "1";
				salidas[1] = "El número de matrices debe ser mayor a cero";
			}
		} else {
			salidas[0] = "1";
			salidas[1] = "Por favor ingrese el número de matrices";
		}
		return salidas;
	}

	/**
	 * @return the labelNumMatriz
	 */
	public JLabel getLabelNumMatriz() {
		return labelNumMatriz;
	}

	/**
	 * @param labelNumMatriz the labelNumMatriz to set
	 */
	public void setLabelNumMatriz(JLabel labelNumMatriz) {
		this.labelNumMatriz = labelNumMatriz;
	}

	/**
	 * @return the txtNumMatriz
	 */
	public JTextField getTxtNumMatriz() {
		return txtNumMatriz;
	}

	/**
	 * @param txtNumMatriz the txtNumMatriz to set
	 */
	public void setTxtNumMatriz(JTextField txtNumMatriz) {
		this.txtNumMatriz = txtNumMatriz;
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
