package br.unitins.service;

import java.util.List;

import br.unitins.dto.PizzaDTO;
import br.unitins.dto.PizzaResponseDTO;

public interface PizzaService {
    
    List<PizzaResponseDTO> getAll();

    PizzaResponseDTO findById(Long id);

    PizzaResponseDTO create(PizzaDTO productDTO);
}
