package radar_de_aprendiz.api;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route(GET("/api/listarRadares"), handler::getAllRadar)
                .andRoute(POST("/api/AgregarArea"), handler::AgregarArea)
                .andRoute(POST("/api/CrearRadar"), handler::CreateRadar)
                .and(route(GET("/api/listarRadar/{nombre}"), handler::getOneRadar));
    }


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
        return route(RequestPredicates.GET("api/mostrarAprendices").and(accept(MediaType.APPLICATION_JSON))
                ,handler::getAprendices);
    }

}
