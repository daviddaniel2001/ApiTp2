package br.unitins.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.dto.CidadeDTO;
import br.unitins.dto.CidadeResponseDTO;
import br.unitins.model.Cidade;
import br.unitins.repository.CidadeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CidadeServiceImpl implements CidadeService {

    //Injecao de dependecias
    @Inject
    CidadeRepository cidadeRepository;

    //Metodo para validar informacoes
    @Inject
    Validator validator;

    //Retorna toda a lista de cidade
    @Override
    public List<CidadeResponseDTO> getAll() {
        return cidadeRepository.findAll()
                .stream()
                .map(CidadeResponseDTO::new)
                .collect(Collectors.toList());
    }

    //Retorna o Id da cidade
    @Override
    public CidadeResponseDTO findById(Long id) {
        Cidade cidade = cidadeRepository.findById(id);
        if(cidade == null)
            throw new NotFoundException("Não encontrado");
        return new CidadeResponseDTO(cidade); 
    }

    //Cria uma nova cidade com todos os atributos
    @Override
    public CidadeResponseDTO create(CidadeDTO cidadeDTO) throws ConstraintViolationException{
        validar(cidadeDTO);

        var entity = new Cidade();
        entity.setNome(cidadeDTO.nome());
        entity.setSigla(cidadeDTO.sigla());
        entity.setEstado(cidadeDTO.estado());

        cidadeRepository.persist(entity);

        return new CidadeResponseDTO(entity);
    }

    //O metodo citado acima(validar informacoes)
    public void validar(CidadeDTO cidadeDTO) throws ConstraintViolationException {
         Set<ConstraintViolation<CidadeDTO>> violations = validator.validate(cidadeDTO);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }
}
