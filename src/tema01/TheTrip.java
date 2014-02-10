package tema01;

import java.util.Scanner;

public class TheTrip {
	private static double[] gastos = new double[1001];
	private static long nViajeros = 101;

	private static double totalIntercambiado(double media) {
		double TotalDado = 0;
		double TotalRecibido = 0;
		for (int i = 0; i < nViajeros; i++) {
			double diferencia = gastos[i] - media;
			if (diferencia < 0) {
				TotalRecibido -= diferencia;
			} else {
				TotalDado += diferencia;
			}
		}
		return TotalDado < TotalRecibido ? TotalDado : TotalRecibido;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			nViajeros = scan.nextInt();
			if (nViajeros == 0) {
				break;
			}

			double total = 0;
			for (int i = 0; i < nViajeros; i++) {
				gastos[i] = scan.nextDouble();
				total += gastos[i];
			}

			double media = total / nViajeros;
			media = Math.rint(media * 100) / 100; // redondeo a 2 decimales
			double intercambiado = totalIntercambiado(media);
			System.out.printf("$%.2f\n", intercambiado);
		}
		scan.close();
	}

}
