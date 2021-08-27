package oo.jogodavelha.models;

import java.util.Scanner;

import oo.jogodavelha.exceptions.ExcecaoPorCoordenadaInvalida;
import oo.jogodavelha.exceptions.ExcecaoPorSimboloInvalido;

public class Interface {

	static Scanner teclado = new Scanner(System.in);
	static public Jogo g;
	static public Character simbolo;
	static public int cX, cY, xAnt = 3, yAnt;
	static Character jogadaAnterior;

	public static void menuPartida() {
		System.out.println("\n   Menu ");
		System.out.println("(1)\tNova Partida");
		System.out.println("(0)\tSair");
	}

	public static void umaJogada() throws ExcecaoPorCoordenadaInvalida, ExcecaoPorSimboloInvalido {

		do {
			System.out.print("\nDigite um simblolo[X, O]: ");
			simbolo = teclado.next().charAt(0);
			// Se simbolo for invalido chama a funcao de novo
			if (simbolo != 'X' && simbolo != 'O' || simbolo == jogadaAnterior) {
				System.err.println("\n[ERRO] Simbolo invalido.");
			} else {
				break;
			}
		} while (true);

		do {
			System.out.print("Coordenada [Linha Coluna]: ");
			cX = teclado.nextInt();
			cY = teclado.nextInt();

			// Se posicao for invalida chama a funcao de novo
			if (cX < 0 || cX > 2 || cY < 0 || cY > 2 || (cX == xAnt && cY == yAnt)) {
				System.err.println("\n[ERRO] Posição invalida.");
			} else {
				break;
			}
		} while (true);

		System.out.println("");

		g.add(new Jogada(simbolo, new Coordenada(cX, cY)));
		g.printTabuleiro();
		jogadaAnterior = simbolo;
		xAnt = cX;
		yAnt = cY;

	}

	public static void inicio() throws ExcecaoPorCoordenadaInvalida, ExcecaoPorSimboloInvalido {
		g = new Jogo();
		g.init();
		int cont = 0;
		boolean vencedor = false;
		while (!vencedor) {
			umaJogada();
			cont++;
			
			if (cont >= 5)
				vencedor = g.hasWinner();

		}
	}

}