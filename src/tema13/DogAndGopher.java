/*
 * PC/UVA IDs: 111301/10310
 * PC: Accepted / UVA: Accepted
 * Run Time: 1.075
 */

package tema13;

import java.util.Scanner;

public class DogAndGopher {

	public static double distanciaATopera(double oX, double oY, double dX, double dY) {
		double x = oX - dX;
		double y = oY - dY;
		return Math.sqrt(x * x + y * y);
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int numToperas;
		double topoX, topoY, perroX, perroY, toperaX, toperaY;
		Coordenadas[] toperas;
		while (entrada.hasNext()) {
			numToperas = entrada.nextInt();
			topoX = entrada.nextDouble();
			topoY = entrada.nextDouble();
			perroX = entrada.nextDouble();
			perroY = entrada.nextDouble();
			toperas = new Coordenadas[numToperas];

			for (int i = 0; i < toperas.length; i++) {
				toperaX = entrada.nextDouble();
				toperaY = entrada.nextDouble();
				toperas[i] = new Coordenadas(toperaX, toperaY);
			}

			boolean topoCazado = true;
			for (int i = 0; i < toperas.length; i++) {
				toperaX = toperas[i].x;
				toperaY = toperas[i].y;
				double distanciaTopo = distanciaATopera(topoX, topoY, toperaX, toperaY);
				double distanciaPerro = distanciaATopera(perroX, perroY, toperas[i].x,
						toperas[i].y);
				if ((distanciaPerro / 2.0) >= distanciaTopo) {
					System.out.printf("The gopher can escape through the hole at (%.3f,%.3f).\n",
							toperaX, toperaY);
					topoCazado = false;
					break;
				}
			}

			if (topoCazado) {
				System.out.println("The gopher cannot escape.");
			}
		}
	}
}

class Coordenadas {
	double x;
	double y;

	Coordenadas(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
