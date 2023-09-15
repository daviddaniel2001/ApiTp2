package br.unitins.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.dto.PizzaDTO;
import br.unitins.dto.PizzaResponseDTO;
import br.unitins.model.Pizza;
import br.unitins.repository.PizzaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PizzaServiceImpl implements PizzaService {

    @Inject
    PizzaRepository pizzaRepository;
    
    @Inject 
    Validator validator;

    @Override
    public List<PizzaResponseDTO> getAll() {
        return pizzaRepository.findAll()
                .stream()
                .map(PizzaResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public PizzaResponseDTO findById(Long id) {
        Pizza pizza = pizzaRepository.findById(id);
        if(pizza == null)
            throw new NotFoundException("Id não encotrado!");
        return new PizzaResponseDTO(pizza);
    }

    @Override
    public PizzaResponseDTO create(PizzaDTO productDTO) throws ConstraintViolationException {
        validar(productDTO);
        
        var entity = new Pizza();
        entity.setSabor(productDTO.sabor());
        entity.setPreco(productDTO.preco());

        pizzaRepository.persist(entity);
        
        return new PizzaResponseDTO(entity);
    }

    private void validar(PizzaDTO productDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<PizzaDTO>> violations = validator.validate(productDTO);

        if(!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }
    
}
