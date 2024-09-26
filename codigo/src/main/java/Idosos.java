public class Idosos extends Vaga {
private double taxaIdoso;
private static final double DESCONTO = 0.15; //Pros 15% de desconto por idoso 

public Idosos(int numero, double taxaIdoso) {	
super(numero);
this.taxaIdoso = taxaIdoso;
}

public double calcularTaxa() {
return this.taxaIdoso * (1 - DESCONTO); // Aplica o desconto de 15%
}
}
