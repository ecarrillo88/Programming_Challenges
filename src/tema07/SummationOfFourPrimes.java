/*
 * PC/UVA IDs: 110705/10168
 * PC: Wrong Answer (Don't judge correctly) / UVA: Accepted
 * Run Time: 1.078
 */

package tema07;

import java.util.Scanner;

public class SummationOfFourPrimes {
	private static final int MAX = 10000000;
	private static boolean[] numerosPrimos = new boolean[MAX + 1];

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

	private static int primoMasGrandeInferiorAN(int n) {
		int primo = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (numerosPrimos[i]) {
				primo = i;
				break;
			}
		}
		return primo;
	}

	private static String dosNumerosPrimosCuyaSumaSeaN(int n) {
		String primos = "";
		for (int i = 2; i < n; ++i) {
			if (numerosPrimos[i] && numerosPrimos[n - i]) {
				primos += " " + i + " " + (n - i);
				break;
			}
		}
		return primos;
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		cribaDeEratostenes();

		int n;
		while (entrada.hasNext()) {
			n = entrada.nextInt();
			String resultado = "";
			if (n < 8) {
				resultado = "Impossible.";
			} else {
				int aux = 0;
				if (n % 2 == 0) {
					aux = n / 4;
					if (numerosPrimos[aux]) {
						resultado += aux;
					} else {
						aux = primoMasGrandeInferiorAN(aux);
						resultado += aux;
					}
					n -= aux;
					aux = n / 3;
					if (numerosPrimos[aux]) {
						resultado += " " + aux;
					} else {
						aux = primoMasGrandeInferiorAN(aux);
						resultado += " " + aux;
					}
					n -= aux;
					resultado += dosNumerosPrimosCuyaSumaSeaN(n);
				} else {
					resultado += 2;
					n -= 2;
					aux = n / 3;
					if (numerosPrimos[aux]) {
						resultado += " " + aux;
					} else {
						aux = primoMasGrandeInferiorAN(aux);
						resultado += " " + aux;
					}
					n -= aux;
					resultado += dosNumerosPrimosCuyaSumaSeaN(n);
				}
			}
			System.out.println(resultado);
		}
	}

}
