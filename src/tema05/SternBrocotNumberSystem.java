/*
 * PC/UVA IDs: 110507/10077
 * PC: Accepted / UVA: Accepted
 * Run Time: 0.739
 */

package tema05;

import java.util.Scanner;

public class SternBrocotNumberSystem {
	private static fraccion f1;
	private static fraccion f2;
	private static fraccion f3;

	private static String obtenerCadena(fraccion f) {
		// Fracciones iniciales
		f1 = new fraccion(0, 1);
		f2 = new fraccion(1, 1);
		f3 = new fraccion(1, 0);

		String cadena = "";

		while (f2.compareTo(f) != 0) {
			if (f.compareTo(f2) < 0) {
				f3 = f2;
				cadena += "L";
			} else {
				f1 = f2;
				cadena += "R";
			}
			f2 = new fraccion(f1.numerador + f3.numerador, f1.denominador + f3.denominador);
		}

		return cadena;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		while (num1 != 1 || num2 != 1) {
			fraccion f = new fraccion(num1, num2);

			System.out.println(obtenerCadena(f));

			num1 = scan.nextInt();
			num2 = scan.nextInt();
		}
		scan.close();
	}

}

class fraccion {
	int numerador;
	int denominador;

	fraccion(int a, int b) {
		this.numerador = a;
		this.denominador = b;
	}

	double obtenerValor() {
		return (double) numerador / denominador;
	}

	int compareTo(fraccion f) {
		if (this.obtenerValor() < f.obtenerValor()) {
			return -1;
		} else if (this.obtenerValor() > f.obtenerValor()) {
			return 1;
		}
		return 0;
	}

}
