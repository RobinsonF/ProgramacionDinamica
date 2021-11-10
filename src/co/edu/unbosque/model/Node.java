package co.edu.unbosque.model;

/**
 * 
 * @author Eddy Cuizaguana Cerpa 
 *
 */
public class Node implements Cloneable{

	int sol []; //tupla de soluciones
	int k; // indica por donde vamos en la tupla
	double coste;	//suma de las aristas que hemos cogido
	double costeEstimado;//prioridad (n-k)*minGrafo()
	boolean usados [];// nos indica los vertices utilizados
	//----
	int [][]ciudadReducida;//solo se tendra encuenta para la estimcaion "MUYAJUSTADA"
	
	// contructora de un nodo, n indica la catidad de ciudades
	public Node(int n) {
		sol = new int [n];
		k = 0;
		coste = 0;
		costeEstimado = 0;
		usados = new boolean [n];
		ciudadReducida = new int[n][n];
	}
	
	// constructora de un nodo, la utilizamos para poder realizar una copia
	public Node (int[]solu,int k_ ,double cost, double costEst, boolean [] usad,int[][]ciudadReducid ){
		sol = solu;
		coste = cost;
		costeEstimado = costEst;
		usados = usad;
		k = k_;
		ciudadReducida = ciudadReducid;
	}
	
	// Metodo encargado de clonar un nodo
	public Node clone2(){
		Node clone = new Node(this.sol.clone(),this.k,this.coste, this.costeEstimado,this.usados.clone(),Vendedor.copiarCiudad(this.ciudadReducida));
		return clone;
	}
}
