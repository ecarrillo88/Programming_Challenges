/*
 * PC/UVA IDs: 110104/706
 * PC: Wrong Answer / UVA: Time Limit Exceeded
 * Run Time: ?
 */

package tema01;

import java.util.Scanner;

public class LCD_Display {
	private static String numero;
	private static int tamano = 10;
	private static char[][] digitos = null;

	private static void inicializarLCD() {
		int filas = (tamano * 2) + 3;
		int columnas = (tamano + 2) * numero.length();
		digitos = new char[filas][columnas];
	}

	// pos {0,1,2} -> {arriba, medio, abajo}
	// index -> posicion del numero
	private static void lineaHorizontal(int pos, int index) {
		int fila = pos * (tamano + 1);
		int columna = index * (tamano + 2);
		digitos[fila][columna] = ' ';
		for (int i = 0; i < tamano; i++) {
			digitos[fila][++columna] = '-';
		}
		digitos[fila][++columna] = ' ';
	}

	private static void lineaHorizontalEnBlanco(int pos, int index) {
		int fila = pos * (tamano + 1);
		int columna = index * (tamano + 2);
		for (int i = 0; i < (tamano + 2); i++) {
			digitos[fila][columna++] = ' ';
		}
	}

	private static void lineaVerticalEnBlanco(int index) {
		int fila = 0;
		int columna = index * (tamano + 2);
		for (int i = 0; i < (tamano * 2 + 3); i++) {
			digitos[fila++][columna] = ' ';
		}
	}

	private static void lineaVerticalIzquierda(int pos, int index) {
		int fila = pos * (tamano + 1) + 1;
		int columna = index * (tamano + 2);
		for (int i = 0; i < tamano; i++) {
			digitos[fila++][columna] = '|';
		}
	}

	private static void lineaVerticalDerecha(int pos, int index) {
		int fila = pos * (tamano + 1) + 1;
		int columna = (index + 1) * (tamano + 2) - 1;
		for (int j = 0; j < tamano; j++) {
			digitos[fila++][columna] = '|';
		}
	}

	// pos {0,1} -> {arriba, abajo}
	// index -> posicion del numero
	private static void lineaVerticalIzquierdaYDerecha(int pos, int index) {
		/*int fila = pos * (tamano + 1) + 1;
		int columna = index * (tamano + 2);
		int aux = columna;
		for (int i = 0; i < tamano; i++) {
			digitos[fila][aux++] = '|';
			for (int j = 0; j < tamano; j++) {
				aux++;
			}
			digitos[fila++][aux] = '|';
			aux = columna;
		}*/
		lineaVerticalIzquierda(pos, index);
		lineaVerticalDerecha(pos, index);
	}

	public static void imprimirLCD() {
		for (int i = 0; i < digitos.length; i++) {
			for (int j = 0; j < digitos[0].length; j++) {
				// Con el modulo sabemos cuando ha acabado de imprimirse cada
				// digito
				if (j % (tamano + 2) == 0) {
					if (j != 0)
						System.out.print(" ");
				}
				System.out.print(digitos[i][j]);
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//int cont = 1; // para saber cuando imprimir el espacio en blanco

		while (true) {
			tamano = scan.nextInt();
			int num = scan.nextInt();
			if (tamano == 0 && num == 0) {
				break;
			}
			
			numero = Integer.toString(num);
			inicializarLCD();
			for (int i = 0; i < numero.length(); i++) {
				switch (numero.charAt(i)) {
				case '0':
					lineaHorizontal(0, i);
					lineaVerticalIzquierdaYDerecha(0, i);
					lineaHorizontalEnBlanco(1, i);
					lineaVerticalIzquierdaYDerecha(1, i);
					lineaHorizontal(2, i);
					break;
				case '1':
					lineaVerticalDerecha(0, i);
					lineaHorizontalEnBlanco(1, i);
					lineaVerticalDerecha(1, i);
					break;
				case '2':
					lineaHorizontal(0, i);
					lineaVerticalDerecha(0, i);
					lineaHorizontal(1, i);
					lineaVerticalIzquierda(1, i);
					lineaHorizontal(2, i);
					break;
				case '3':
					lineaHorizontal(0, i);
					lineaVerticalDerecha(0, i);
					lineaHorizontal(1, i);
					lineaVerticalDerecha(1, i);
					lineaHorizontal(2, i);
					break;
				case '4':
					lineaHorizontalEnBlanco(0, i);
					lineaVerticalIzquierdaYDerecha(0, i);
					lineaHorizontal(1, i);
					lineaVerticalDerecha(1, i);
					lineaHorizontalEnBlanco(2, i);
					break;
				case '5':
					lineaHorizontal(0, i);
					lineaVerticalIzquierda(0, i);
					lineaHorizontal(1, i);
					lineaVerticalDerecha(1, i);
					lineaHorizontal(2, i);
					break;
				case '6':
					lineaHorizontal(0, i);
					lineaVerticalIzquierda(0, i);
					lineaHorizontal(1, i);
					lineaVerticalIzquierdaYDerecha(1, i);
					lineaHorizontal(2, i);
					break;
				case '7':
					lineaHorizontal(0, i);
					lineaVerticalDerecha(0, i);
					lineaHorizontalEnBlanco(1, i);
					lineaVerticalDerecha(1, i);
					lineaHorizontalEnBlanco(2, i);
					break;
				case '8':
					lineaHorizontal(0, i);
					lineaVerticalIzquierdaYDerecha(0, i);
					lineaHorizontal(1, i);
					lineaVerticalIzquierdaYDerecha(1, i);
					lineaHorizontal(2, i);
					break;
				case '9':
					lineaHorizontal(0, i);
					lineaVerticalIzquierdaYDerecha(0, i);
					lineaHorizontal(1, i);
					lineaVerticalDerecha(1, i);
					lineaHorizontal(2, i);
				}
			}
			//if (cont > 1) {
				//System.out.print("\n");
			//}
			
			imprimirLCD();
			System.out.print("\n");
			//cont++;
		}
		scan.close();
	}
}
