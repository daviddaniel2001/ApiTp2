package br.unitins.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.dto.EstadoDTO;
import br.unitins.dto.EstadoResponseDTO;
import br.unitins.model.Estado;
import br.unitins.repository.EstadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class EstadoServiceImpl implements EstadoService {

    //Injecao de dependencia
    @Inject
    EstadoRepository estadoRepository;

    //Validacao de informacoes
    @Inject 
    Validator validator;

    //Lista todos os estados
    @Override
    public List<EstadoResponseDTO> getAll() {
        return estadoRepository.findAll()
                 .stream()
                 .map(EstadoResponseDTO::new)
                 .collect(Collectors.toList());
    }

    //Retorna o id do estado
    @Override
    public EstadoResponseDTO findById(Long id) {
        Estado estado = estadoRepository.findById(id);
        if(estado == null)
            throw new NotFoundException("Não encontrado");
        return new EstadoResponseDTO(estado);
    }   

    //Cria um novo estado e seus atributos
    @Override
    public EstadoResponseDTO create(EstadoDTO estadoDTO) throws ConstraintViolationException {
       validar(estadoDTO);

       var entity = new Estado();
       entity.setNome(estadoDTO.nome());
       entity.setSigla(estadoDTO.sigla());

       estadoRepository.persist(entity);

       return new EstadoResponseDTO(entity);
    }

    //Metodo de validacao 
    private void validar(EstadoDTO estadoDTO) throws ConstraintViolationException {

        Set<ConstraintViolation<EstadoDTO>> violations = validator.validate(estadoDTO);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }
    
}
