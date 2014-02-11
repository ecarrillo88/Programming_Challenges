package tema04;

import java.util.Scanner;

public class StacksOfFlapjacks {
	private static int[] stack;

	// Algoritmo basado en SELECTION SORT O(n^2)
	
	private static void voltearTortitas() {
		int fin = stack.length - 1;
		while (!estaOrdenado()) {
			int max = 0;
			int posMax = 0;
			for (int i = 1; i < fin; i++) {
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

	/*
	 * Pruebas 1 5 2 3 4 | 4 1 2 0 || 5 2 1 4 3 6 | 1 1 2 5 3 4 4 5 0
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (scan.hasNextLine()) {
			// Mediante split almacenamos la linea en un array auxiliar
			String[] aux = scan.nextLine().split(" ");

			stack = new int[aux.length + 1];

			// Convertimos cada elemento del array auxiliar a Integer
			for (int i = 1; i < stack.length; i++) {
				stack[i] = Integer.parseInt(aux[i - 1]);
			}

			voltearTortitas();
			System.out.println("yaaaa");
		}

		scan.close();
	}

}
