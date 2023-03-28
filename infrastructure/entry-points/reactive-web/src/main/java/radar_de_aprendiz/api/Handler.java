package radar_de_aprendiz.api;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import radar_de_aprendiz.model.liga.Liga;
import radar_de_aprendiz.usecase.crearliga.CrearLigaUseCase;
import radar_de_aprendiz.usecase.listarligas.ListarLigasUseCase;
import radar_de_aprendiz.usecase.traerliga.TraerLigaUseCase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
public class Handler {
    private final WebClient webClient;
    private final CrearLigaUseCase crearLigaUseCase;
    private final ListarLigasUseCase listarLigasUseCase;
    private final TraerLigaUseCase traerLigaUseCase;
    static Mono<ServerResponse> notFound = ServerResponse.notFound().build();

    public Handler(WebClient.Builder webClientBuilder, CrearLigaUseCase crearLigaUseCase, ListarLigasUseCase listarLigasUseCase, TraerLigaUseCase traerLigaUseCase) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8090").build();
        this.crearLigaUseCase = crearLigaUseCase;
        this.listarLigasUseCase = listarLigasUseCase;
        this.traerLigaUseCase = traerLigaUseCase;
    }
    public Mono<ServerResponse> saveLiga(ServerRequest serverRequest) {
        Mono<Liga> ligaMono = serverRequest.bodyToMono(Liga.class);
        return ligaMono.flatMap(liga ->
                ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearLigaUseCase.save(liga), Liga.class));
    }
    public Mono<ServerResponse> getLigas(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listarLigasUseCase.listLigas(), Liga.class);
    }
    public Mono<ServerResponse> getLiga(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        Mono<Liga> personaMono = traerLigaUseCase.traerLiga(id);

        return personaMono.flatMap(persona ->
                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(fromValue(persona)))
                .switchIfEmpty(notFound);
    }
    public Flux<?> getAprendices(){
        return this.webClient.get().uri("/api/collections/aprendices/records")
                .retrieve().bodyToFlux(Object.class);
    }
}
