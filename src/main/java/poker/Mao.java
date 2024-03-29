package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

	public RankingMao ranking() throws Exception {
		
		if(this.temSequenciaAlta() && this.naipesIguais()) {
			return RankingMao.ROYAL_STRAIGHT_FLUSH;
		}else if(this.temSequencia() && !this.temSequenciaAlta() && !this.naipesIguais()) {
			return RankingMao.SEQUENCIA;
		}else if(this.naipesIguais() && this.temSequencia() ) {
			return RankingMao.STRAIGHT_FLUSH;
		}
		else if(this.temQuadra()) {
			return RankingMao.QUADRA;
		}else if(this.temTrinca() && this.quantidadeDePares() == 3) {
			return RankingMao.FULL_HOUSE;
		}else if(this.naipesIguais()) {
			return RankingMao.FLUSH;
		}else if(this.temTrinca() && this.quantidadeDePares() == 2) {
			return RankingMao.TRINCA;
		}else if(!this.temTrinca() && this.quantidadeDePares() == 2) {
			return RankingMao.DOIS_PARES;
		}else if (this.temErro()) {
			throw new Exception("A mão contem uma carta duplicada!"); 

		}
		
		return RankingMao.NADA;
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public boolean naipesIguais() {
		return this.naipesDasCartas().stream().map(Naipe::name).distinct().limit(2).count() <= 1;
		
	}
	
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
	
	public boolean temTrinca() {
		Map<Integer,Long> values = 
			    this.valoresCartas().stream()
			           .collect(Collectors.groupingBy(Integer::intValue,Collectors.counting()));
		for(Map.Entry<Integer, Long> value: values.entrySet()) {
			if(value.getValue() == 3) {
				return true;
			}
		}
		return false;
	}
	
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
	
	public boolean mesmoNaipe() {
		
		return new HashSet<Naipe>(this.naipesDasCartas()).size() <= 1;
	}
	
	public boolean temSequenciaAlta() {
		List<Integer> sequenciaAlta = Arrays.asList(1,10,11,12,13);
		
		return this.valoresCartas().containsAll(sequenciaAlta);
	}
	
	public List<Integer> valoresCartas(){
		List<Integer> valores = new ArrayList<>();
		for (Carta carta : this.cartas) {
			valores.add(carta.getValor());
		}
		return valores;

	}
	
	public List<Naipe> naipesDasCartas(){
		ArrayList<Naipe> naipes = new ArrayList<Naipe>();
		for (Carta carta : this.cartas) {
			naipes.add(carta.getNaipe());
		} 

		return naipes;
	}
	
	public boolean temErro() {
		List<Carta> cartas = getCartas();
		for (int i = 0; i < cartas.size(); i++) {
			for (int j = i + 1; j < cartas.size(); j++) {
				if (cartas.get(i).equals(cartas.get(j))) {
					return true;
				}
			}
		}
		return false;
	}
}
