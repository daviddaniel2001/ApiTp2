package br.unitins.repository;



import br.unitins.model.Estado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstadoRepository implements PanacheRepository<Estado>{
    
    public EstadoRepository findByNome(String nome) {
        if(nome == null)
            return null;
        return findByNome(nome);
    }
}
