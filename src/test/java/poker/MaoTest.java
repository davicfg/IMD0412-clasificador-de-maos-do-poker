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

	@Test
	void testTemSequenciaAlta() {
		Carta c1 = new Carta(1, Naipe.PAUS);
		Carta c2 = new Carta(10, Naipe.PAUS);
		Carta c3 = new Carta(11, Naipe.PAUS);
		Carta c4 = new Carta(12, Naipe.PAUS);
		Carta c5 = new Carta(13, Naipe.PAUS);
		List<Carta> cartas = Arrays.asList(new Carta[] { c1, c2, c3, c4, c5 });
		Mao mao = new Mao(cartas);
		boolean resultado = mao.temSequenciaAlta();

		Assertions.assertTrue(resultado);
	}

	@Test
	void testTemSequenciaComNaipesDifentes() {
		Carta c1 = new Carta(1, Naipe.OUROS);
		Carta c2 = new Carta(10, Naipe.PAUS);
		Carta c3 = new Carta(11, Naipe.PAUS);
		Carta c4 = new Carta(12, Naipe.PAUS);
		Carta c5 = new Carta(13, Naipe.PAUS);
		List<Carta> cartas = Arrays.asList(new Carta[] { c1, c2, c3, c4, c5 });
		Mao mao = new Mao(cartas);
		boolean resultado = mao.temSequenciaAlta();

		Assertions.assertTrue(resultado);
	}

	@Test
	void testRoyalStraightFlush() throws Exception {
		Carta c1 = new Carta(1, Naipe.ESPADAS);
		Carta c2 = new Carta(10, Naipe.ESPADAS);
		Carta c3 = new Carta(11, Naipe.ESPADAS);
		Carta c4 = new Carta(12, Naipe.ESPADAS);
		Carta c5 = new Carta(13, Naipe.ESPADAS);
		List<Carta> cartas = Arrays.asList(new Carta[] { c1, c2, c3, c4, c5 });
		Mao mao = new Mao(cartas);
		RankingMao rankingMao = mao.ranking();

		Assertions.assertEquals(rankingMao, RankingMao.ROYAL_STRAIGHT_FLUSH);
	}

	@Test
	void testStraightFlush() throws Exception {
		Carta c1 = new Carta(2, Naipe.OUROS);
		Carta c2 = new Carta(3, Naipe.OUROS);
		Carta c3 = new Carta(4, Naipe.OUROS);
		Carta c4 = new Carta(5, Naipe.OUROS);
		Carta c5 = new Carta(6, Naipe.OUROS);
		List<Carta> cartas = Arrays.asList(new Carta[] { c1, c2, c3, c4, c5 });
		Mao mao = new Mao(cartas);

		RankingMao rankingMao = mao.ranking();

		Assertions.assertEquals(rankingMao, RankingMao.STRAIGHT_FLUSH);
	}

	@Test
	void testStraight() throws Exception {
		Carta c1 = new Carta(2, Naipe.COPAS);
		Carta c2 = new Carta(3, Naipe.OUROS);
		Carta c3 = new Carta(4, Naipe.ESPADAS);
		Carta c4 = new Carta(5, Naipe.OUROS);
		Carta c5 = new Carta(6, Naipe.PAUS);
		List<Carta> cartas = Arrays.asList(new Carta[] { c1, c2, c3, c4, c5 });
		Mao mao = new Mao(cartas);

		RankingMao rankingMao = mao.ranking();

		Assertions.assertEquals(rankingMao, RankingMao.SEQUENCIA);
	}

	@Test
	void testQuadra() throws Exception {
		Carta c1 = new Carta(2, Naipe.OUROS);
		Carta c2 = new Carta(2, Naipe.ESPADAS);
		Carta c3 = new Carta(2, Naipe.PAUS);
		Carta c4 = new Carta(2, Naipe.COPAS);
		Carta c5 = new Carta(6, Naipe.OUROS);
		List<Carta> cartas = Arrays.asList(new Carta[] { c1, c2, c3, c4, c5 });
		Mao mao = new Mao(cartas);

		RankingMao rankingMao = mao.ranking();

		Assertions.assertEquals(rankingMao, RankingMao.QUADRA);
	}

	@Test
	void testFullHouse() throws Exception {
		Carta c1 = new Carta(2, Naipe.OUROS);
		Carta c2 = new Carta(2, Naipe.ESPADAS);
		Carta c3 = new Carta(2, Naipe.PAUS);
		Carta c4 = new Carta(9, Naipe.OUROS);
		Carta c5 = new Carta(9, Naipe.COPAS);
		List<Carta> cartas = Arrays.asList(new Carta[] { c1, c2, c3, c4, c5 });
		Mao mao = new Mao(cartas);

		RankingMao rankingMao = mao.ranking();

		Assertions.assertEquals(RankingMao.FULL_HOUSE, rankingMao);
	}

	@Test
	void testFlush() throws Exception {
		Carta c1 = new Carta(4, Naipe.OUROS);
		Carta c2 = new Carta(3, Naipe.OUROS);
		Carta c3 = new Carta(5, Naipe.OUROS);
		Carta c4 = new Carta(7, Naipe.OUROS);
		Carta c5 = new Carta(9, Naipe.OUROS);
		List<Carta> cartas = Arrays.asList(new Carta[] { c1, c2, c3, c4, c5 });
		Mao mao = new Mao(cartas);

		RankingMao rankingMao = mao.ranking();

		Assertions.assertEquals(RankingMao.FLUSH, rankingMao);
	}

	@Test
	void testTrinca() throws Exception {
		Carta c1 = new Carta(2, Naipe.OUROS);
		Carta c2 = new Carta(2, Naipe.ESPADAS);
		Carta c3 = new Carta(2, Naipe.PAUS);
		Carta c4 = new Carta(5, Naipe.OUROS);
		Carta c5 = new Carta(9, Naipe.COPAS);
		List<Carta> cartas = Arrays.asList(new Carta[] { c1, c2, c3, c4, c5 });
		Mao mao = new Mao(cartas);

		RankingMao rankingMao = mao.ranking();

		Assertions.assertEquals(RankingMao.TRINCA, rankingMao);
	}

	@Test
	void testDoisPares() throws Exception {
		Carta c1 = new Carta(2, Naipe.OUROS);
		Carta c2 = new Carta(2, Naipe.ESPADAS);
		Carta c3 = new Carta(4, Naipe.PAUS);
		Carta c4 = new Carta(4, Naipe.OUROS);
		Carta c5 = new Carta(9, Naipe.COPAS);
		List<Carta> cartas = Arrays.asList(new Carta[] { c1, c2, c3, c4, c5 });
		Mao mao = new Mao(cartas);

		RankingMao rankingMao = mao.ranking();

		Assertions.assertEquals(RankingMao.DOIS_PARES, rankingMao);
	}

	@Test
	void testNada() throws Exception {
		Carta c1 = new Carta(1, Naipe.OUROS);
		Carta c2 = new Carta(3, Naipe.ESPADAS);
		Carta c3 = new Carta(7, Naipe.PAUS);
		Carta c4 = new Carta(9, Naipe.OUROS);
		Carta c5 = new Carta(10, Naipe.COPAS);
		List<Carta> cartas = Arrays.asList(new Carta[] { c1, c2, c3, c4, c5 });
		Mao mao = new Mao(cartas);

		RankingMao rankingMao = mao.ranking();

		Assertions.assertEquals(RankingMao.NADA, rankingMao);
	}

	@Test
	void testMaoComDuasCartasRepetidas() throws Exception {
		Carta c1 = new Carta(1, Naipe.OUROS);
		Carta c2 = new Carta(1, Naipe.OUROS);
		Carta c3 = new Carta(7, Naipe.PAUS);
		Carta c4 = new Carta(9, Naipe.OUROS);
		Carta c5 = new Carta(10, Naipe.COPAS);
		List<Carta> cartas = Arrays.asList(new Carta[] { c1, c2, c3, c4, c5 });
		Mao mao = new Mao(cartas);

		Exception exception = Assertions.assertThrows(Exception.class, () -> mao.ranking());

		Assertions.assertEquals("A mão contem uma carta duplicada!", exception.getMessage());
	}

	@Test
	void testTemSequencia() throws Exception {
		Carta c1 = new CartaTestDataBuilder().comValor(1).comNaipe(Naipe.OUROS).construir();
		Carta c2 = new CartaTestDataBuilder().comValor(2).comNaipe(Naipe.OUROS).construir();
		Carta c3 = new CartaTestDataBuilder().comValor(3).comNaipe(Naipe.PAUS).construir();
		Carta c4 = new CartaTestDataBuilder().comValor(4).comNaipe(Naipe.OUROS).construir();
		Carta c5 = new CartaTestDataBuilder().comValor(5).comNaipe(Naipe.COPAS).construir();
		List<Carta> cartas = Arrays.asList(c1, c2, c3, c4, c5);

		Mao mao = new Mao(cartas);

		boolean resultado = mao.temSequencia();

		Assertions.assertTrue(resultado);
	}

	@Test
	void testQuantidadeDePares() throws Exception {
		Carta c1 = new CartaTestDataBuilder().comValor(1).comNaipe(Naipe.OUROS).construir();
		Carta c2 = new CartaTestDataBuilder().comValor(1).comNaipe(Naipe.OUROS).construir();
		Carta c3 = new CartaTestDataBuilder().comValor(3).comNaipe(Naipe.PAUS).construir();
		Carta c4 = new CartaTestDataBuilder().comValor(4).comNaipe(Naipe.OUROS).construir();
		Carta c5 = new CartaTestDataBuilder().comValor(4).comNaipe(Naipe.COPAS).construir();
		List<Carta> cartas = Arrays.asList(c1, c2, c3, c4, c5);

		Mao mao = new Mao(cartas);

		int resultado = mao.quantidadeDePares();

		Assertions.assertEquals(2, resultado);
	}

	@Test
	void testTemQuadra() throws Exception {
		Carta c1 = new CartaTestDataBuilder().comValor(1).comNaipe(Naipe.OUROS).construir();
		Carta c2 = new CartaTestDataBuilder().comValor(1).comNaipe(Naipe.OUROS).construir();
		Carta c3 = new CartaTestDataBuilder().comValor(1).comNaipe(Naipe.PAUS).construir();
		Carta c4 = new CartaTestDataBuilder().comValor(1).comNaipe(Naipe.OUROS).construir();
		Carta c5 = new CartaTestDataBuilder().comValor(4).comNaipe(Naipe.COPAS).construir();
		List<Carta> cartas = Arrays.asList(c1, c2, c3, c4, c5);

		Mao mao = new Mao(cartas);

		boolean resultado = mao.temQuadra();

		Assertions.assertTrue(resultado);
	}

	@Test
	void testValoresCartas() throws Exception {
		Carta c1 = new CartaTestDataBuilder().comValor(1).comNaipe(Naipe.OUROS).construir();
		Carta c2 = new CartaTestDataBuilder().comValor(1).comNaipe(Naipe.OUROS).construir();
		Carta c3 = new CartaTestDataBuilder().comValor(1).comNaipe(Naipe.PAUS).construir();
		Carta c4 = new CartaTestDataBuilder().comValor(1).comNaipe(Naipe.OUROS).construir();
		Carta c5 = new CartaTestDataBuilder().comValor(4).comNaipe(Naipe.COPAS).construir();
		List<Carta> cartas = Arrays.asList(c1, c2, c3, c4, c5);

		Mao mao = new Mao(cartas);

		List<Integer> resultado = mao.valoresCartas();

		Assertions.assertEquals(Arrays.asList(1, 1, 1, 1, 4), resultado);
	}

}
