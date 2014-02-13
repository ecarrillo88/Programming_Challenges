/*
 * PC/UVA IDs: 110501/10035
 * PC: Accepted / UVA: Accepted
 * Run Time: 1.205
 */

package tema05;

import java.util.Scanner;

public class PrimaryArithmetic {

	private static int numeroAcarreosSuma(int num1, int num2) {
		int numAcarreos = 0;
		int digito1, digito2, sumaDigitos, acarreo = 0;
		while (num1 != 0 || num2 != 0) {
			digito1 = num1 % 10;
			digito2 = num2 % 10;
			sumaDigitos = digito1 + digito2 + acarreo;
			if (sumaDigitos >= 10) {
				acarreo = 1;
				numAcarreos++;
			} else {
				acarreo = 0;
			}

			num1 = num1 / 10;
			num2 = num2 / 10;
		}

		return numAcarreos;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		while (num1 != 0 || num2 != 0) {
			int numAcarreos = numeroAcarreosSuma(num1, num2);
			if (numAcarreos == 0) {
				System.out.println("No carry operation.");
			} else if (numAcarreos == 1) {
				System.out.println(numAcarreos + " carry operation.");
			} else {
				System.out.println(numAcarreos + " carry operations.");
			}

			num1 = scan.nextInt();
			num2 = scan.nextInt();
		}
		scan.close();
	}

}
