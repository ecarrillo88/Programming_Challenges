/*
 * PC/UVA IDs: 110602/10213
 * PC: Accepted / UVA: Accepted
 * Run Time: 0.852
 */

package tema06;

import java.math.BigInteger;
import java.util.Scanner;

public class HowManyPiecesOfLand {

	private static BigInteger numeroMaximoParcelas(int num) {
		// n->(n^4 - 6*n^3 + 23*n^2 - 18*n + 24)/24;
		BigInteger n;
		n = BigInteger.valueOf(num).pow(4);
		n = n.subtract(BigInteger.valueOf(6).multiply(BigInteger.valueOf(num).pow(3)));
		n = n.add(BigInteger.valueOf(23).multiply(BigInteger.valueOf(num).pow(2)));
		n = n.subtract(BigInteger.valueOf(18).multiply(BigInteger.valueOf(num)));
		n = n.add(BigInteger.valueOf(24));
		n = n.divide(BigInteger.valueOf(24));
		return n;
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int casos = entrada.nextInt();
		int n;
		while (casos > 0) {
			n = entrada.nextInt();
			System.out.println(numeroMaximoParcelas(n));
			casos--;
		}
		entrada.close();
	}

}
