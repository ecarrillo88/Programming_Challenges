/*
 * PC/UVA IDs: 110603/10198
 * PC: Accepted / UVA: Accepted
 * Run Time: 0.792
 */

package tema06;

import java.math.BigInteger;
import java.util.Scanner;

public class Counting {
	// Array que contiene los resultados para cada a(n) hasta a(1000)
	private static BigInteger[] a = new BigInteger[1001];

	// Se generan todos los resultados hasta n = 1000 y asi solo hay que
	// consultar en el array 'a' el valor n para obtener su resultado
	private static void generarResultados() {
		// Valores fijos
		a[1] = BigInteger.valueOf(2);
		a[2] = BigInteger.valueOf(5);
		a[3] = BigInteger.valueOf(13);

		BigInteger dos = BigInteger.valueOf(2);
		for (int i = 4; i < 1001; i++) {
			// Relacion de recurrencia: n > 3, An = A(n-1)*2+A(n-2)+A(n-3)
			a[i] = ((a[i - 1].multiply(dos)).add(a[i - 2])).add(a[i - 3]);
		}
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		generarResultados();
		while (entrada.hasNext()) {
			System.out.println(a[entrada.nextInt()]);
		}
		entrada.close();
	}
}
