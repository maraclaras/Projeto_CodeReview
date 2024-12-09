package DAO;

public class CobrancaDAO {
    private double totalCobranca;
    private int minutosTotal;

    public CobrancaDAO(double totalCobranca, int minutosTotal) {
        this.totalCobranca = totalCobranca;
        this.minutosTotal = minutosTotal;
    }

    public double getTotalCobranca() {
        return totalCobranca;
    }

    public void setTotalCobranca(double totalCobranca) {
        this.totalCobranca = totalCobranca;
    }

    public int getMinutosTotal() {
        return minutosTotal;
    }

    public void setMinutosTotal(int minutosTotal) {
        this.minutosTotal = minutosTotal;
    }
}
