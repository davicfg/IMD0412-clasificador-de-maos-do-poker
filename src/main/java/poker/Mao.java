package poker;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Mao {
	private List<Carta> cartas;

	public Mao(List<Carta> cartas) {
		this.setCartas(cartas);
	}

	public RankingMao ranking() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public boolean naipesIguais() {
		for (Carta carta : this.cartas) {
			System.out.println(carta.getNaipe());
			System.out.println("#######");
		}
		
		return false;
		
	}
	
	//Cleiton
	public boolean temSequencia() {
		return false;
	}
	//Cleiton
	public int quantidadeDePares() {
		return -1;
	}
	
	//Davi
	public boolean temTrinca() {
		return false;
	}
	
	//Cleiton
	public boolean temQuadra() {
		return false;
	}
	
	//Davi
	public boolean mesmoNaipe() {
		return false;
	}
	//Davi
	public boolean temSequenciaAlta() {
		return false;
	}
	
	//Cleiton
	public List<Integer> valoresCartas(){
		return new ArrayList<>();
	}
	//Davi
	public List<Naipe> NaipesDasCartas(){
		return new ArrayList<>();
	}
}
