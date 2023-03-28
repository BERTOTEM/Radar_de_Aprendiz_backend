package radar_de_aprendiz.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import radar_de_aprendiz.model.area.Area;
import radar_de_aprendiz.usecase.creararea.CrearAreaUseCase;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final CrearAreaUseCase crearAreaUseCase;
    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> CreateArea(ServerRequest serverRequest) {
        Mono<Area> areaMono = serverRequest.bodyToMono(Area.class);

        return areaMono.flatMap(area -> ServerResponse.
                status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON)
                .body(crearAreaUseCase.crearArea(area), Area.class));
    }
}
