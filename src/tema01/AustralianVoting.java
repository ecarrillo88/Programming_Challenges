/*
 * PC/UVA IDs: 110108/10142
 * PC: Accepted / UVA: Accepted
 * Run Time: 0.442
 */

package tema01;

import java.util.Scanner;
import java.util.StringTokenizer;

public class AustralianVoting {
	private static Candidato[] candidatos;
	private static int[][] votos;
	private static final int NUM_VOTOS = 1001;

	private static void imprimirCandidatosEmpatados() {
		for (int i = 1; i < candidatos.length; i++) {
			Candidato candidato = candidatos[i];
			if (!candidato.eliminado)
				System.out.println(candidato.nombre);
		}
	}

	// Retorna el numero del candidato ganador o -1 en caso de empate
	private static int recuentoVotos(int numVotos) {
		int ganador = -1; // Inicialmente no hay ganador
		int primeraOpcion;
		do {
			// Con cada nuevo recuento se eliminan los votos anteriores
			eliminarVotos();
			// Recuento de votos
			for (int i = 0; i < numVotos; i++) {
				primeraOpcion = votos[i][0];
				if (candidatos[primeraOpcion].eliminado) {
					for (int j = 1; j < candidatos.length; j++) {
						if (!candidatos[votos[i][j]].eliminado) {
							candidatos[votos[i][j]].votos++;
							break;
						}
					}
				} else {
					candidatos[primeraOpcion].votos++;
				}
			}
			ganador = ganador(numVotos);
			// Mientras no haya ganador hay que eliminar a los menos votados y
			// recontar los votos de nuevo
		} while (ganador == -1 && eliminarCandidatosConMenosVotos());

		return ganador;
	}

	// Reinicia el contador de votos para los nuevos recuentos
	private static void eliminarVotos() {
		for (int i = 1; i < candidatos.length; i++) {
			candidatos[i].votos = 0;
		}
	}

	// Comprueba si algun candidato tiene mas de 50% de votos
	private static int ganador(int numVotos) {
		float porcentajeVotos;
		for (int i = 1; i < candidatos.length; i++) {
			if (!candidatos[i].eliminado) {
				porcentajeVotos = candidatos[i].votos / (float) numVotos;
				if (porcentajeVotos > 0.5) {
					return i; // Numero del ganador
				}
			}
		}
		return -1; // No hay ganador
	}

	private static boolean eliminarCandidatosConMenosVotos() {
		int maxVotos = Integer.MIN_VALUE;
		int minVotos = Integer.MAX_VALUE;
		for (int i = 1; i < candidatos.length; i++) {
			if (!candidatos[i].eliminado && candidatos[i].votos < minVotos) {
				minVotos = candidatos[i].votos;
			}
			if (!candidatos[i].eliminado && candidatos[i].votos > maxVotos) {
				maxVotos = candidatos[i].votos;
			}
		}

		boolean hayEliminados = false;
		// Solo se eliminan candidatos si existen candidatos con un numero de
		// votos inferior al resto de candidatos. En caso de empate no se
		// elimina ningun candidato
		if (minVotos < maxVotos) {
			// El/los menos votados son "eliminados"
			for (int i = 1; i < candidatos.length; i++) {
				if (candidatos[i].votos == minVotos) {
					candidatos[i].eliminado = true;
					hayEliminados = true;
				}
			}
		}

		return hayEliminados;
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
					}
					voto++;
				} else {
					// Cuando encontremos una linea en blanco se termina el
					// almacenamiento de votos
					break;
				}
				numVotos++;
			}

			int resultado = recuentoVotos(numVotos);
			if (resultado != -1) {
				System.out.println(candidatos[resultado].nombre); // Hay ganador
			} else {
				imprimirCandidatosEmpatados(); // Hay empate
			}

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
