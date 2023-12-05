package poker;

public class CartaTestDataBuilder {
    private Integer valor;
    private Naipe naipe;

    public CartaTestDataBuilder() {
        this.valor = 1; 
        this.naipe = Naipe.PAUS; 
    }

    public CartaTestDataBuilder comValor(Integer valor) {
        this.valor = valor;
        return this;
    }

    public CartaTestDataBuilder comNaipe(Naipe naipe) {
        this.naipe = naipe;
        return this;
    }

    public Carta construir() {
        return new Carta(this.valor, this.naipe);
    }

    
    public Carta construirAsDePaus() {
        return new Carta(1, Naipe.PAUS);
    }
}
