/*
 * PC/UVA IDs: 110108/10142
 * PC: ? / UVA: ?
 * Run Time: ?
 */

package tema01;

import java.util.Scanner;
import java.util.StringTokenizer;

public class AustralianVoting {
	private static Candidato[] candidatos;
	private static int[][] votos;
	private static final int NUM_VOTOS = 1001;

	// Metodo para testeo
	private static void imprimirArray() {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < candidatos.length; j++) {
				System.out.print(votos[i][j] + "|");
			}
			System.out.println();
		}
	}

	private static int recuentoVotos(int numVotos) {
		int voto;
		// Recuento primera opcion
		for (int i = 0; i < numVotos; i++) {
			voto = votos[i][0];
			// La posicion de los candidatos coincide con su orden
			if (!candidatos[voto].eliminado) {
				candidatos[voto].votos++;
			}
		}

		int resultado = candidatoGanador(numVotos);
		if (resultado != -1) {
			return resultado;
		} else {
			eliminarCandidatosConMenosVotos();
		}

		return 0;
	}

	// Si algun candidato tiene mas de 50% de votos retorna su posicion en el
	// array, sino retorna -1
	private static int candidatoGanador(int numVotos) {
		float porcentajeVotos;
		for (int i = 1; i < candidatos.length; i++) {
			porcentajeVotos = candidatos[i].votos / (float) numVotos;
			if (porcentajeVotos > 0.5) {
				return i;
			}
		}
		return -1;
	}

	private static void eliminarCandidatosConMenosVotos() {
		// Buscamos el minimo de votos entre los candidatos
		int minVotos = Integer.MAX_VALUE;
		for (int i = 0; i < candidatos.length; i++) {
			if (candidatos[i].votos < minVotos) {
				minVotos = candidatos[i].votos;
			}
		}

		// El/los menos votados son "eliminados"
		for (int i = 0; i < candidatos.length; i++) {
			if (candidatos[i].votos == minVotos) {
				candidatos[i].eliminado = true;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCasos = Integer.parseInt(scan.nextLine());
		scan.nextLine(); // Linea en blanco

		while (numCasos > 0) {
			// Almacenamos los candidatos
			int numCandidatos = Integer.parseInt(scan.nextLine());
			candidatos = new Candidato[numCandidatos + 1];
			for (int i = 1; i < candidatos.length; i++) {
				candidatos[i] = new Candidato(scan.nextLine());
			}

			// Almacenamos los votos
			votos = new int[NUM_VOTOS][candidatos.length];
			String linea;
			int voto = 0, numVotos = 0;
			while (scan.hasNextLine()) {
				linea = scan.nextLine();
				if (!linea.isEmpty()) {
					StringTokenizer tokens = new StringTokenizer(linea);
					for (int j = 0; tokens.hasMoreElements(); j++) {
						votos[voto][j] = Integer.parseInt(tokens.nextToken());
						numVotos++;
					}
					voto++;
				} else {
					break;
				}
			}

			// Falta codigo

			if (--numCasos > 0) {
				System.out.print("\n");
			}
		}
		scan.close();
	}
}

class Candidato {
	public String nombre;
	public int votos;
	public boolean eliminado;

	public Candidato(String nombre) {
		this.nombre = nombre;
		this.votos = 0;
		eliminado = false;
	}
}
