package poker;

import java.util.ArrayList;
import java.util.Collections;
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
	
	//Davi
	public boolean naipesIguais() {
		return this.naipesDasCartas().stream().map(Naipe::name).distinct().limit(2).count() <= 1;
		
	}
	
	//Cleiton
	public boolean temSequencia() {
		List<Integer> valores = valoresCartas();
		Collections.sort(valores);
		
		for (int i = 0; i < valores.size() - 1; i++) {
			if (valores.get(i) + 1 != valores.get(i + 1)) {
				return false;
			}
		}
		
		return true;
	}
	
	//Cleiton
	public int quantidadeDePares() {
		int count = 0;
		List<Integer> valores = valoresCartas();
		for (int i = 0; i < valores.size(); i++) {
			int current = valores.get(i);
			for (int j = i + 1; j < valores.size(); j++) {
				if (current == valores.get(j)) {
					count++;
					break;
				}
			}
		}
		return count;
	}
	
	//Davi
	public boolean temTrinca() {
		return false;
	}
	
	//Cleiton
	public boolean temQuadra() {
		List<Integer> valores = valoresCartas();
		for (int i = 0; i < valores.size(); i++) {
			int count = 0;
			int current = valores.get(i);
			for (int j = 0; j < valores.size(); j++) {
				if (current == valores.get(j)) {
					count++;
				}
			}
			if (count == 4) {
				return true;
			}
		}
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
		List<Integer> valores = new ArrayList<>();
		for (Carta carta : this.cartas) {
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
		for(Naipe naipe: naipes) {
			System.out.println(naipe.name());
		}
		return naipes;
	}
}
