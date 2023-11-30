package poker;

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
	
	public boolean temSequencia() {
		return false;
	}
	
	public int quantidadeDePares() {
		return -1;
	}
	
	public boolean temTrinca() {
		return false;
	}
	
	public boolean temQuadra() {
		return false;
	}
	
	public boolean mesmoNaipe() {
		return false;
	}
	
	public boolean temSequenciaAlta() {
		return false;
	}
	
}
