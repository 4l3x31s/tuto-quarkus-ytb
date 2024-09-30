package quarkus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

import java.util.Optional;

@Path("/saludar")
public class EcoResource {

    @GET
    public String saludar(@QueryParam("mensaje") String mensaje) {
        //return "> " + mensaje;
        return Optional.ofNullable(mensaje)
                .map(n-> "> "+n)
                .orElse("No se muy bien que decir");
    }
    @GET
    @Path("/{nombre}")
    public String saludo(@PathParam("nombre") String nombre){
        return "Hola, "+ nombre;
    }
//    @GET
//    @Path("/dias")
//    public String dias() {
//        return "Buen dìa!!!";
//    }
//    @GET
//    @Path("/tardes")
//    public String tardes() {
//        return "Buenas Tardes";
//    }

}
