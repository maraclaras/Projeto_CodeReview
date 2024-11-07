package controller;

import dto.HistoricoEstacionamentoDto;
import modal.HistoricoEstacionamento;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HistoricoEstacionamentoController {
    private List<HistoricoEstacionamento> historicos = new ArrayList<>();
    private Long idCounter = 1L; // Contador para gerar IDs únicos

    // Método para registrar a entrada de um cliente
    public HistoricoEstacionamentoDto registrarEntrada(String identificadorVaga, String cpfCliente) {
        HistoricoEstacionamento historico = new HistoricoEstacionamento(idCounter++, identificadorVaga, cpfCliente, LocalDateTime.now());
        historicos.add(historico);
        return convertToDto(historico);
    }

    // Método para registrar a saída de um cliente
    public HistoricoEstacionamentoDto registrarSaida(Long id) {
        for (HistoricoEstacionamento historico : historicos) {
            if (historico.getId().equals(id) && historico.getDataSaida() == null) {
                historico.setDataSaida(LocalDateTime.now());
                return convertToDto(historico);
            }
        }
        return null; // Retorna null se o histórico não for encontrado ou já tiver saída registrada
    }

    // Método para obter o histórico por CPF do cliente
    public List<HistoricoEstacionamentoDto> obterHistoricoPorCpf(String cpfCliente) {
        return historicos.stream()
                .filter(h -> h.getCpfCliente().equals(cpfCliente))
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Método auxiliar para converter model em DTO
    private HistoricoEstacionamentoDto convertToDto(HistoricoEstacionamento historico) {
        HistoricoEstacionamentoDto dto = new HistoricoEstacionamentoDto();
        dto.setId(historico.getId());
        dto.setIdentificadorVaga(historico.getIdentificadorVaga());
        dto.setCpfCliente(historico.getCpfCliente());
        dto.setDataEntrada(historico.getDataEntrada());
        dto.setDataSaida(historico.getDataSaida());
        return dto;
    }
}
