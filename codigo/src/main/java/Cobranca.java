public class Cobranca {
    private static final float taxaPorMinuto = 4.0f;
    private static final float maxCobranca = 50.0f;
    private float totalCobranca;
    private int minutosTotal;

    public float calcularValor(int minutosEstacionado) {
        totalCobranca = minutosEstacionado * taxaPorMinuto;

        if (totalCobranca > maxCobranca) {
            totalCobranca = maxCobranca;
        }

        return totalCobranca;
    }

    public int calcularMinutos(int horaInicio, int horaFinal) {
        minutosTotal = horaFinal - horaInicio;
        if (minutosTotal < 0) {
            System.out.println("Horário inválido.");
            minutosTotal = 0;
        }
        return minutosTotal;
    }

    public float mostrarValorTotal() {
        return totalCobranca;
    }

    public void cobrarCliente(String cpf, float totalCobranca) {
        System.out.println("Cliente com CPF " + cpf + " foi cobrado no valor de: R$ " + totalCobranca);
    }
}
