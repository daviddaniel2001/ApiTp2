package br.unitins.dto;

import br.unitins.model.Pizza;

public record PizzaResponseDTO(
    Long id,
    String sabor,
    Float preco
    )
{
    public PizzaResponseDTO(Pizza pizza){
        this(pizza.getId(),
            pizza.getSabor(),
            pizza.getPreco()
            );
    }
}