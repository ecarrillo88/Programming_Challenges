/*
 * PC/UVA IDs: 110702/10006
 * PC: ? / UVA: ?
 * Run Time: ?
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

	private static void CarmichaelNumbers(int n) {

		/*
		 * for (int a=2; a<=n-1; a++) { if (fast_mod_pow(a,n,n) != a) { c[n] =
		 * false; break; }
		 */

		double a;
		if (n % 2 == 0) {
			a = ((Math.pow(3, n / 2)) * (Math.pow(3, n / 2))) % n;
		} else {
			a = ((Math.pow(3, n / 2)) * (Math.pow(3, n / 2)) * (Math.pow(3, n)))
					% n;
		}

		System.out.println(a);
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		cribaDeEratostenes();
		int numero;
		while ((numero = entrada.nextInt()) != 0) {
			if (numerosPrimos[numero]) {
				System.out.println(numero + " is normal.");
			} else {
				long a = ((long) Math.pow(2, numero)) % numero;
				System.out.println(a);
			}

		}

		entrada.close();

	}

}
