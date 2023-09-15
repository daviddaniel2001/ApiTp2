package br.unitins.model;

import jakarta.persistence.Entity;

@Entity
public class Pizza extends DefautEntity {

    private String sabor;
    
    private Float preco;

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

}
