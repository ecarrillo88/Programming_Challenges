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
		personasDerecha[1] = personasIzquierda[1];
		personasIzquierda[1] = 0;
		personasDerecha[2] = personasIzquierda[2];
		personasIzquierda[2] = 0;
		log.add("1 2");
	}

	private static void cruzarPuenteMasLentos() {
		int ultimo = personasIzquierda.length - 1;
		personasDerecha[ultimo - 1] = personasIzquierda[ultimo - 1];
		personasIzquierda[ultimo - 1] = 0;
		personasDerecha[ultimo] = personasIzquierda[ultimo];
		personasIzquierda[ultimo] = 0;
		log.add((ultimo - 1) + " " + ultimo);
	}

	private static void volver() {
		// Siempre vuelve una de las dos personas mas rapidas
		// En el caso de que las dos personas mas rapidas esten a la derecha
		// entonces volvera la persona numero 1
		if (personasDerecha[1] != 0) {
			personasIzquierda[1] = personasDerecha[1];
			personasDerecha[1] = 0;
			log.add("1");
		} else {
			personasIzquierda[2] = personasDerecha[2];
			personasDerecha[2] = 0;
			log.add("2");
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
			personasIzquierda = new int[numPersonas];
			for (int i = 0; i < numPersonas; i++) {
				personasIzquierda[i] = scan.nextInt();
			}

			// Ordenamos las personas de menor a mayor velocidad
			countingSort(personasIzquierda);

			imprimirLog();

			numCasos--;
		}
		scan.close();
	}

}
