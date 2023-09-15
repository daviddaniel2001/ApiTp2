package br.unitins.dto;

import br.unitins.model.Estado;
import jakarta.validation.constraints.NotBlank;

public record CidadeDTO(

    @NotBlank(message = "O espaco deve ser preencido.")
    String nome,
    
    @NotBlank(message = "O espaco deve ser preenchido.")
    String sigla,

    @NotBlank(message = "O espaco deve ser preenchido.")
    Estado estado
){
    
}
