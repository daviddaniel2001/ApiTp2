package br.unitins.service;

import java.util.List;

import br.unitins.dto.CidadeDTO;
import br.unitins.dto.CidadeResponseDTO;

public interface CidadeService {
    
    //Acessa a lista de cidades
    List<CidadeResponseDTO> getAll();

    //Acessa o id 
    CidadeResponseDTO findById(Long id);

    //Cria uma nova cidade
    CidadeResponseDTO create(CidadeDTO cidadeDTO);
}
