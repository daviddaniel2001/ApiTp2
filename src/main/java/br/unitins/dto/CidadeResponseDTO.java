package br.unitins.dto;

import br.unitins.model.Cidade;
import br.unitins.model.Estado;

public record CidadeResponseDTO(

    Long id, 
    String nome, 
    String sigla, 
    Estado estado
) {
    public CidadeResponseDTO(Cidade cidade){
        this(cidade.getId(),
            cidade.getNome(),
            cidade.getSigla(),
            cidade.getEstado()
            );
    }
}
