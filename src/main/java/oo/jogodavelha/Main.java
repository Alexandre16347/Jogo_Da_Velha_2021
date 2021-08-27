package oo.jogodavelha;

import java.util.Scanner;

import oo.jogodavelha.exceptions.ExcecaoPorCoordenadaInvalida;
import oo.jogodavelha.exceptions.ExcecaoPorSimboloInvalido;
import oo.jogodavelha.models.Interface;

public class Main {
	
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) throws ExcecaoPorCoordenadaInvalida, ExcecaoPorSimboloInvalido {

//			Jogo g = new Jogo();
//			
//			g.add(new Jogada('X',new Coordenada(0,0)));
//			g.add(new Jogada('B',new Coordenada(0,1)));
//			g.add(new Jogada('C',new Coordenada(0,2)));

//			g.add(new Jogada('X',new Coordenada(1,0)));
//			g.add(new Jogada('X',new Coordenada(1,1)));
//			g.add(new Jogada('X',new Coordenada(1,2)));
//			
//			g.add(new Jogada('X',new Coordenada(2,0)));
//			g.add(new Jogada('X',new Coordenada(2,1)));
//			g.add(new Jogada('X',new Coordenada(2,2)));
		//// ======================================================
//			g.add(new Jogada('X',new Coordenada(0,0)));
//			g.add(new Jogada('X',new Coordenada(1,0)));
//			g.add(new Jogada('X',new Coordenada(2,0)));

//			g.add(new Jogada('X',new Coordenada(0,1)));
//			g.add(new Jogada('X',new Coordenada(1,1)));
//			g.add(new Jogada('X',new Coordenada(2,1)));
//			
//			g.add(new Jogada('X',new Coordenada(0,2)));
//			g.add(new Jogada('X',new Coordenada(1,2)));
//			g.add(new Jogada('X',new Coordenada(2,2)));
		//// ======================================================
//			g.add(new Jogada('X',new Coordenada(0,0)));
//			g.add(new Jogada('X',new Coordenada(1,1)));
//			g.add(new Jogada('X',new Coordenada(2,2)));

//			g.add(new Jogada('X',new Coordenada(0,2)));
//			g.add(new Jogada('X',new Coordenada(1,1)));
//			g.add(new Jogada('X',new Coordenada(2,0)));		

		// ==========================================================
//			g.add(new Jogada('X',new Coordenada(0,0)));
//			g.add(new Jogada('O',new Coordenada(0,1)));
//			g.add(new Jogada('O',new Coordenada(1,0)));
//			g.add(new Jogada('O',new Coordenada(2,2)));
//			g.add(new Jogada('O',new Coordenada(0,2)));
//			g.add(new Jogada('X',new Coordenada(1,1)));
//			g.add(new Jogada('X',new Coordenada(1,2)));
//			g.add(new Jogada('X',new Coordenada(2,0)));
//			g.add(new Jogada('X',new Coordenada(2,1)));

//			g.printTabuleiro();
//			
//			System.out.println(g.hasWinner()+" Tam: "+g.tamanho());

		

		boolean sair = false;
		int cond;
		

		while (!sair) {
			Interface.menuPartida();
			cond = teclado.nextInt();

			switch (cond) {
			case 0: {
				sair = true;
				break;
			}
			case 1: {
				Interface.inicio();
				break;
			}
			default:
				System.err.println("[ERRO] Entrada invalida.");
			}
		}

	}

}
