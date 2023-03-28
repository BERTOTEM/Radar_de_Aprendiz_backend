package radar_de_aprendiz.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {

    @Bean
    public RouterFunction<ServerResponse> guardarLiga(Handler handler) {
        return route(POST("api/liga").and(accept(MediaType.APPLICATION_JSON))
                        ,handler::saveLiga);
    }

    @Bean
    public RouterFunction<ServerResponse> listarLigas(Handler handler) {
        return route(GET("api/ligas").and(accept(MediaType.APPLICATION_JSON))
                ,handler::getLigas);
    }

    @Bean
    public RouterFunction<ServerResponse> traerLiga(Handler handler) {
        return route(GET("api/liga/{id}").and(accept(MediaType.APPLICATION_JSON))
                ,handler::getLiga);
    }

    @Bean
    public RouterFunction<ServerResponse> traerAprendices(Handler handler) {
        return route(RequestPredicates.GET("api/mostrarAprendices"), request ->
                ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(handler.getAprendices(), Object.class)
        );
    }

}
