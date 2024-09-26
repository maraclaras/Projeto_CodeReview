public class PCD extends Vaga {

    private double taxaPCD;
    private static final double DESCONTO = 0.13; //Pros 13% de desconto por PCD
    private boolean espacoMaior;// o enunciado coloca como caracteristica, logo tem q verificar

    public PCD(int numero, double taxaPCD, boolean espacoMaior) {
        super(numero);
        this.taxaPCD = taxaPCD;
        this.espacoMaior = espacoMaior;
    }
    public double calcularTaxa() {
        return this.taxaPCD * (1 - DESCONTO); // Aplica o desconto de 13%
    }

    public boolean isEspacoMaior() {
        return espacoMaior;
    }
}

