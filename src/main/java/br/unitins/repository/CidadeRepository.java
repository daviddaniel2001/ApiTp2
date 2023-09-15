package br.unitins.repository;

import br.unitins.model.Cidade;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CidadeRepository implements PanacheRepository<Cidade> {
    
    public CidadeRepository findByNome(String nome) { 
        if(nome == null)
            return null;
        return findByNome(nome);
    }
}
