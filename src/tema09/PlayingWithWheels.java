/*
 * PC/UVA IDs: 110902/10067
 * PC: Accepted / UVA: Runtime Error
 * Run Time: 1.722
 */

package tema09;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PlayingWithWheels {
	private static int nodoInicial;
	private static int nodoFinal;
	private static Queue<Integer> colaBFS;
	private static boolean[] prohibidos;
	private static boolean[] visitados;
	private static int[] distancias;

	private static int buscarCamino() {
		int[] aux = new int[8];
		int dig1, dig2, dig3, dig4;
		int nodoActual = nodoInicial;
		colaBFS.add(nodoActual); // Añadimos el primer nodo a la lista
		distancias[nodoActual] = 0;

		// Generamos los nodos adyacentes y los añadimos a arrayBFS
		while (!colaBFS.isEmpty()) {
			nodoActual = colaBFS.poll();

			if (visitados[nodoActual] == true) {
				continue;
			}

			visitados[nodoActual] = true;

			if (nodoActual == nodoFinal) {
				return distancias[nodoFinal];
			}

			// Separamos los digitos del numero
			dig1 = nodoActual / 1000;
			dig2 = (nodoActual / 100) % 10;
			dig3 = (nodoActual / 10) % 10;
			dig4 = nodoActual % 10;

			// Obtenemos los 8 adyacentes del nodo actual
			aux[0] = ((dig1 + 1) % 10) * 1000 + dig2 * 100 + dig3 * 10 + dig4;
			aux[1] = (((dig1 - 1) + 10) % 10) * 1000 + dig2 * 100 + dig3 * 10 + dig4;
			aux[2] = dig1 * 1000 + ((dig2 + 1) % 10) * 100 + dig3 * 10 + dig4;
			aux[3] = dig1 * 1000 + (((dig2 - 1) + 10) % 10) * 100 + dig3 * 10 + dig4;
			aux[4] = dig1 * 1000 + dig2 * 100 + ((dig3 + 1) % 10) * 10 + dig4;
			aux[5] = dig1 * 1000 + dig2 * 100 + (((dig3 - 1) + 10) % 10) * 10 + dig4;
			aux[6] = dig1 * 1000 + dig2 * 100 + dig3 * 10 + ((dig4 + 1) % 10);
			aux[7] = dig1 * 1000 + dig2 * 100 + dig3 * 10 + (((dig4 - 1) + 10) % 10);

			// Guardamos los nodos que cumplan la condicion en arrayBFS
			for (int j = 0; j < aux.length; j++) {
				if (visitados[aux[j]] == false && prohibidos[aux[j]] == false) {
					colaBFS.add(aux[j]);
					distancias[aux[j]] = distancias[nodoActual] + 1;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int numCasos = entrada.nextInt();

		int dig1, dig2, dig3, dig4, numProhibidos;
		while (numCasos > 0) {
			// Inicializacion
			colaBFS = new LinkedList<Integer>();
			prohibidos = new boolean[10000];
			visitados = new boolean[10000];
			distancias = new int[10000];

			dig1 = entrada.nextInt();
			dig2 = entrada.nextInt();
			dig3 = entrada.nextInt();
			dig4 = entrada.nextInt();
			nodoInicial = dig1 * 1000 + dig2 * 100 + dig3 * 10 + dig4;

			dig1 = entrada.nextInt();
			dig2 = entrada.nextInt();
			dig3 = entrada.nextInt();
			dig4 = entrada.nextInt();
			nodoFinal = dig1 * 1000 + dig2 * 100 + dig3 * 10 + dig4;

			// Marcamos los nodos prohibidos en el array de prohibidos
			int indice;
			numProhibidos = entrada.nextInt();
			while (numProhibidos-- > 0) {
				dig1 = entrada.nextInt();
				dig2 = entrada.nextInt();
				dig3 = entrada.nextInt();
				dig4 = entrada.nextInt();
				indice = dig1 * 1000 + dig2 * 100 + dig3 * 10 + dig4;
				prohibidos[indice] = true;
			}

			System.out.println(buscarCamino());
		}
	}

}
