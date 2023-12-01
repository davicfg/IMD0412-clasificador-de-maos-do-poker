package poker;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaoTest {
	
	@Test
	void testSaberSeTodasAsCartasTemOMesmoNaipe() {
		Carta c1 = new Carta(1, Naipe.COPAS);
		Carta c2 = new Carta(4, Naipe.COPAS);
		Carta c3 = new Carta(7, Naipe.COPAS);
		Carta c4 = new Carta(8, Naipe.COPAS);
		Carta c5 = new Carta(9, Naipe.COPAS);
		List<Carta> cartas = Arrays.asList(new Carta[] { c1, c2, c3, c4, c5 });
		Mao mao = new Mao(cartas);
		boolean resultado = mao.mesmoNaipe();
		
		Assertions.assertTrue(resultado);
	}
	
	@Test
	void testSaberSeTodasAsCartasTemOMesmoNaipeComNaipesDiferentes() {
		Carta c1 = new Carta(1, Naipe.ESPADAS);
		Carta c2 = new Carta(4, Naipe.PAUS);
		Carta c3 = new Carta(7, Naipe.PAUS);
		Carta c4 = new Carta(8, Naipe.PAUS);
		Carta c5 = new Carta(9, Naipe.PAUS);
		List<Carta> cartas = Arrays.asList(new Carta[] { c1, c2, c3, c4, c5 });
		Mao mao = new Mao(cartas);
		boolean resultado = mao.mesmoNaipe();
		
		Assertions.assertFalse(resultado);
	}
	
	@Test
	void testTrincaComMaoSemTrinca() {
		Carta c1 = new Carta(1, Naipe.ESPADAS);
		Carta c2 = new Carta(4, Naipe.PAUS);
		Carta c3 = new Carta(7, Naipe.PAUS);
		Carta c4 = new Carta(8, Naipe.PAUS);
		Carta c5 = new Carta(9, Naipe.PAUS);
		List<Carta> cartas = Arrays.asList(new Carta[] { c1, c2, c3, c4, c5 });
		Mao mao = new Mao(cartas);
		boolean resultado = mao.temTrinca();
		
		Assertions.assertFalse(resultado);
	}
	
	@Test
	void testTrincaComMaoComTrinca() {
		Carta c1 = new Carta(1, Naipe.ESPADAS);
		Carta c2 = new Carta(1, Naipe.PAUS);
		Carta c3 = new Carta(1, Naipe.PAUS);
		Carta c4 = new Carta(8, Naipe.PAUS);
		Carta c5 = new Carta(9, Naipe.PAUS);
		List<Carta> cartas = Arrays.asList(new Carta[] { c1, c2, c3, c4, c5 });
		Mao mao = new Mao(cartas);
		boolean resultado = mao.temTrinca();
		
		Assertions.assertTrue(resultado);
	}
}
