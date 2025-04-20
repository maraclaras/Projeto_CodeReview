package controller;

import DTO.VagaDTO;
import exceptions.VagaInvalidaException;

import java.util.ArrayList;
import java.util.List;

public class VagaController {
    private static final int MAX_VAGAS = 100; // Limite máximo de vagas
    private static int vagasCriadas = 0;
    private List<VagaDTO> vagas = new ArrayList<>();

    public VagaDTO criarVaga(String identificador, boolean pcd) throws VagaInvalidaException {
        if (vagasCriadas >= MAX_VAGAS) {
            throw new VagaInvalidaException("Limite máximo de vagas atingido.");
        }

        if (!validarIdentificador(identificador)) {
            throw new VagaInvalidaException("Identificador de vaga inválido: " + identificador);
        }

        VagaDTO vaga = new VagaDTO(identificador, pcd);
        vagas.add(vaga);
        vagasCriadas++;
        return vaga;
    }

    public void ocuparVaga(VagaDTO vaga) throws VagaInvalidaException {
        if (vaga.isOcupada()) {
            throw new VagaInvalidaException("A vaga " + vaga.getIdentificador() + " já está ocupada.");
        }
        vaga.setOcupada(true);
    }

    public void liberarVaga(VagaDTO vaga) {
        vaga.setOcupada(false);
    }

    public List<VagaDTO> listarVagas() {
        return new ArrayList<>(vagas);
    }

    private boolean validarIdentificador(String identificador) {
        return identificador.matches("[A-Z][0-9]{2}");
    }
}