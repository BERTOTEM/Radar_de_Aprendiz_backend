package radar_de_aprendiz.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import radar_de_aprendiz.model.liga.Liga;
import radar_de_aprendiz.usecase.crearliga.CrearLigaUseCase;
import radar_de_aprendiz.usecase.listarligas.ListarLigasUseCase;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final CrearLigaUseCase crearLigaUseCase;
    private final ListarLigasUseCase listarLigasUseCase;
    static Mono<ServerResponse> notFound = ServerResponse.notFound().build();
    public Mono<ServerResponse> saveLiga(ServerRequest serverRequest) {
        var newLiga = serverRequest.bodyToMono(Liga.class);
        return newLiga.flatMap(liga ->
                ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearLigaUseCase.save(liga), Liga.class));
    }
    public Mono<ServerResponse> getLigas(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listarLigasUseCase.getLigas(), Liga.class);
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}
