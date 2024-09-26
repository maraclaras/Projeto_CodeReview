public class VIP extends Vaga {
private double taxaVip;
private static final double ADICIONAL = 0.20; //Pros 20% de aumento por vip
private boolean coberta; // o enunciado coloca como caracteristica, logo tem q verificar
private boolean proximaPortao; // o enunciado coloca como caracteristica, logo tem q verificar

    public VIP (int numero, double taxaVip, boolean coberta, boolean proximaPortao) {
    super(numero);
    this.taxaVip = taxaVip;
    this.coberta = coberta;
    this.proximaPortao = proximaPortao;
    }

    public double calcularTaxa() {
    return this.taxaVip *(1+ ADICIONAL);
    }

    public boolean isCoberta() {
    return coberta;
    }

    public boolean isProximaPortao() {
    return proximaPortao;
    }
}