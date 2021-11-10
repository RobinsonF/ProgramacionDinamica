package co.edu.unbosque.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import co.edu.unbosque.model.Algoritmo;
import co.edu.unbosque.model.ExcepcionNumero;
import co.edu.unbosque.view.Vista;

public class Controller implements ActionListener {

	private Vista vista;
	private Algoritmo algoritmo;
	private String fila1 = "0";
	private String columna1 = "0";
	private String fila2 = "0";
	private String columna2 = "0";

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
		if (comando.equals(vista.getPanelProductoMatriz().getPanelSeleccion().getCOMMANDO_CONFIRMAR())) {
			try {
				String[] entradas = vista.getPanelProductoMatriz().getPanelSeleccion().verificarEntradas();
				if (entradas[0].equals("0")) {
					fila1 = entradas[1];
					algoritmo.verificarNumero(fila1);
					columna1 = entradas[2];
					algoritmo.verificarNumero(columna1);
					vista.getPanelProductoMatriz().getPanelMatriz1().limpiarPanel();
					vista.getPanelProductoMatriz().getPanelMatriz1().inicializarCompentes(Integer.parseInt(fila1),
							Integer.parseInt(columna1));
					vista.getPanelProductoMatriz().getSplitPane()
							.setRightComponent(vista.getPanelProductoMatriz().getPanelMatriz1());
				} else {
					vista.mostrarMensajeAdvertencia(entradas[1]);
				}
			} catch (ExcepcionNumero excepcion) {
				vista.mostrarMensajeAdvertencia(excepcion.getMessage());
			} catch (Exception excepcion2) {
				vista.mostrarMensajeError("Lo siento se ha presentado un error");
			}
		}
		if (comando.equals(vista.getPanelProductoMatriz().getPanelSeleccion2().getCOMANDO_CONFIRMAR2())) {
			try {
				String[] entradas = vista.getPanelProductoMatriz().getPanelSeleccion2().verificarEntradas();
				if (entradas[0].equals("0")) {
					fila2 = entradas[1];
					algoritmo.verificarNumero(fila2);
					columna2 = entradas[2];
					algoritmo.verificarNumero(columna2);
					vista.getPanelProductoMatriz().getPanelMatriz2().limpiarPanel();
					vista.getPanelProductoMatriz().getPanelMatriz2().inicializarCompentes(Integer.parseInt(fila2),
							Integer.parseInt(columna2));
					vista.getPanelProductoMatriz().getSplitPane2()
							.setRightComponent(vista.getPanelProductoMatriz().getPanelMatriz2());
				} else {
					vista.mostrarMensajeAdvertencia(entradas[1]);
				}
			} catch (ExcepcionNumero excepcion) {
				vista.mostrarMensajeAdvertencia(excepcion.getMessage());
			} catch (Exception excepcion2) {
				vista.mostrarMensajeError("Lo siento se ha presentado un error");
			}
		}
		if (comando.equals(vista.getPanelProductoMatriz().getCOMANDO_CONFIRMAR())) {
			hallarProducto();
		}
		if (comando.equals(vista.getPanelCoeficienteBinomial().getCOMANDO_CB())) {
			hallarCoeficienteBinomial();
		}
		if (comando.equals(vista.getPanelViajero().getPanelSeleccionViajero().getCOMANDO_CONFIRMAR())) {
			int cantidadCiudades = Integer
					.parseInt(vista.getPanelViajero().getPanelSeleccionViajero().getTxtNumCiudad().getText());
			String[] nombreCiudades = new String[cantidadCiudades + 1];
			int i = 1;
			while (i <= cantidadCiudades) {
				nombreCiudades[i] = vista.pedirDato("Ingrese el nombre de la ciudad numero: " + i);
				i++;
			}
			vista.getPanelViajero().getPanelMatriz().inicializarCompentes(cantidadCiudades + 1, cantidadCiudades + 1);
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
					if (i == j) {
						matriz[i2][j].setText("0");
						matriz[i2][j].setEnabled(false);
					}

				}
			}
			vista.getPanelViajero().getPanelMatriz().setTxtMatriz(matriz);
			vista.getPanelViajero().getSplitPane().setRightComponent(vista.getPanelViajero().getPanel());
		}
		if (comando.equals(vista.getPanelFloyd().getPanelSeleccionFloyd().getCOMANDO_CONFIRMAR())) {
			vista.getPanelFloyd().getPanelMatriz().limpiarPanel();
			int cantidadNodos = Integer
					.parseInt(vista.getPanelFloyd().getPanelSeleccionFloyd().getTxtNumNodos().getText());
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
		}
		if (comando.equals(vista.getPanelFloyd().getCOMANDO_CONFIRMAR())) {
			hallarFloyd();
		}

	}

	public void hallarProducto() {
		try {
			if (Integer.parseInt(fila1) != 0 && Integer.parseInt(fila2) != 0) {
				JTextField[][] datosMatriz1 = vista.getPanelProductoMatriz().getPanelMatriz1().getTxtMatriz();
				JTextField[][] datosMatriz2 = vista.getPanelProductoMatriz().getPanelMatriz2().getTxtMatriz();
				if (!vista.getPanelProductoMatriz().getPanelMatriz1().verificarEntradas(datosMatriz1)
						&& !vista.getPanelProductoMatriz().getPanelMatriz2().verificarEntradas(datosMatriz2)) {
					if (Integer.parseInt(columna1) == Integer.parseInt(fila2)) {
						int[][] matriz1 = new int[Integer.parseInt(fila1)][Integer.parseInt(columna1)];
						int[][] matriz2 = new int[Integer.parseInt(fila2)][Integer.parseInt(columna2)];

						for (int i = 0; i < Integer.parseInt(fila1); i++) {
							for (int j = 0; j < Integer.parseInt(columna1); j++) {
								String numero = (datosMatriz1[i][j].getText());
								algoritmo.verificarNumero(numero);
								matriz1[i][j] = Integer.parseInt(numero);
							}
						}
						for (int i = 0; i < Integer.parseInt(fila2); i++) {
							for (int j = 0; j < Integer.parseInt(columna2); j++) {
								String numero = (datosMatriz2[i][j].getText());
								algoritmo.verificarNumero(numero);
								matriz2[i][j] = Integer.parseInt(numero);
							}
						}
						int[][] resultado = new int[Integer.parseInt(fila1)][Integer.parseInt(columna2)];

						resultado = algoritmo.productoMatriz(matriz1, matriz2);

						vista.getPanelProductoMatriz().getPanelMatriz3().limpiarPanel();
						vista.getPanelProductoMatriz().getPanelMatriz3().inicializarCompentes2(Integer.parseInt(fila1),
								Integer.parseInt(columna2));
						JLabel[][] resultadoMatriz = vista.getPanelProductoMatriz().getPanelMatriz3().getLabelMatriz();
						Font font = new Font("SansSerif", Font.BOLD, 30);
						for (int i = 0; i < Integer.parseInt(fila1); i++) {
							for (int j = 0; j < Integer.parseInt(columna2); j++) {
								resultadoMatriz[i][j].setText(resultado[i][j] + "");
								resultadoMatriz[i][j].setBorder(BorderFactory.createLineBorder(new Color(5, 5, 5)));
								resultadoMatriz[i][j].setFont(font);
								resultadoMatriz[i][j].setHorizontalAlignment(SwingConstants.CENTER);
								resultadoMatriz[i][j].setVerticalAlignment(SwingConstants.CENTER);
							}
						}
						vista.getPanelProductoMatriz().getSplitPane3()
								.setRightComponent(vista.getPanelProductoMatriz().getPanelMatriz3());
						vista.getPanelProductoMatriz().getPanelMatriz3().setLabelMatriz(resultadoMatriz);
					} else {
						vista.mostrarMensajeAdvertencia(
								"Las matrices que acaba de ingresar no se pueden multiplicar, revise las dimensiones");
					}
				} else {
					vista.mostrarMensajeAdvertencia("Complete todos los campos");
				}
			} else {
				vista.mostrarMensajeAdvertencia("Ingrese las matrices a multiplicar");
			}
		} catch (ExcepcionNumero excepcion) {
			vista.mostrarMensajeAdvertencia(excepcion.getMessage());
		} catch (Exception excepcion2) {
			vista.mostrarMensajeError("Lo siento se ha presentado un error");
		}
	}

	public void hallarFloyd() {
		JTextField matriz[][] = vista.getPanelFloyd().getPanelMatriz().getTxtMatriz();
		int matrizRecorridos[][] = new int[matriz.length - 1][matriz.length - 1];
		for (int i = 1; i < matriz.length; i++) {
			for (int j = 1; j < matriz.length; j++) {
				if (!matriz[i][j].getText().equals("")) {
					matrizRecorridos[i - 1][j - 1] = Integer.parseInt(matriz[i][j].getText());
				} else {
					matrizRecorridos[i - 1][j - 1] = 0;
				}
			}
		}
		for (int i = 0; i < matrizRecorridos.length; i++) {
			for (int j = 0; j < matrizRecorridos.length; j++) {
				if(i!=j && matrizRecorridos[i][j]==0) {
					matrizRecorridos[i][j] = 99999999;
				}
			}
		}
		int inicio = Integer.parseInt(vista.pedirDato("Ingrese el punto de partida: "));
		int fin = Integer.parseInt(vista.pedirDato("Ingrese el punto final: "));
		if (inicio == fin) {
			vista.mostrarMensajeAdvertencia("El recorrido es 0 porque el nodo de inicio y el nodo final son el mismo.");
		} else {
			int matrizRecorridosCortos[][] = algoritmo.rutasCortas(matrizRecorridos);
			if( matrizRecorridosCortos[inicio - 1][fin - 1] ==99999999 ) {
				vista.mostrarMensajeError("Los nodos no cuentan con algún camino que los una.");
			}else {
				vista.mostrarMensajeInformacion("El recorrido mas corto del punto " + inicio + " al punto " + fin + " es: "
						+ matrizRecorridosCortos[inicio - 1][fin - 1]);
			}
			
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
