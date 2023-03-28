package radar_de_aprendiz.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import radar_de_aprendiz.model.area.Area;
import radar_de_aprendiz.model.radar.Radar;
import radar_de_aprendiz.usecase.creararea.CrearAreaUseCase;
import radar_de_aprendiz.usecase.crearradar.CrearRadarUseCase;
import radar_de_aprendiz.usecase.listarradar.ListarRadarUseCase;
import radar_de_aprendiz.usecase.listarradares.ListarRadaresUseCase;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
@RequiredArgsConstructor
public class Handler {
    private final CrearAreaUseCase crearAreaUseCase;
    private final CrearRadarUseCase crearRadarUseCase;
    private  final ListarRadaresUseCase listarRadaresUseCase;

    private final ListarRadarUseCase listarRadarUseCase;

    static Mono<ServerResponse> notFound = ServerResponse.notFound().build();
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
    public Mono<ServerResponse> CreateRadar(ServerRequest serverRequest) {
        Mono<Radar> radarMono = serverRequest.bodyToMono(Radar.class);

        return radarMono.flatMap(radar -> ServerResponse.
                status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON)
                .body(crearRadarUseCase.crearRadar(radar), Radar.class));
    }

    public Mono<ServerResponse> getOneRadar(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("nombre");
        Mono<Radar> itemMono = listarRadarUseCase.apply(id);
        return itemMono.flatMap(item ->
                ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue(item))
        ).switchIfEmpty(notFound);

    }
    public Mono<ServerResponse> getAllRadar(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listarRadaresUseCase.apply(), Radar.class);

    }
}
