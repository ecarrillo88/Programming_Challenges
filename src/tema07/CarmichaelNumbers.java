/*
 * PC/UVA IDs: 110702/10006
 * PC: Accepted / UVA: Accepted
 * Run Time: 1,969
 */

package tema07;

import java.util.Scanner;

public class CarmichaelNumbers {
	private static final int MAX = 65000;
	private static boolean[] numerosPrimos = new boolean[MAX + 1];

	/*
	 * La criba de eratostenes nos permite obtener de una forma rapida todos los
	 * numeros primos que hay desde 1 hasta 65.000
	 */
	private static void cribaDeEratostenes() {
		// Inicializamos a true todo el array
		for (int i = 0; i < numerosPrimos.length; i++) {
			numerosPrimos[i] = true;
		}

		numerosPrimos[1] = false;
		int fin = (int) Math.sqrt(MAX) + 1;
		for (int i = 2; i <= fin; i++) {
			if (numerosPrimos[i]) {
				for (int j = i * 2; j < numerosPrimos.length; j += i) {
					numerosPrimos[j] = false;
				}
			}
		}
	}

	private static boolean esNumeroCarmichael(int n) {
		for (int a = 2; a <= n - 1; a++) {
			if (a_Pow_n_mod_n(a, n, n) != a) {
				return false;
			}
		}
		return true;
	}

	private static long a_Pow_n_mod_n(long a, long m, long n) {
		long res = 1;
		while (m > 0) {
			if ((m & 1) == 1) {
				res = (res * a) % n;
			}
			m >>= 1;
			a = (a * a) % n;
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		cribaDeEratostenes();
		int numero;
		while ((numero = entrada.nextInt()) != 0) {
			if (numerosPrimos[numero]) {
				System.out.println(numero + " is normal.");
			} else {
				if (esNumeroCarmichael(numero)) {
					System.out.println("The number " + numero + " is a Carmichael number.");
				} else {
					System.out.println(numero + " is normal.");
				}
			}

		}

		entrada.close();

	}

}
