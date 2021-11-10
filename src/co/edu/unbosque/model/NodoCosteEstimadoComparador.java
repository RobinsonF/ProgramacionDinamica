package co.edu.unbosque.model;

import java.util.Comparator;

//Clase que implementa comparator, la misma es utilizada para poder ordenar
// los nodos en la cola por minimos 
/**
 * 
 * @author Eddy Cuizaguana Cerpa 
 *
 */
public class NodoCosteEstimadoComparador implements Comparator<Node> {

	@Override
	public int compare(Node x, Node y) {
		if (x.costeEstimado < y.costeEstimado)
			return -1;
		else if (x.costeEstimado > y.costeEstimado) 
			return 1;
		else return 0;
	}
}
