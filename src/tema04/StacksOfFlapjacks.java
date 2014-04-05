/*
 * PC/UVA IDs: 110402/120
 * PC: Wrong Answer (Don't judge correctly) / UVA: Accepted.
 * Run Time: 0.798
 */

package tema04;

import java.util.ArrayList;
import java.util.Scanner;

public class StacksOfFlapjacks {
	private static int[] stack;
	private static ArrayList<Integer> volteos;

	// Algoritmo basado en SELECTION SORT O(n^2)
	private static void ordenarTortitas() {
		// Indica hasta que posicion estan ordenadas las tortitas
		int fin = stack.length - 1;
		while (!estaOrdenado()) {
			int max = 0;
			int posMax = 0;
			for (int i = 1; i <= fin; i++) {
				if (stack[i] > max) {
					max = stack[i];
					posMax = i;
				}
			}
			volteo(posMax);
			volteo(fin);
			fin--;
		}
	}

	private static void volteo(int fin) {
		int numCambios = (fin / 2);
		if (numCambios != 0) {
			// La torre de tortitas esta al reves ya que el primer elemento en
			// realidad es el ultimo en la torre y al guardar la posicion de
			// volteo hay que calcular la posicion invertida en el array
			volteos.add((stack.length - 1 - fin) + 1);
		}

		int aux, i = 1, j = fin;
		while (numCambios > 0) {
			aux = stack[i];
			stack[i] = stack[j];
			stack[j] = aux;
			i++;
			j--;
			numCambios--;
		}
	}

	private static boolean estaOrdenado() {
		for (int i = 2; i < stack.length; i++) {
			if (stack[i - 1] > stack[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (scan.hasNextLine()) {
			volteos = new ArrayList<Integer>();

			// Mediante split almacenamos la linea en un array auxiliar
			String original = scan.nextLine();
			String[] aux = original.split(" ");

			// La posicion 0 no se va ha utilizar
			stack = new int[aux.length + 1];

			// Convertimos cada elemento del array auxiliar a Integer y lo
			// guardamos en stack
			for (int i = 1; i < stack.length; i++) {
				stack[i] = Integer.parseInt(aux[i - 1]);
			}

			ordenarTortitas();

			// Imprimimos por pantalla los resultados
			System.out.println(original);
			for (int i = 0; i < volteos.size(); i++) {
				System.out.print(volteos.get(i) + " ");
			}
			System.out.println("0");
		}

		scan.close();
	}

}
