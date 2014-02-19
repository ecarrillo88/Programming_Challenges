package tema06;

import java.math.BigInteger;
import java.util.Scanner;

public class Prueba {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		BigInteger[] fib = new BigInteger[501];
		fib[1] = BigInteger.valueOf(1);
		fib[2] = BigInteger.valueOf(2);
		for (int i = 3; i < 500; i++) {
			fib[i] = fib[i - 1].add(fib[i - 2]);
		}

		while (entrada.hasNext()) {
			BigInteger a = entrada.nextBigInteger();
			BigInteger b = entrada.nextBigInteger();
			int count = 0;
			if (a.compareTo(BigInteger.ZERO) == 0
					&& b.compareTo(BigInteger.ZERO) == 0) {
				break;
			}

			else if (a.compareTo(BigInteger.ZERO) == 0
					&& b.compareTo(BigInteger.ONE) == 0) {
				System.out.println(1);
				continue;
			} else if (a.compareTo(BigInteger.ONE) == 0
					&& b.compareTo(BigInteger.ONE) == 0) {
				System.out.println(1);
				continue;
			}
			for (int i = 1; i < 500; i++) {
				if (fib[i].compareTo(a) >= 0 && fib[i].compareTo(b) <= 0)
					count++;
			}
			System.out.println(count);

		}
		entrada.close();
	}
}
