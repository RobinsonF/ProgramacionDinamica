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

public class Controller implements ActionListener {

	private Vista vista;
	private Algoritmo algoritmo;

	public Controller() {
		vista = new Vista(this);
		algoritmo = new Algoritmo();
	}

	@Override
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
			System.out.println("Tareas");
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
					int i = 1;
					while (i <= cantidadCiudades) {
						nombreCiudades[i] = vista.pedirDato("Ingrese el nombre de la ciudad numero: " + i);
						i++;
					}
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

	}

	public void hallarProducto() {
		try {
			String[] entradas = vista.getPanelProductoMatriz().verificarEntradas();
			if (entradas[0].equals("0")) {
				algoritmo.verificarNumero(entradas[1]);
				int numMatriz = Integer.parseInt(entradas[1]);
				int[] filas = new int[numMatriz];
				int[] columnas = new int[numMatriz];
				int k = 0;
				while (k < numMatriz) {
					filas[k] = Integer
							.parseInt(vista.pedirDato("Ingrese el n�mero de filas de la matriz numero " + (k + 1)));
					columnas[k] = Integer
							.parseInt(vista.pedirDato("Ingrese el n�mero de columnas de la matriz numero " + (k + 1)));
					k++;
				}
			} else {
				vista.mostrarMensajeAdvertencia(entradas[1]);
			}

		} catch (ExcepcionNumero excepcion) {
			vista.mostrarMensajeAdvertencia(excepcion.getMessage());
		}
	}

	public void hallarFloyd() {

		try {
			if (!"".equals(vista.getPanelViajero().getPanelSeleccionViajero().getTxtNumCiudad().getText())) {
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

				boolean v = false;
				int inicio = 0;
				int fin = 0;
				do {
					String inicio2 = vista.pedirDato("Ingrese el punto de partida: ");
					if (!"Accion Cancelada".equals(inicio2)) {
						if (!"Por favor digite un valor".equals(inicio2)) {
							algoritmo.verificarNumero(inicio2);
							inicio = Integer.parseInt(inicio2);
							if (inicio <= (matriz.length - 1) && inicio >= 1) {
								v = true;
							}
							if (!v) {
								vista.mostrarMensajeInformacion("El punto de partida registrado no existe");
							}
						}
					} else {
						vista.mostrarMensajeInformacion(inicio2);
						break;
					}
				} while (!v);

				if (v) {
					v = false;

					do {
						String fin2 = vista.pedirDato("Ingrese el punto final: ");
						if (!"Accion Cancelada".equals(fin2)) {
							if (!"Por favor digite un valor".equals(fin2)) {
								algoritmo.verificarNumero(fin2);
								fin = Integer.parseInt(fin2);
								if (fin <= (matriz.length - 1) && fin >= 1) {
									v = true;
								}
								if (!v) {
									vista.mostrarMensajeInformacion("El punto final registrado no existe");
								}
							}
						} else {
							vista.mostrarMensajeInformacion(fin2);
							break;
						}
					} while (!v);
				}

				if (v) {

					if (inicio == fin) {
						vista.mostrarMensajeAdvertencia(
								"El recorrido es 0 porque el nodo de inicio y el nodo final son el mismo.");
					} else {
						int matrizRecorridosCortos[][] = algoritmo.rutasCortas(matrizRecorridos);
						if (matrizRecorridosCortos[inicio - 1][fin - 1] == 99999999) {
							vista.mostrarMensajeError("Los nodos no cuentan con alg�n camino que los una.");
						} else {
							vista.mostrarMensajeInformacion("El recorrido mas corto del punto " + inicio + " al punto "
									+ fin + " es: " + matrizRecorridosCortos[inicio - 1][fin - 1]);
						}
					}
				}
			} else {
				vista.mostrarMensajeInformacion("Ingrese el n�mero de nodos");
			}

		} catch (ExcepcionNumero excepcion) {
			vista.mostrarMensajeAdvertencia(excepcion.getMessage());
		}
	}

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
							matrizRecorridos[i - 1][j - 1] = 0;
						}
					}
				}
				for (int i = 0; i < matrizRecorridos.length; i++) {
					for (int j = 0; j < matrizRecorridos.length; j++) {
						if (i != j && matrizRecorridos[i][j] == 0) {
							matrizRecorridos[i][j] = 99999999;
						}
					}
				}

				Vendedor vendedor = new Vendedor(matrizRecorridos, ciudades.length - 1, Estimacion.AJUSTADA);
				vendedor.inciaVenta();
				vista.mostrarMensajeInformacion("Coste mejor " + vendedor.getCosteMejor());
				String camino = "";
				String[] solucionMejor = vendedor.getSolMejor().split(",");
				for (int i = 0; i < solucionMejor.length; i++) {
					camino += ciudades[Integer.parseInt(solucionMejor[i]) + 1] + ",";
				}
				vista.mostrarMensajeInformacion("Mejor ruta " + camino);
			} else {
				vista.mostrarMensajeInformacion("Ingrese el n�mero de ciudades");
			}
		} catch (ExcepcionNumero excepcion) {
			vista.mostrarMensajeAdvertencia(excepcion.getMessage());
		}
	}

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

}
