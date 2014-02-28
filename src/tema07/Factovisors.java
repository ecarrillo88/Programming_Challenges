/*
 * PC/UVA IDs: 110704/10139
 * PC: ? / UVA: Runtime Error
 * Run Time: ?
 */

package tema07;

import java.util.*;

public class Factovisors {
	private static long n;
	private static long m;

	// Descompone m en factores
	private static ArrayList<Long> Factorizar(long n) {
		ArrayList<Long> listaFactores = new ArrayList<Long>();
		long num = n;
		// Mientras podamos dividir por 2 el dos es un factor
		while (num % 2 == 0) {
			listaFactores.add((long) 2);
			num = num / 2;
		}

		// Ahora probaremos con los impares, empezando por el 3
		long cuenta = 3;
		long raiz = (long) Math.sqrt(num);

		while (cuenta <= raiz && num > 1) {
			if (num % cuenta == 0) {
				listaFactores.add(cuenta);
				num = num / cuenta;
			} else {
				cuenta = cuenta + 2;
			}
		}

		if (num > 1) {
			listaFactores.add(num);
		}

		return listaFactores;
	}

	private static boolean esFactovisor(ArrayList<Long> listaFactores) {
		int j = 1;
		for (int i = 0; i < listaFactores.size(); i += j) {
			long factor = listaFactores.get(i);
			long divisor = factor;
			int numFactorEnN = 0, exp = 2;
			// Contamos cuantos numeros igual a factor hay en n!
			while (divisor < n) {
				numFactorEnN += n / divisor;
				divisor = (long) Math.pow(factor, exp++);
			}

			int numFactorEnM = 0;
			for (j = i; j < listaFactores.size(); j++) {
				if (listaFactores.get(i) != listaFactores.get(j)) {
					break;
				}
				numFactorEnM++;
			}

			if (numFactorEnM > numFactorEnN) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		while (entrada.hasNextLine()) {
			n = entrada.nextInt();
			m = entrada.nextInt();

			if (m != 0) {
				ArrayList<Long> listaFactores = new ArrayList<Long>();
				listaFactores = Factorizar(m);

				if (esFactovisor(listaFactores)) {
					System.out.println(m + " divides " + n + "!");
				} else {
					System.out.println(m + " does not divide " + n + "!");
				}
			} else {
				System.out.println(m + " does not divide " + n + "!");
			}
		}

		entrada.close();
	}
}
