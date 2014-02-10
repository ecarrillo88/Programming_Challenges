package tema01;

import java.util.Scanner;

public class TresNmasUno {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1, n2;
		while (scan.hasNextInt()) {
			n1 = scan.nextInt();
			n2 = scan.nextInt();
			if (n1 > 0 && n1 < 1000000 && n2 > 0 && n2 < 1000000) {
				System.out.print(n1 + " " + n2 + " ");
				if (n1 > n2) {
					n1 = n1 + n2;
					n2 = n1 - n2;
					n1 = n1 - n2;
				}
				int res = tresN1(n1, n2);
				System.out.println(res);
			}
		}
		scan.close();
	}

	public static int tresN1(int n1, int n2) {
		int cont = 0, aux = 0;
		long n;
		for (int i = n1; i <= n2; i++) {
			n = i;
			while (n != 1) {
				if ((n % 2) == 1) {
					n = 3 * n + 1;
				} else {
					n >>= 1;
				}
				cont++;
			}
			cont++;
			if (cont > aux) {
				aux = cont;
			}
			cont = 0;
		}
		return aux;
	}
}