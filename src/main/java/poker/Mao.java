package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	
	//Davi
	public boolean naipesIguais() {
		return this.naipesDasCartas().stream().map(Naipe::name).distinct().limit(2).count() <= 1;
		
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
		
		return new HashSet<Naipe>(this.naipesDasCartas()).size() <= 1;
	}
	//Davi
	public boolean temSequenciaAlta() {
		return false;
	}
	
	//Cleiton
	public List<Integer> valoresCartas(){
		ArrayList<Integer> valores = new ArrayList<Integer>();
		
		for(Carta carta : this.cartas) {
			valores.add(carta.getValor());
		}
		return valores;
		
	}
	
	//Davi
	public List<Naipe> naipesDasCartas(){
		ArrayList<Naipe> naipes = new ArrayList<Naipe>();
		for (Carta carta : this.cartas) {
			naipes.add(carta.getNaipe());
		} 

		return naipes;
	}
}
