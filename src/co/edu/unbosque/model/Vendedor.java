package co.edu.unbosque.model;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * Clase que representa al vendedor (viajante) que tiene que buscar el camino minimo para recorrer
 * todas las ciudades.
 * @author Eddy Cuizaguana Cerpa
 *
 */
public class Vendedor {
	 int [][] ciudad; // matriz bidimensional que representa la ciudad
	 int solMejor []; // almacenamos las ciudades por cuya suma (coste del camino) sea la minima
	 double costeMejor;//alamacenamos el coste mejor
	 int n; //numero de ciudades
	 int cantDnodo; // cantidad de nodos expandidos
	 int [][]ciudadReducida; // representa la ciudad reducida, es utilizada solo par la estumacion "muy ajustada"
	 private Estimacion tipo; // Definimos el tipo de estimacion, el mismo se hara desde el main
	 
	public Vendedor(int[][] ciuda, int n,Estimacion tip ) {
		ciudad = ciuda;
		solMejor = new int [n];
		costeMejor = 0;
		this.n = n;
		cantDnodo = 0;
		tipo = tip;
	}

	private int loadCiudadReducida(){
		ciudadReducida = copiarCiudad(ciudad);
		return  reduceMatrizPorFila(this.ciudadReducida) + reduceMatrizPorColumna(this.ciudadReducida);
	}
	public static int[][] copiarCiudad(int[][] ciudad2) {
		if (ciudad2 == null)
			return null;
		int nuevaCiudad [][] = new int [ciudad2.length][ciudad2.length];
		for(int i = 0; i < ciudad2.length; i++ )
			for (int j = 0; j < ciudad2.length; j++) {
				nuevaCiudad[i][j] = ciudad2[i][j];
			}
		return nuevaCiudad;
	}

	private int reduceMatrizPorColumna(int [][]ciudad_) {
		// TODO Auto-generated method stub
		int totalReduccion = 0;
		int i = 0;
		int j = 0;
		for (; j < n; j++){
			int minimo = Integer.MAX_VALUE;
			int k = n-1;
			for (; i < n ; i++,k--){
				if (i!=j){
					if (ciudad_[i][j] < minimo)
						minimo = ciudad_[i][j];
					
					if (ciudad_[k][j] < minimo)
						minimo = ciudad_[k][j];
				}
			}
			
			if (minimo !=Integer.MAX_VALUE){
				if (minimo != 0)
					for (int p = 0; p < n ; p++){
						if (j!=p){
							if (ciudad_[p][j] - minimo >=0){
								if (ciudad_[p][j] != Integer.MAX_VALUE)
								ciudad_[p][j] = ciudad_[p][j] - minimo;
							}
							else 
								ciudad_[p][j]= 0;
						}
					}
				totalReduccion += minimo;
			}
			i = 0;
			
		}
		return totalReduccion;
	}

	private int reduceMatrizPorFila(int [][]ciudad_) {
		int totalReduccion = 0;
		int i = 0;
		int j = 0;
		for (; i < n; i++){
			int minimo = Integer.MAX_VALUE;
			int k = n-1;
			for (; j < n ; j++,k--){
				if (i!=j){
					if (ciudad_[i][j] < minimo)
						minimo = ciudad_[i][j];
					
					if (ciudad_[i][k] < minimo)
						minimo = ciudad_[i][k];
				}
			}
			if (minimo !=Integer.MAX_VALUE){
				if (minimo != 0)
					for (int p = 0; p < n ; p++){
						if (i!=p){
							if (ciudad_[i][p] - minimo >=0){
								if (ciudad_[i][p] != Integer.MAX_VALUE)
									ciudad_[i][p] = ciudad_[i][p] - minimo;
							}
							else 
								ciudad_[i][p]= 0;
						}
					}
			totalReduccion += minimo;
			}
			j = 0;
		}
		return totalReduccion;
	}

