package br.unitins.repository;

import br.unitins.model.Pizza;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PizzaRepository implements PanacheRepository<Pizza> {
}
