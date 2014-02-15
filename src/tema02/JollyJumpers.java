/*
 * PC/UVA IDs: 110201/10038
 * PC: Accepted / UVA: Wrong Answer
 * Run Time: 0.546
 */

package tema02;

import java.util.Scanner;

public class JollyJumpers {

	private static boolean comprobarDistancia(int[] numeros) {
		int resta;
		for (int i = 1; i < numeros.length; i++) {
			resta = Math.abs(numeros[i - 1] - numeros[i]);
			if (resta == i || resta == (numeros.length - i)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (scan.hasNext()) {
			int num = scan.nextInt();
			int[] numeros = new int[num];
			for (int i = 0; i < num; i++) {
				numeros[i] = scan.nextInt();
			}

			boolean jolly = comprobarDistancia(numeros);
			if (jolly) {
				System.out.println("Jolly");
			} else {
				System.out.println("Not jolly");
			}
		}
		scan.close();
	}

}
