package tema03;

import java.util.Scanner;

public class WERTYU {

	public static void main(String[] args) {
		char[] teclado = { '`', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'0', '-', '=', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
				'P', '[', ']', '\\', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K',
				'L', ';', '\'', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.',
				'/' };

		Scanner scan = new Scanner(System.in);

		while (scan.hasNext()) {
			char[] texto = scan.nextLine().toCharArray();

			for (int i = 0; i < texto.length; i++) {
				for (int j = 0; j < teclado.length; j++) {
					if (texto[i] == teclado[j]) {
						texto[i] = teclado[j - 1];
						break;
					}
				}
			}

			System.out.println(String.valueOf(texto));
		}
		scan.close();
	}
}
