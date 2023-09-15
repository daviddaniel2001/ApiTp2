package br.unitins.service;

import java.util.List;

import br.unitins.dto.EstadoDTO;
import br.unitins.dto.EstadoResponseDTO;

public interface EstadoService {
    
    //Lista de estados
    List<EstadoResponseDTO> getAll();

    //Id dos estados 
    EstadoResponseDTO findById(Long id);

    //Novo estado
    EstadoResponseDTO create(EstadoDTO estadoDTO);
}
