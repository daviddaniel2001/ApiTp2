package br.unitins.resource;

import java.util.List;

import br.unitins.application.Result;
import br.unitins.dto.EstadoDTO;
import br.unitins.dto.EstadoResponseDTO;
import br.unitins.service.EstadoService;
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

@Path("/estado")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstadoResource {

    @Inject 
    EstadoService estadoService;

    @GET
    public List<EstadoResponseDTO> getAll() {
       return estadoService.getAll();
    }

    @POST
    public Response create (EstadoDTO estadoDTO) {
        try{
            EstadoResponseDTO estado = estadoService.create(estadoDTO);
            return Response.status(Status.CREATED).entity(estado).build();
        } catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

}
