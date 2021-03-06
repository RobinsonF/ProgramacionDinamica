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
 * @author Jhoan Ricardo Cuevas Pani?o, Robinson Jos? Guti?rrez Solano, Omar
 *         Felipe Ladino Guezaguan
 *
 */
public class PanelCoeficienteBinomial extends JPanel {

	private final String COMANDO_CB = "CB";

	private JButton btnConfirmar;
	private JLabel labelParentesis1;
	private JLabel labelParentesis2;
	private JPanel panel;
	private JTextField txtNumero1;
	private JLabel labelDivisor;
	private JTextField txtNumero2;
	private JPanel panelAll;

	/**
	 * Este m?todo se encarga de inicializar todos los componentes del panel.
	 */
	public PanelCoeficienteBinomial() {
		setLayout(new GridLayout(2, 1));
		Font font = new Font("SansSerif", Font.BOLD, 150);
		Font font2 = new Font("SansSerif", Font.BOLD, 30);
		labelParentesis1 = new JLabel("(");
		labelParentesis1.setFont(font);
		labelParentesis1.setHorizontalAlignment(SwingConstants.CENTER);
		labelParentesis1.setVerticalAlignment(SwingConstants.CENTER);
		labelParentesis2 = new JLabel(")");
		labelParentesis2.setFont(font);
		labelParentesis2.setHorizontalAlignment(SwingConstants.CENTER);
		labelParentesis2.setVerticalAlignment(SwingConstants.CENTER);
		labelDivisor = new JLabel();
		labelDivisor.setFont(font);
		labelDivisor.setHorizontalAlignment(SwingConstants.CENTER);
		labelDivisor.setVerticalAlignment(SwingConstants.CENTER);
		txtNumero1 = new JTextField();
		txtNumero1.setFont(font2);
		txtNumero1.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumero2 = new JTextField();
		txtNumero2.setFont(font2);
		txtNumero2.setHorizontalAlignment(SwingConstants.CENTER);
		panel = new JPanel();
		panelAll = new JPanel();
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setActionCommand(COMANDO_CB);
		panelAll.add(panel);
		panel.setLayout(new GridLayout(3, 1));
		panel.add(txtNumero1);
		panel.add(labelDivisor);
		panel.add(txtNumero2);
		panelAll.setLayout(new GridLayout(1, 3));
		panelAll.add(labelParentesis1);
		panelAll.add(panel);
		panelAll.add(labelParentesis2);
		add(panelAll);
		add(btnConfirmar);
	}

	/**
	 * Este m?todo se encarga de verificar las entradas obtenidas. 
	 * @return, retorna las entradas validadas o con su respectivo mensaje de
	 * advertencia.
	 */
	public String[] verificarEntradas() {
		String[] salidas = new String[3];
		salidas[0] = "0";
		if (!"".equals(txtNumero1.getText()) && !"".equals(txtNumero2.getText())) {
			salidas[1] = txtNumero1.getText();
			salidas[2] = txtNumero2.getText();
		} else {
			salidas[0] = "1";
			salidas[1] = "Por favor ingrese los valores del coeficiente binomial";
		}
		return salidas;
	}

	/**
	 * @return the labelParentesis1
	 */
	public JLabel getLabelParentesis1() {
		return labelParentesis1;
	}

	/**
	 * @param labelParentesis1 the labelParentesis1 to set
	 */
	public void setLabelParentesis1(JLabel labelParentesis1) {
		this.labelParentesis1 = labelParentesis1;
	}

	/**
	 * @return the labelParentesis2
	 */
	public JLabel getLabelParentesis2() {
		return labelParentesis2;
	}

	/**
	 * @param labelParentesis2 the labelParentesis2 to set
	 */
	public void setLabelParentesis2(JLabel labelParentesis2) {
		this.labelParentesis2 = labelParentesis2;
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
	 * @return the txtNumero1
	 */
	public JTextField getTxtNumero1() {
		return txtNumero1;
	}

	/**
	 * @param txtNumero1 the txtNumero1 to set
	 */
	public void setTxtNumero1(JTextField txtNumero1) {
		this.txtNumero1 = txtNumero1;
	}

	/**
	 * @return the labelDivisor
	 */
	public JLabel getLabelDivisor() {
		return labelDivisor;
	}

	/**
	 * @param labelDivisor the labelDivisor to set
	 */
	public void setLabelDivisor(JLabel labelDivisor) {
		this.labelDivisor = labelDivisor;
	}

	/**
	 * @return the txtNumero2
	 */
	public JTextField getTxtNumero2() {
		return txtNumero2;
	}

	/**
	 * @param txtNumero2 the txtNumero2 to set
	 */
	public void setTxtNumero2(JTextField txtNumero2) {
		this.txtNumero2 = txtNumero2;
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
	 * @return the panelAll
	 */
	public JPanel getPanelAll() {
		return panelAll;
	}

	/**
	 * @param panelAll the panelAll to set
	 */
	public void setPanelAll(JPanel panelAll) {
		this.panelAll = panelAll;
	}

	/**
	 * @return the cOMANDO_CB
	 */
	public String getCOMANDO_CB() {
		return COMANDO_CB;
	}

}
