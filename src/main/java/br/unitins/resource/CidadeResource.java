package br.unitins.resource;

import java.util.List;

import br.unitins.application.Result;
import br.unitins.dto.CidadeDTO;
import br.unitins.dto.CidadeResponseDTO;
import br.unitins.service.CidadeService;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/cidade")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CidadeResource {
    
    @Inject
    CidadeService cidadeService;

    @GET
    public List<CidadeResponseDTO> getAll() {
        return cidadeService.getAll();
    }

    @POST
    public Response create(CidadeDTO cidadeDTO) {
        try {
            CidadeResponseDTO cidade = cidadeService.create(cidadeDTO);
            return Response.status(Status.CREATED).entity(cidade).build();
        } catch(ConstraintViolationException c) {
            Result result = new Result(c.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }
}
