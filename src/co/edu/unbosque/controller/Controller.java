/**
 * Paquete controller
 */
package co.edu.unbosque.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import co.edu.unbosque.model.Algoritmo;
import co.edu.unbosque.model.ExcepcionNumero;
import co.edu.unbosque.model.Vendedor;
import co.edu.unbosque.view.Vista;
import co.edu.unbosque.model.Estimacion;

/**
 * 
 * @author Jhoan Ricardo Cuevas Paniño, Robinson José Gutiérrez Solano, Omar
 *         Felipe Ladino Guezaguan
 *
 */
public class Controller implements ActionListener {

	private Vista vista;
	private Algoritmo algoritmo;
	
/**
 * Constructor de la clase controller.
 */
	public Controller() {
		vista = new Vista(this);
		algoritmo = new Algoritmo();
	}

	/**
	 * Se encarga de asignar los oyentes.
	 */
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(vista.getPanelBotones().getCOMANDO_FLOYD())) {
			vista.getSplitPane().setRightComponent(vista.getPanelFloyd());
		}
		if (comando.equals(vista.getPanelBotones().getCOMANDO_VIAJERO())) {
			vista.getSplitPane().setRightComponent(vista.getPanelViajero());
		}
		if (comando.equals(vista.getPanelBotones().getCOMANDO_MATRICES())) {
			vista.getSplitPane().setRightComponent(vista.getPanelProductoMatriz());
		}
		if (comando.equals(vista.getPanelBotones().getCOMANDO_TAREAS())) {
			vista.getSplitPane().setRightComponent(vista.getPanelTareas());
		}
		if (comando.equals(vista.getPanelBotones().getCOMANDO_BINOMIO())) {
			vista.getSplitPane().setRightComponent(vista.getPanelCoeficienteBinomial());
		}
		if (comando.equals(vista.getPanelProductoMatriz().getCOMANDO_CONFIRMAR())) {
			hallarProducto();
		}
		if (comando.equals(vista.getPanelCoeficienteBinomial().getCOMANDO_CB())) {
			hallarCoeficienteBinomial();
		}
		if (comando.equals(vista.getPanelViajero().getPanelSeleccionViajero().getCOMANDO_CONFIRMAR())) {

			try {
				String[] entradas = vista.getPanelViajero().getPanelSeleccionViajero().verificarEntradas();
				if (entradas[0].equals("0")) {

					vista.getPanelViajero().getPanelMatriz().limpiarPanel();
					algoritmo.verificarNumero(entradas[1]);
					int cantidadCiudades = Integer.parseInt(entradas[1]);
					String[] nombreCiudades = new String[cantidadCiudades + 1];
					boolean verificar = true;
					int i = 1;
					while (i <= cantidadCiudades) {
						nombreCiudades[i] = vista.pedirDato("Ingrese el nombre de la ciudad numero: " + i);
						if (nombreCiudades[i].equals("Accion Cancelada")) {
							vista.mostrarMensajeInformacion(nombreCiudades[i]);
							verificar = false;
							break;
						}
						i++;
					}
					if (verificar) {
						vista.getPanelViajero().getPanelMatriz().inicializarCompentes(cantidadCiudades + 1,
								cantidadCiudades + 1);
						JTextField[][] matriz = vista.getPanelViajero().getPanelMatriz().getTxtMatriz();
						matriz[0][0].setEnabled(false);
						for (int j = 1; j < cantidadCiudades + 1; j++) {
							matriz[0][j].setText(nombreCiudades[j]);
							matriz[0][j].setEnabled(false);
						}
						for (int j = 1; j < cantidadCiudades + 1; j++) {
							matriz[j][0].setText(nombreCiudades[j]);
							matriz[j][0].setEnabled(false);
						}
						for (int i2 = 1; i2 < cantidadCiudades + 1; i2++) {
							for (int j = 1; j < matriz.length; j++) {
								if (i2 == j) {
									matriz[i2][j].setText("0");
									matriz[i2][j].setEnabled(false);
								}

							}
						}
						vista.getPanelViajero().getPanelMatriz().setTxtMatriz(matriz);
						vista.getPanelViajero().getSplitPane().setRightComponent(vista.getPanelViajero().getPanel());
					}
				} else {
					vista.mostrarMensajeInformacion(entradas[1]);
				}
			} catch (ExcepcionNumero excepcion) {
				vista.mostrarMensajeAdvertencia(excepcion.getMessage());
			}
		}

		if (comando.equals(vista.getPanelFloyd().getPanelSeleccionFloyd().getCOMANDO_CONFIRMAR())) {

			try {

				String[] alCantidadNodos = vista.getPanelFloyd().getPanelSeleccionFloyd().verificarEntradas();

				if (alCantidadNodos[0].equals("0")) {

					vista.getPanelFloyd().getPanelMatriz().limpiarPanel();
					algoritmo.verificarNumero(alCantidadNodos[1]);
					int cantidadNodos = Integer.parseInt(alCantidadNodos[1]);

					vista.getPanelFloyd().getPanelMatriz().inicializarCompentes(cantidadNodos + 1, cantidadNodos + 1);
					JTextField[][] matriz = vista.getPanelFloyd().getPanelMatriz().getTxtMatriz();
					matriz[0][0].setEnabled(false);
					for (int j = 1; j < cantidadNodos + 1; j++) {
						matriz[0][j].setText("" + j);
						matriz[0][j].setEnabled(false);
					}
					for (int j = 1; j < cantidadNodos + 1; j++) {
						matriz[j][0].setText("" + j);
						matriz[j][0].setEnabled(false);
					}
					for (int i = 1; i < cantidadNodos + 1; i++) {
						for (int j = 1; j < matriz.length; j++) {
							if (i == j) {
								matriz[i][j].setText("0");
								matriz[i][j].setEnabled(false);
							}
						}
					}

					vista.getPanelFloyd().getPanelMatriz().setTxtMatriz(matriz);
					vista.getPanelFloyd().getSplitPane().setRightComponent(vista.getPanelFloyd().getPanel());

				} else {
					vista.mostrarMensajeInformacion(alCantidadNodos[1]);
				}

			} catch (ExcepcionNumero excepcion) {
				vista.mostrarMensajeAdvertencia(excepcion.getMessage());
			}

		}

		if (comando.equals(vista.getPanelFloyd().getCOMANDO_CONFIRMAR())) {
			hallarFloyd();
		}

		if (comando.equals(vista.getPanelViajero().getCOMANDO_CONFIRMAR())) {
			hallarViajero();
		}

		if (comando.equals(vista.getPanelTareas().getCOMANDO_CONFIRMAR())) {
			hallarTareas();
		}

	}
	
	/**
	 * Se encarga de obtener la forma más óptima de efectuar las multiplicaciones de las matrices teniendo
	 * en cuenta el número de procesos a realizar.
	 */
	
	public void hallarProducto() {
		try {
			String[] entradas = vista.getPanelProductoMatriz().verificarEntradas();
			if (entradas[0].equals("0")) {
				algoritmo.verificarNumero(entradas[1]);
				int numMatriz = Integer.parseInt(entradas[1]);
				int[] filas = new int[numMatriz + 1];
				int[] columnas = new int[numMatriz];
				int k = 0;
				boolean verificar = true;
				while (k < numMatriz) {
					entradas[0] = vista.pedirDato("Ingrese el número de filas de la matriz numero " + (k + 1));
					algoritmo.verificarNumero(entradas[0]);
					if (entradas[0].equals("Accion Cancelada")) {
						vista.mostrarMensajeInformacion(entradas[0]);
						verificar = false;
						break;
					}
					filas[k] = Integer.parseInt(entradas[0]);
					entradas[0] = vista.pedirDato("Ingrese el número de columnas de la matriz numero " + (k + 1));
					algoritmo.verificarNumero(entradas[0]);
					if (entradas[0].equals("Accion Cancelada")) {
						vista.mostrarMensajeInformacion(entradas[0]);
						verificar = false;
						break;
					}
					columnas[k] = Integer.parseInt(entradas[0]);
					k++;
				}

				if (verificar) {

					filas[columnas.length] = columnas[columnas.length - 1];
					int[][] m = new int[filas.length][filas.length];
					int[][] s = new int[filas.length][filas.length];
					int resultado = algoritmo.matrixChain(filas, m, s);
					String mensaje = "";
					mensaje = algoritmo.traceback(1, filas.length - 1, s, mensaje);

					vista.mostrarMensajeAdvertencia("El numero de operaciones mas óptimo es: " + resultado
							+ "\nLa forma de multiplicar las matrices es: " + mensaje);
				}

			} else {
				vista.mostrarMensajeAdvertencia(entradas[1]);
			}

		} catch (ExcepcionNumero excepcion) {
			vista.mostrarMensajeAdvertencia(excepcion.getMessage());
		}
	}
	
	/**
	 * Busca hallar una matriz con los recorridos más cortos entre todos los nodos de un grafo,
	 */

	public void hallarFloyd() {

		try {
			if (!"".equals(vista.getPanelFloyd().getPanelSeleccionFloyd().getTxtNumNodos().getText())) {
				JTextField matriz[][] = vista.getPanelFloyd().getPanelMatriz().getTxtMatriz();
				int matrizRecorridos[][] = new int[matriz.length - 1][matriz.length - 1];
				for (int i = 1; i < matriz.length; i++) {
					for (int j = 1; j < matriz.length; j++) {
						if (!matriz[i][j].getText().equals("")) {
							algoritmo.verificarNumero2(matriz[i][j].getText());
							matrizRecorridos[i - 1][j - 1] = Integer.parseInt(matriz[i][j].getText());
						} else {
							matrizRecorridos[i - 1][j - 1] = 0;
						}
					}
				}
				for (int i = 0; i < matrizRecorridos.length; i++) {
					for (int j = 0; j < matrizRecorridos.length; j++) {
						if (matrizRecorridos[i][j] == 0) {
							matrizRecorridos[i][j] = 99999999;
						}
					}
				}
				int matrizRecorridosCortos[][] = algoritmo.rutasCortas(matrizRecorridos);
				vista.getPanelFloyd().getPanelMatriz1().limpiarPanel();
				vista.getPanelFloyd().getPanelMatriz1().inicializarCompentes2(matrizRecorridos.length + 1,
						matrizRecorridos.length + 1);
				JLabel[][] matrizResultante = vista.getPanelFloyd().getPanelMatriz1().getLabelMatriz();
				Font font = new Font("SansSerif", Font.BOLD, 30);
				for (int i = 1; i < matrizResultante.length; i++) {
					matrizResultante[0][i].setText("" + i);
					matrizResultante[0][i].setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
					matrizResultante[0][i].setFont(font);
					matrizResultante[0][i].setForeground(Color.red);
					matrizResultante[0][i].setHorizontalAlignment(SwingConstants.CENTER);
					matrizResultante[0][i].setVerticalAlignment(SwingConstants.CENTER);
				}
				for (int i = 1; i < matrizResultante.length; i++) {
					matrizResultante[i][0].setText("" + i);
					matrizResultante[i][0].setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
					matrizResultante[i][0].setFont(font);
					matrizResultante[i][0].setForeground(Color.red);
					matrizResultante[i][0].setHorizontalAlignment(SwingConstants.CENTER);
					matrizResultante[i][0].setVerticalAlignment(SwingConstants.CENTER);
				}
				for (int i = 1; i < matrizResultante.length; i++) {
					for (int j = 1; j < matrizResultante.length; j++) {
						if (i == j) {
							matrizResultante[i][j].setText("-");
							matrizResultante[i][j].setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
							matrizResultante[i][j].setFont(font);
							matrizResultante[i][j].setHorizontalAlignment(SwingConstants.CENTER);
							matrizResultante[i][j].setVerticalAlignment(SwingConstants.CENTER);
						} else if (matrizRecorridosCortos[i - 1][j - 1] == 99999999) {
							matrizResultante[i][j].setText("∞");
							matrizResultante[i][j].setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
							matrizResultante[i][j].setFont(font);
							matrizResultante[i][j].setHorizontalAlignment(SwingConstants.CENTER);
							matrizResultante[i][j].setVerticalAlignment(SwingConstants.CENTER);
						} else {
							matrizResultante[i][j].setText("" + matrizRecorridosCortos[i - 1][j - 1]);
							matrizResultante[i][j].setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
							matrizResultante[i][j].setFont(font);
							matrizResultante[i][j].setHorizontalAlignment(SwingConstants.CENTER);
							matrizResultante[i][j].setVerticalAlignment(SwingConstants.CENTER);
						}
					}
				}
				vista.getPanelFloyd().getSplitPane().setRightComponent(vista.getPanelFloyd().getPanelMatriz1());
				vista.getPanelFloyd().getPanelMatriz1().setLabelMatriz(matrizResultante);

			} else {
				vista.mostrarMensajeInformacion("Ingrese el número de nodos");
			}

		} catch (ExcepcionNumero excepcion) {
			vista.mostrarMensajeAdvertencia(excepcion.getMessage());
		}
	}
	
	/**
	 * Se encarga de hallar la forma más optima de recorrer un grafo y que dicho recorrido
	 * Inicie y finalice en el mismo nodo.
	 */

	public void hallarViajero() {
		try {
			if (!"".equals(vista.getPanelViajero().getPanelSeleccionViajero().getTxtNumCiudad().getText())) {
				JTextField matriz[][] = vista.getPanelViajero().getPanelMatriz().getTxtMatriz();
				String[] ciudades = new String[matriz.length];
				for (int i = 0; i < matriz.length; i++) {
					ciudades[i] = matriz[0][i].getText();
				}
				int matrizRecorridos[][] = new int[matriz.length - 1][matriz.length - 1];
				for (int i = 1; i < matriz.length; i++) {
					for (int j = 1; j < matriz.length; j++) {
						if (!matriz[i][j].getText().equals("")) {
							algoritmo.verificarNumero(matriz[i][j].getText());
							matrizRecorridos[i - 1][j - 1] = Integer.parseInt(matriz[i][j].getText());
						} else {
							matrizRecorridos[i - 1][j - 1] = Integer.MAX_VALUE;
						}
					}
				}
				for (int i = 0; i < matrizRecorridos.length; i++) {
					for (int j = 0; j < matrizRecorridos.length; j++) {
						if (i != j && matrizRecorridos[i][j] == 0) {
							matrizRecorridos[i][j] = Integer.MAX_VALUE;
						}
					}
				}

				Vendedor vendedor = new Vendedor(matrizRecorridos, ciudades.length - 1, Estimacion.AJUSTADA);
				vendedor.inciaVenta();
				if (vendedor.getCosteMejor() < 99999999) {
					vista.mostrarMensajeInformacion("Coste mejor " + vendedor.getCosteMejor());
					String camino = "";
					String[] solucionMejor = vendedor.getSolMejor().split(",");
					for (int i = 0; i < solucionMejor.length; i++) {
						camino += ciudades[Integer.parseInt(solucionMejor[i]) + 1] + ",";
					}
					vista.mostrarMensajeInformacion("Mejor ruta " + camino);
				} else {
					vista.mostrarMensajeInformacion("No es posible calcular la ruta");
				}

			} else {
				vista.mostrarMensajeInformacion("Ingrese el número de ciudades");
			}
		} catch (ExcepcionNumero excepcion) {
			vista.mostrarMensajeAdvertencia(excepcion.getMessage());
		}
	}
	
	/**
	 * Determina el número de subconjuntos de tamaño k que se pueden crear a partir de un conjunto n
	 */

	public void hallarCoeficienteBinomial() {

		try {
			String[] entradas = vista.getPanelCoeficienteBinomial().verificarEntradas();
			if (entradas[0].equals("0")) {
				String n = entradas[1];
				algoritmo.verificarNumero(n);
				String k = entradas[2];
				algoritmo.verificarNumero(k);
				int resultado = algoritmo.coefBin(Integer.parseInt(n), Integer.parseInt(k));
				vista.getPanelCoeficienteBinomial().getTxtNumero1().setText("");
				vista.getPanelCoeficienteBinomial().getTxtNumero2().setText("");
				vista.mostrarMensajeInformacion("" + resultado);

			} else {
				vista.mostrarMensajeAdvertencia(entradas[1]);
			}
		} catch (ExcepcionNumero excepcion) {
			vista.mostrarMensajeAdvertencia(excepcion.getMessage());
		} catch (Exception excepcion2) {
			vista.mostrarMensajeError("Lo siento se ha presentado un error");
		}
	}
	
	/**
	 * consiste en representar el número más óptimo de tareas que se pueden realizar en n días.
	 */

	public void hallarTareas() {
		try {
			String[] entradas = vista.getPanelTareas().verificarEntradas();
			if (entradas[0].equals("0")) {
				algoritmo.verificarNumero(entradas[1]);
				algoritmo.verificarNumero(entradas[2]);
				int dias = Integer.parseInt(entradas[1]);
				int tareas = Integer.parseInt(entradas[2]);
				int[] tareasAlta = new int[tareas];
				int[] tareasBaja = new int[tareas];
				boolean verificar = true;
				int k = 0;
				while (k < tareas) {
					entradas[0] = vista.pedirDato("Ingrese el peso de la tarea de alto esfuezo número " + (k + 1));
					algoritmo.verificarNumero(entradas[0]);
					if (entradas[0].equals("Accion Cancelada")) {
						vista.mostrarMensajeInformacion(entradas[0]);
						verificar = false;
						break;
					}
					tareasAlta[k] = Integer.parseInt(entradas[0]);
					k++;
				}
				k = 0;
				while (k < tareas) {
					entradas[0] = vista.pedirDato("Ingrese el peso de la tarea de bajo esfuezo número " + (k + 1));
					algoritmo.verificarNumero(entradas[0]);
					if (entradas[0].equals("Accion Cancelada")) {
						vista.mostrarMensajeInformacion(entradas[0]);
						verificar = false;
						break;
					}
					tareasBaja[k] = Integer.parseInt(entradas[0]);
					k++;
				}
				if (verificar) {

					int resultado = algoritmo.asigTareasf(tareasAlta, tareasBaja, dias);
					vista.mostrarMensajeAdvertencia(
							"El numero de tareas optimo que se pueden realizar en " + dias + " dias es: " + resultado);
				}
			} else {
				vista.mostrarMensajeAdvertencia(entradas[1]);
			}
		} catch (ExcepcionNumero excepcion) {
			vista.mostrarMensajeAdvertencia(excepcion.getMessage());
		}
	}

}
