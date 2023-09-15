package br.unitins.dto;

import jakarta.validation.constraints.NotBlank;

public record PizzaDTO
(
    @NotBlank(message = "O campo precisa ser preenchido.")
    String sabor,
    @NotBlank(message = "O campo precisa ser preenchido.")
    Float preco

)
{

}