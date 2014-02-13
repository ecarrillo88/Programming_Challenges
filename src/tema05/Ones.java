/*
 * PC/UVA IDs: 110504/10127
 * PC: Accepted / UVA: Accepted
 * Run Time: 0.212
 */

package tema05;

import java.util.Scanner;

public class Ones {

	private static int numeroDeUnos(int numero) {
		int contador = 0;
		int suma = numero;

		while (suma != 0) {
			while (suma % 10 == 1) {
				suma /= 10;
				contador++;
			}

			if (suma != 0) {
				suma += numero;
			}
		}
		return contador;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (scan.hasNext()) {
			int numero = scan.nextInt();
			if (numero % 2 == 0 || numero % 5 == 0) {
				System.out.println("0");
			} else {
				int numUnos = numeroDeUnos(numero);
				System.out.println(numUnos);
			}
		}
		scan.close();
	}
}
