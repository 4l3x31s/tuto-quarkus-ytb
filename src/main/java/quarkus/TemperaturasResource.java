package quarkus;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/temperatura")
public class TemperaturasResource {

    private ITemperaturaService temperaturas;

    @Inject
    public TemperaturasResource(ITemperaturaService temperaturas){
        this.temperaturas = temperaturas;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Temperatura> list() {
        return temperaturas.obtenerTemperaturas();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/una")
    public Temperatura medicion(){
        return new Temperatura("Málaga", 18,28);
    }

    @POST
    public Temperatura nueva(Temperatura temp){
        temperaturas.addTemperatura(temp);
        return temp;
    }

    @GET
    @Path("/maxima")
    @Produces(MediaType.TEXT_PLAIN)
    public Response maxina() {
        if(temperaturas.isEmpty()){
            return Response.status(404).entity(("No hay temperaturas")).build();
        }else{
            int temperaturaMaxima = temperaturas.maxima();
            return Response.ok(Integer.toString(temperaturaMaxima)).build();
        }
//        return Response.status(400)
//                .language(("es-ES"))
//                .header("X-Response", "Hola")
//                .entity(null)
//                .build();
    }
    @GET
    @Path("/{ciudad}")
    @Produces(MediaType.APPLICATION_JSON)
    public Temperatura sacar(@PathParam("ciudad") String ciudad){
        return temperaturas.sacarTemperatura(ciudad).get();

    }
}
