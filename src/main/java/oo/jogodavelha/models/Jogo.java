package oo.jogodavelha.models;


import java.util.Map;
import oo.jogodavelha.exceptions.ExcecaoPorCoordenadaInvalida;
import oo.jogodavelha.exceptions.ExcecaoPorSimboloInvalido;

public class Jogo {

//	private Scanner ler = new Scanner(System.in);

	public Tabuleiro tabuleiro;

	public Map<Coordenada, Jogada> getBoard() {
		return tabuleiro.getTabuleiro();
	}

	public int tamanho() {
		return tabuleiro.tamanhoTabuleiro();
	}

	public boolean check(Jogada umaJogada) {
		try {
			tabuleiro.verificaPosicao(umaJogada);
			return true;
		} catch (ExcecaoPorCoordenadaInvalida | ExcecaoPorSimboloInvalido e) {
			// TODO Auto-generated catch bloc			
		}
		return false;
	}

	public boolean hasWinner() {

		int jaJogado = tabuleiro.tamanhoTabuleiro();
		Map<Coordenada, Jogada> vai = tabuleiro.getTabuleiro();
		Character simb;

		// if(jaJogado >=5) {
		simb = 'X';
		if (this.condicoes(simb, vai))
			return true;

		simb = 'O';
		if (this.condicoes(simb, vai))
			return true;
		// }

		if (jaJogado == 9) {
			System.out.println("Deu velha");
			return true;
		}

		return false;
	}

	private boolean condicoes(Character simb, Map<Coordenada, Jogada> vai) {
		int venceu = 0;

		for (int i = 0; i < 3; i++) { // linha
			for (int j = 0; j < 3; j++) { // coluna
				for (Coordenada coo : vai.keySet()) {
					if (coo.getX() == i && coo.getY() == j) {
						if (vai.get(coo).getSimbolo() == simb) {
							venceu++;
							continue;
						}
					} 
				}
				
				
			}
			if(venceu<3) {
				venceu = 0;
			}
			if (venceu == 3) {
				System.out.println("Jogador " + simb + " ganhou !!");
				return true;
			}
		}
		
		for (int i = 0; i < 3; i++) { // linha
			for (int j = 0; j < 3; j++) { // coluna
				for (Coordenada coo : vai.keySet()) {
					if (coo.getX() == j && coo.getY() == i) {
						if (vai.get(coo).getSimbolo() == simb) {
							venceu++;
							continue;
						}
					} 
				}
				
				
			}
			if(venceu<3) {
				venceu = 0;
			}
			if (venceu == 3) {
				System.out.println("Jogador " + simb + " ganhou !!");
				return true;
			}
		}

		for (int j = 0; j < 3; j++) { // coluna
			for (Coordenada coo : vai.keySet()) {
				if (coo.getX() == j && coo.getY() == j) {
					if (vai.get(coo).getSimbolo() == simb) {
						venceu++;
						continue;
					}
				} 
			}
			
		}
		if (venceu == 3) {
			return true;
		}else {
			venceu = 0;
		}

		for (int j = 0; j < 3; j++) { // coluna
			for (Coordenada coo : vai.keySet()) {
				if (coo.getX() == j && coo.getY() == 2 - j) {

					if (vai.get(coo).getSimbolo() == simb) {
						venceu++;
						continue;
					}
				}
			}
			
		}
		if (venceu == 3) {
			return true;
		}else {
			venceu = 0;
		}
		
		return false;
	}

	public Jogo() {

	}

	public void init() {
		tabuleiro = new Tabuleiro();
	}

	public void printTabuleiro() {
		tabuleiro.printMatriz();
	}

	public void add(Jogada jogada) throws ExcecaoPorCoordenadaInvalida, ExcecaoPorSimboloInvalido {
		this.tabuleiro.add(jogada);
	}
}