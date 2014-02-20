/*
 * PC/UVA IDs: 110607/10049
 * PC: Accepted / UVA: Accepted
 * Run Time: 0.209
 */

package tema06;

import java.util.Scanner;

public class SelfdescribingSequence {
	private static final int MAX_NUM = 673370;
	private static long[] array = new long[MAX_NUM];

	// Se encarga de calcular que valor de n es el ultimo antes de que el valor
	// de f(n) se incremente en uno y guarda dicho valor de n en una array cuyo
	// indice coincide con el valor de f(n) y su contenido con el valor del
	// ultimo n antes del cambio.
	private static void precalculo() {
		int k = 2;
		array[1] = 1;
		for (int i = 2; i < array.length; i++) {
			array[i] = array[i - 1] + k;
			if (i == array[k])
				k++;
		}
	}

	private static int busquedaDicotomica(long n, int inicio, int fin) {
		int pivote = (fin + inicio) / 2;
		if (fin - inicio == 1) {
			return fin;
		}

		if (array[pivote] > n) {
			return busquedaDicotomica(n, inicio, pivote);
		} else if (array[pivote] < n) {
			return busquedaDicotomica(n, pivote, fin);
		} else
			return pivote;
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		// Se precalcula una vez la sucesion y a partir de ahora solo se busca
		// el valor introducido por el usuario en el array con los resultados.
		precalculo();

		long n = entrada.nextLong();
		while (n != 0) {
			System.out.println(busquedaDicotomica(n, 0, array.length));
			n = entrada.nextLong();
		}
		entrada.close();
	}

}
