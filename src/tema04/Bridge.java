/*
 * PC/UVA IDs: 110403/10037
 * PC: ? / UVA: ?
 * Run Time: ?
 */

package tema04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bridge {
	// Cada posicion del array es una persona y su contenido es su velocidad
	// Al inicio suponemos que todas estan a la izquierda del puente
	private static int[] personasIzquierda;
	private static int[] personasDerecha;
	// Se utiliza para guardar el log de personas que van y vienen por el puente
	private static ArrayList<String> log;
	private static int costeTotal;

	// COUNTING SORT O(n+k)
	private static void countingSort(int a[]) {
		int min = a[0], max = a[0];
		for (int i = 1; i < a.length; i++) {
			min = Math.min(min, a[i]);
			max = Math.max(max, a[i]);
		}

		if (max - min <= 10000000) { // To use 40MB of RAM at most
			int counter[] = new int[max - min + 1];
			for (int i = 0; i < a.length; i++)
				counter[a[i] - min]++;

			int k = 0;
			for (int i = 0; i < counter.length; i++) {
				while (counter[i] > 0) {
					a[k++] = i + min;
					counter[i]--;
				}
			}

		} else {
			Arrays.sort(a); // O(n log(n))
		}
	}

	private static void cruzarPuenteMasRapidos() {
		// Los dos mas rapidos seran el 1 y el 2 o el 1 y el 3 dependiendo de si
		// el numero de personas es par o impar y se comprueba si esta el 2
		if (!todosDerecha()) {
			int velocidad1, velocidad2;
			if (personasIzquierda[2] != 0) {
				velocidad1 = personasIzquierda[1];
				velocidad2 = personasIzquierda[2];
				personasDerecha[1] = velocidad1;
				personasIzquierda[1] = 0;
				personasDerecha[2] = velocidad2;
				personasIzquierda[2] = 0;
			} else {
				velocidad1 = personasIzquierda[1];
				velocidad2 = personasIzquierda[3];
				personasIzquierda[1] = velocidad1;
				personasIzquierda[1] = 0;
				personasDerecha[3] = velocidad2;
				personasIzquierda[3] = 0;
			}
			costeTotal += velocidad2;
			log.add(velocidad1 + " " + velocidad2);
		}
	}

	private static void cruzarPuenteMasLentos(int ultimo) {
		if (!todosDerecha()) {
			int velocidad1, velocidad2;
			if (personasIzquierda[ultimo - 1] != 0) {
				velocidad1 = personasIzquierda[ultimo - 1];
				velocidad2 = personasIzquierda[ultimo];
				personasDerecha[ultimo - 1] = velocidad1;
				personasIzquierda[ultimo - 1] = 0;
				personasDerecha[ultimo] = velocidad2;
				personasIzquierda[ultimo] = 0;
			} else {
				velocidad1 = personasIzquierda[ultimo - 2];
				velocidad2 = personasIzquierda[ultimo];
				personasDerecha[ultimo - 2] = velocidad1;
				personasIzquierda[ultimo - 2] = 0;
				personasDerecha[ultimo] = velocidad2;
				personasIzquierda[ultimo] = 0;
			}
			costeTotal += velocidad2;
			log.add(velocidad1 + " " + velocidad2);
		}
	}

	private static void volverMasRapido() {
		// Siempre vuelve una de las dos personas mas rapidas.
		// En el caso de que las dos personas mas rapidas esten a la derecha
		// entonces volvera la persona mas rapida (numero 1)
		if (!todosDerecha()) {
			int velocidad;
			if (personasDerecha[1] != 0) {
				velocidad = personasDerecha[1];
				personasIzquierda[1] = velocidad;
				personasDerecha[1] = 0;
			} else {
				velocidad = personasDerecha[2];
				personasIzquierda[2] = velocidad;
				personasDerecha[2] = 0;
			}
			costeTotal += velocidad;
			log.add(velocidad + " ");
		}
	}

	private static boolean todosDerecha() {
		for (int i = 1; i < personasDerecha.length; i++) {
			if (personasDerecha[i] == 0) {
				return false;
			}
		}
		return true;
	}

	private static void imprimirLog() {
		for (int i = 0; i < log.size(); i++) {
			System.out.println(log.get(i));
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCasos = scan.nextInt();

		while (numCasos > 0) {
			int numPersonas = scan.nextInt();
			personasIzquierda = new int[numPersonas + 1];
			personasDerecha = new int[numPersonas + 1];
			for (int i = 1; i <= numPersonas; i++) {
				personasIzquierda[i] = scan.nextInt();
			}

			// Ordenamos las personas de menor a mayor velocidad
			countingSort(personasIzquierda);

			costeTotal = 0;
			log = new ArrayList<String>();

			int ultimo = personasDerecha.length - 1;
			while (!todosDerecha()) {
				cruzarPuenteMasRapidos();
				volverMasRapido();
				cruzarPuenteMasLentos(ultimo);
				volverMasRapido();
				ultimo -= 2;
			}

			System.out.println(costeTotal);
			imprimirLog();
			System.out.print("\n");

			numCasos--;
		}
		scan.close();
	}

}
