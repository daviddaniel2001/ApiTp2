package br.unitins.resource;

import java.util.List;

import br.unitins.application.Result;
import br.unitins.dto.PizzaDTO;
import br.unitins.dto.PizzaResponseDTO;
import br.unitins.service.PizzaService;

import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;import 
jakarta.ws.rs.core.Response.Status;

@Path("/pizza")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PizzaResource {
    
    @Inject
    PizzaService pizzaService;

    @GET
    public List<PizzaResponseDTO> getAll() {
        return pizzaService.getAll();
    }

    @POST
    public Response create(PizzaDTO pizzaDto) {
        try {
            PizzaResponseDTO pizza = pizzaService.create(pizzaDto);
            return Response.status(Status.CREATED).entity(pizza).build();
        } catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
        
    }
}
