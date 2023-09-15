package br.unitins.dto;

import jakarta.validation.constraints.NotBlank;

public record EstadoDTO(

    @NotBlank(message = "O campo precisa ser preenchido.")
    String nome, 
    @NotBlank(message = "O campo precisa ser preenchido.")
    String sigla

) {
    
}
