package radar_de_aprendiz.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route(GET("/api/listarRadares"), handler::getAllRadar)
                .andRoute(POST("/api/AgregarArea"), handler::CreateArea)
                .andRoute(POST("/api/CrearRadar"), handler::CreateRadar)
                .and(route(GET("/api/listarRadar/{nombre}"), handler::getOneRadar));
    }
}