	public void inciaVenta(){
		Node x = new Node(n);
		Node y = new Node(n);
		Comparator<Node> comparator = new NodoCosteEstimadoComparador();
        PriorityQueue<Node> c = 
        					new PriorityQueue<Node>(10, comparator);
        int valEstimacion = 0;
        int minG = 0;
        if (Estimacion.MUYAJUSTADA == tipo)
        	valEstimacion = loadCiudadReducida();
        else if (Estimacion.AJUSTADA == tipo)
        	minG = minimoGrafo();
        
        y.k = 0;
        y.sol[0] = 0;
        y.usados[0] = true;
        for (int i = 1; i < n; i++){
        	y.usados[i] = false;
        }
        y.coste = 0;
        if (Estimacion.MUYAJUSTADA == tipo){
	        y.ciudadReducida = copiarCiudad(ciudadReducida);
	        y.costeEstimado = valEstimacion;
        }
        else if (Estimacion.AJUSTADA == tipo)
        	y.costeEstimado = n* minG;
        
        
       
        c.add(y.clone2());
        //fin cantDnodo raiz
        costeMejor = Integer.MAX_VALUE;// +infinito
        while ((!c.isEmpty()) && c.element().costeEstimado < costeMejor){
        	y = c.element();
        	c.remove();
        	//generamos los hijos de y
        	x.k = y.k + 1;
        	x.sol = (y.sol).clone();
        	x.usados = (y.usados).clone();
        	if (Estimacion.MUYAJUSTADA == tipo)
        		x.ciudadReducida = copiarCiudad(y.ciudadReducida);
        	int anterior = x.sol[x.k-1];
        	
        	for(int vertice = 1; vertice < n; vertice++){
        		//condicion de factibilidad
        		// si no a sido usado el verice por el cual vamos y el y si existe una arista desde
        		//el vertice anteriro al vertice por el cual vamos --> Nodo infactible
        		if ( (!x.usados[vertice]) && gvEstaArista(anterior,vertice)){
        			x.sol[x.k] = vertice;
        			x.usados[vertice]= true;//maracage
        			x.coste = y.coste + ciudad[anterior][vertice];
        			
        			x.ciudadReducida = copiarCiudad(y.ciudadReducida);
        			if (x.k == n-1){//entramos si hemos recorrido desde el verice k al vertice n, pero hay que ver si existe camino del vertice n al vertice 1, que en nuestro caso es el 0(cero)
        				if (gvEstaArista(x.sol[n-1],0) //verificamos si hay camino del vertice n al vertice 1
        						&& ((x.coste + ciudad[x.sol[n-1]][0]) < costeMejor)){ // y ademas si el coste que llevamos + el valor del camino antes
        																				//visto mejora al coste de la mejor solucion
        					
        					solMejor = (x.sol).clone();// lo guardamos como mejor solucion
        					costeMejor = x.coste + ciudad[x.sol[n-1]][0]; //actualizamos el coste mejor
        				}			
        			} //k != n --> tupla parcial
        			else{
        			
        				if (Estimacion.MUYAJUSTADA == tipo)
        					x.costeEstimado = costeEstimado2(x, y, anterior, vertice);
        				else if (Estimacion.AJUSTADA == tipo)
        					//x.coste(coste del camino actual) + minG (camino minimo de todo el grafo) * lo que nos queda por recorrer
        					x.costeEstimado = x.coste + (n - x.k+1) * minG;    	
        				if (x.costeEstimado < costeMejor){
        					Node nod = (Node) x.clone2();
        					c.add( nod);
        					
        				}
        			
        			}
        			x.usados[vertice] = false;	//desmarcage
        			cantDnodo ++;
        		}//fin cantDnodo infactible
        	}
        }
    }

	//Metodo que dado 2 ciudades nos devolvera TRUE O FASE si existe camino entre ellas
	private boolean gvEstaArista(int anterior, int vertice) {
		return (ciudad[anterior][vertice] < Integer.MAX_VALUE);
	}
	
	//Obtiene la arista minima del grafo
	private int minimoGrafo() {
		int minimo = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n ; j++ )
				if (i != j && gvEstaArista(i,j) &&  ciudad [i][j] < minimo)
					minimo = ciudad[i][j];
		}
		return minimo;
	}
	
	//---- calculo del coste estimdo________________________________________________________
	private double costeEstimado2(Node nodoX, Node nodoY, int i, int j){
		//cambiamos todos los elementos de la fila i, columna j, esto evitara incluir
		//caminos que salgan de i o lleguen a j
		for (int k = 0; k < n ; k++){
			nodoX.ciudadReducida[i][k] = Integer.MAX_VALUE;
		//for (int k = 0; k < n ; k++)
			nodoX.ciudadReducida[k][j] = Integer.MAX_VALUE;
		}
		//lo realizamos para no volver de una ciudad k a la ciudad origen
		nodoX.ciudadReducida[j][0] = Integer.MAX_VALUE;
		//valor real del camino evaluado
		int a = ciudadReducida[i][j];
		//reducimos la matriz por fila, nos devolverá la suma de todoas las filas de dicha reduccion,
		//en caso de no poder reducirse devolvera 0
		double b = reduceMatrizPorFila(nodoX.ciudadReducida) ;
		//reducimos la matriz por fila, nos devolverá la suma de todoas las columnas de dicha reduccion,
		//en caso de no poder reducirse devolvera 0
		double c = reduceMatrizPorColumna(nodoX.ciudadReducida);
		double costeEstimadoNodoPadre = nodoY.costeEstimado;
		return costeEstimadoNodoPadre + a+b+c;		
	}
	//________________________________________________________________________
	public int getNodo() {
		return cantDnodo;
	}
	public double getCosteMejor() {
		return costeMejor;
	}
	public String getSolMejor() {
		String cad = "";
		for (int i = 0; i < n; i++){
			cad += ", " + Integer.toString(solMejor[i]);
		}
		return cad.replaceFirst(", ", "");
	}
	
	public int costeDelCaminoEncontrado(){
		int total = 0;
		int i = 0;
		int j = 0;
		for (int ii = 0; ii < n; ii++){
			 i = solMejor[ii];
			if (ii == n-1)
			 j = solMejor[0];
			else
				j = solMejor[ii + 1];
			total += ciudad[i][j];
			
		}
		return total;
	}
}
