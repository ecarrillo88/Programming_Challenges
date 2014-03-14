/*
 * PC/UVA IDs: 110901/10004
 * PC: Accepted / UVA: Accepted
 * Run Time: 0.255
 */

package tema09;

import java.util.*;

public class Bicoloring {
	private static Graph grafo;

	private static String colorearVertices() {
		boolean[] visitados = new boolean[grafo.getNumVertices()];
		// Los vertices se van a ir agregando a la lista en orden BFS
		Vector<Vertice> listaBFS = new Vector<Vertice>();
		Vertice vertice = grafo.getVertice(0); // raiz
		vertice.setColor("Negro"); // Color inicial
		listaBFS.add(vertice); // Añadimos el primer vertice
		visitados[0] = true;
		Vector<Arista> aristas;
		for (int i = 0; i < grafo.getNumVertices(); i++) {
			vertice = listaBFS.get(i);
			aristas = vertice.getAristas();
			for (int j = 0; j < aristas.size(); j++) {
				Vertice adyacente = aristas.get(j).getDestino();
				if (!visitados[adyacente.getId()]) {
					if (vertice.getColor().equals("Negro")) {
						adyacente.setColor("Rojo");
					} else {
						adyacente.setColor("Negro");
					}
					listaBFS.add(adyacente);
					visitados[adyacente.getId()] = true;
				} else {
					if (vertice.getColor().equals(adyacente.getColor())) {
						return "NOT BICOLORABLE.";
					}
				}
			}
		}
		return "BICOLORABLE.";
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int numVertices = 0, numArcos = 0;
		while (entrada.hasNext()) {
			numVertices = entrada.nextInt();
			if (numVertices == 0) {
				break;
			}

			numArcos = entrada.nextInt();

			grafo = new Graph(false); // Grafo no dirigido

			for (int i = 1; i <= numVertices; i++) {
				grafo.insertar(new Vertice(i, i + ""));
			}

			for (int i = 0; i < numArcos; i++) {
				int o = entrada.nextInt(); // Origen
				int d = entrada.nextInt(); // Destino
				grafo.conectar(grafo.getVertice(o), grafo.getVertice(d), false);
			}

			String resultado = colorearVertices();
			System.out.println(resultado);
		}
	}

}

class Graph {
	protected Vector<Vertice> vertices;
	protected Vector<Arista> aristas;
	protected boolean dirigido;

	public Graph(boolean directed) {
		vertices = new Vector<Vertice>();
		aristas = new Vector<Arista>();
		this.dirigido = directed;

	}

	public int getNumVertices() {
		return vertices.size();
	}

	public int getNumAristas() {
		return aristas.size();
	}

	public Vertice getVertice(int index) {
		return vertices.get(index);
	}

	public boolean esDirigido() {
		return dirigido;
	}

	public void reset() // InitializeGraph
	{
		vertices.clear();
		aristas.clear();
	}

	public void insertar(Vertice v) {
		v.setId(vertices.size());
		vertices.add(v);
	}

	public void insertar(Arista e, boolean directed) {
		aristas.add(e);

		if (!directed) {
			Arista other = new Arista(e.getOrigen(), e.getDestino());
			aristas.add(other);
			e.getDestino().add(other);
		}
	}

	public void conectar(Vertice o, Vertice d, boolean dirigido) {
		Arista e = new Arista(o, d);
		aristas.add(e);
		o.add(e);

		if (!dirigido) {
			e = new Arista(d, o);
			aristas.add(e);
			d.add(e);
		}
	}

}

class Vertice {
	protected int id; // Used as index inside the graph.
	protected String etiqueta;
	protected Vector<Arista> aristas;
	protected String color;

	public Vertice(int id, String label) {
		this.id = id;
		this.etiqueta = label;
		this.aristas = new Vector<Arista>();
	}

	public int getId() {
		return id;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Arista getArista(int i) {
		return aristas.get(i);
	}

	public Vector<Arista> getAristas() {
		return aristas;
	}

	public void add(Arista e) {
		aristas.add(e);
	}

	public int getOutDegree() {
		return aristas.size();
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

	public String toString() {
		return String.format("(%d) <%s>", id, etiqueta != null ? etiqueta : "");
	}
}

class Arista {
	protected Vertice origen;
	protected Vertice destino;

	public Arista(Vertice origen, Vertice destino) {
		this.origen = origen;
		this.destino = destino;
	}

	public Arista(Vertice origin, Vertice destination, String label) {
		this.origen = origin;
		this.destino = destination;
	}

	public Vertice getOrigen() {
		return origen;
	}

	public Vertice getDestino() {
		return destino;
	}

	public String toString() {
		return origen.toString() + " --> " + destino.toString();
	}
}
