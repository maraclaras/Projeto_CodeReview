import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cobranca {
    private static float taxaPorMinuto;
    private static float maxCobranca;
    private float totalCobranca;
    private float horaInicio;
    private float horafinal;
    private float minutosTotal;
    
    static {
        taxaPorMinuto = 4.0f;
        maxCobranca = 50.0f;
    }

    public float calcularValor(float totalCobranca){   
        totalCobranca =  * taxaPorMinuto;
       
        if(totalCobranca>maxCobranca){
            totalCobranca=maxCobranca;
        }

        return totalCobranca;
    }
    public float CalcularMinutos(float horaInicio, float horafinal, float minutosTotal){
        float minutosFinal = 
        minutosTotal=horafinal-horaInicio;
        

        

    }
    

}
