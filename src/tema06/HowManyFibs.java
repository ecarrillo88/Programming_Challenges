/*
 * PC/UVA IDs: 110601/10183
 * PC: ? / UVA: ?
 * Run Time: ?
 */

package tema06;

import java.math.BigInteger;
import java.util.Scanner;

public class HowManyFibs {
	private static BigInteger[] fib = new BigInteger[100];

	private static void generarFibonaccis() {
		fib[1] = BigInteger.valueOf(1);
		fib[2] = BigInteger.valueOf(2);
		for (int i = 3; i < 100; i++) {
			fib[i] = fib[i - 1].add(fib[i - 2]);
		}
	}

	private static int contarNumeros(BigInteger a, BigInteger b) {
		int cont = 0;
		if (a.compareTo(BigInteger.ZERO) == 0
				&& b.compareTo(BigInteger.ONE) == 0) {
			return 1;
		}

		if (a.compareTo(BigInteger.ONE) == 0
				&& b.compareTo(BigInteger.ONE) == 0) {
			return 1;
		}

		for (int i = 1; i < 100; i++) {
			if (fib[i].compareTo(a) >= 0 && fib[i].compareTo(b) <= 0)
				cont++;
		}

		return cont;
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		generarFibonaccis();

		BigInteger a;
		BigInteger b;
		while (entrada.hasNext()) {
			a = entrada.nextBigInteger();
			b = entrada.nextBigInteger();

			// Salir
			if (a.compareTo(BigInteger.ZERO) == 0
					&& b.compareTo(BigInteger.ZERO) == 0) {
				break;
			}

			System.out.println(contarNumeros(a, b));

		}
		entrada.close();
	}
}
