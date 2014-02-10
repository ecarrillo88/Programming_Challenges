package tema04;

import java.util.Comparator;
import java.util.Scanner;

public class StacksOfFlapjacks {

	// Algoritmo de ordenacion SELECTION SORT O(n^2)
	public static void volteo(int a[], int from, int to) {
		for (int i = from; i < to; i++) {
			int k = i;
			for (int j = i + 1; j < to; j++) {
				if (a[j] > a[k]) {
					k = j;
				}
			}
			int aux = a[i];
			a[i] = a[k];
			a[k] = aux;
			
		}
	}
	
	private static void swap( Object a[], int i, int j )
    {
        Object aux = a[i]; a[i] = a[j]; a[j] = aux;
    }

	private static boolean estaOrdenado(int[] arrayTortitas) {
		for (int i = 1; i < arrayTortitas.length; i++) {
			if (arrayTortitas[i - 1] > arrayTortitas[i]) {
				return false;
			}
		}
		return true;
	}

	private static void voltearTortitas(int[] arrayTortitas) {
		while (!estaOrdenado(arrayTortitas)) {
			// Buscamos el elemento mayor del aray para
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < arrayTortitas.length; i++) {
				if (arrayTortitas[i] > max) {
					max = arrayTortitas[i];
				}
			}
		}
	}

	/*Pruebas
	 * 1 5 2 3 4 
	 * 4 1 2 0
	 * 5 2 1 4 3 6 
	 * 1 1 2 5 3 4 4 5 0
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (scan.hasNext()) {
			// Mediante split almacenamos la linea en un array auxiliar
			String[] aux = scan.nextLine().split(" ");

			int[] arrayTortitas = new int[aux.length];

			// Convertimos cada elemento del array auxiliar a Integer
			for (int i = 0; i < aux.length; i++) {
				arrayTortitas[i] = Integer.parseInt(aux[i]);
			}

			voltearTortitas(arrayTortitas);
		}

		scan.close();
	}

}
