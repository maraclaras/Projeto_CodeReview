package controller;

import modal.Vaga;
import dto.VagaDto;
import exceptions.VagaInvalidaException;

public class VagaController {
    
    public VagaDto criarVaga(String identificador, int maxVagasPermitidas) {
        try {
            Vaga vaga = new Vaga(identificador, maxVagasPermitidas);
            return new VagaDto(vaga.getIdentificador(), vaga.isOcupada());
        } catch (VagaInvalidaException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void ocuparVaga(Vaga vaga) {
        try {
            vaga.ocupar();
            System.out.println("A vaga " + vaga.getIdentificador() + " foi ocupada.");
        } catch (VagaInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void liberarVaga(Vaga vaga) {
        vaga.liberar();
        System.out.println("A vaga " + vaga.getIdentificador() + " foi liberada.");
    }

    public VagaDto obterVagaDto(Vaga vaga) {
        return new VagaDto(vaga.getIdentificador(), vaga.isOcupada());
    }
}
