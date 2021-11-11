/**
 * Paquete modelo
 */
package co.edu.unbosque.model;


public class Node implements Cloneable{

	/**
	 * tupla de soluciones
	 */
	int sol [];
	/**
	 * indica por donde vamos en la tupla
	 */
	int k;
	/**
	 * suma de las aristas que hemos escogido
	 */
	double coste;
	/**
	 * prioridad (n-k)*minGrafo()
	 */
	double costeEstimado;
	/**
	 * nos indica los vertices utilizados
	 */
	boolean usados [];
	/**
	 * solo se tendra encuenta para la estimcaion "MUYAJUSTADA"
	 */
	int [][]ciudadReducida;
	
	/**
	 * contructora de un nodo, n indica la catidad de ciudades
	 * @param n
	 */
	public Node(int n) {
		sol = new int [n];
		k = 0;
		coste = 0;
		costeEstimado = 0;
		usados = new boolean [n];
		ciudadReducida = new int[n][n];
	}
	
	/**
	 * constructora de un nodo, la utilizamos para poder realizar una copia
	 * @param solu
	 * @param k_
	 * @param cost
	 * @param costEst
	 * @param usad
	 * @param ciudadReducid
	 */
	public Node (int[]solu,int k_ ,double cost, double costEst, boolean [] usad,int[][]ciudadReducid ){
		sol = solu;
		coste = cost;
		costeEstimado = costEst;
		usados = usad;
		k = k_;
		ciudadReducida = ciudadReducid;
	}
	
	/**
	 * Metodo encargado de clonar un nodo
	 * @return
	 */
	public Node clone2(){
		Node clone = new Node(this.sol.clone(),this.k,this.coste, this.costeEstimado,this.usados.clone(),Vendedor.copiarCiudad(this.ciudadReducida));
		return clone;
	}
}
