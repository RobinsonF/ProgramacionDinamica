package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelTareas extends JPanel {

	private final String COMANDO_CONFIRMAR = "CONFIRMAR8";

	private JLabel labelDias;
	private JLabel labelTareas;
	private JTextField txtdias;
	private JTextField txtTareas;
	private JButton btnConfirmar;
	private JPanel panel;

	/**
	 * Este método se encarga de inicializar todos los componentes del panel.
	 */
	public PanelTareas() {
		setLayout(new GridLayout(2, 1));
		Font font = new Font("SansSerif", Font.BOLD, 30);
		labelDias = new JLabel("Ingrese el número de días");
		labelDias.setHorizontalAlignment(SwingConstants.CENTER);
		labelTareas = new JLabel("Ingrese el número de tareas\n de alto y bajo esfuerzo");
		labelTareas.setHorizontalAlignment(SwingConstants.CENTER);
		txtdias = new JTextField();
		txtdias.setFont(font);
		txtdias.setHorizontalAlignment(SwingConstants.CENTER);
		txtTareas = new JTextField();
		txtTareas.setFont(font);
		txtTareas.setHorizontalAlignment(SwingConstants.CENTER);
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setActionCommand(COMANDO_CONFIRMAR);
		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		panel.add(labelDias);
		panel.add(labelTareas);
		panel.add(txtdias);
		panel.add(txtTareas);
		add(panel);
		add(btnConfirmar);
	}

	/**
	 * Este método se encarga de verificar las entradas obtenidas. 
	 * @return, retorna las entradas validadas o con su respectivo mensaje de
	 * advertencia.
	 */
	public String[] verificarEntradas() {
		String[] salidas = new String[3];
		salidas[0] = "0";
		if (!"".equals(txtTareas.getText()) && !"".equals(txtdias.getText())) {
			salidas[1] = txtdias.getText();
			if (!"0".equals(txtTareas.getText())) {
				salidas[2] = txtTareas.getText();
			} else {
				salidas[0] = "1";
				salidas[1] = "El número de tares tiene que ser mayor a cero";
			}
		} else {
			salidas[0] = "1";
			salidas[1] = "Por favor complete los campos";
		}
		return salidas;
	}

	/**
	 * @return the labelDias
	 */
	public JLabel getLabelDias() {
		return labelDias;
	}

	/**
	 * @param labelDias the labelDias to set
	 */
	public void setLabelDias(JLabel labelDias) {
		this.labelDias = labelDias;
	}

	/**
	 * @return the labelTareas
	 */
	public JLabel getLabelTareas() {
		return labelTareas;
	}

	/**
	 * @param labelTareas the labelTareas to set
	 */
	public void setLabelTareas(JLabel labelTareas) {
		this.labelTareas = labelTareas;
	}

	/**
	 * @return the txtdias
	 */
	public JTextField getTxtdias() {
		return txtdias;
	}

	/**
	 * @param txtdias the txtdias to set
	 */
	public void setTxtdias(JTextField txtdias) {
		this.txtdias = txtdias;
	}

	/**
	 * @return the txtTareas
	 */
	public JTextField getTxtTareas() {
		return txtTareas;
	}

	/**
	 * @param txtTareas the txtTareas to set
	 */
	public void setTxtTareas(JTextField txtTareas) {
		this.txtTareas = txtTareas;
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
