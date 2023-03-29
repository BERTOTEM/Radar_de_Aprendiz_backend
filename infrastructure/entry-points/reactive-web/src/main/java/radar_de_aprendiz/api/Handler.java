package radar_de_aprendiz.api;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;


import radar_de_aprendiz.model.aprendiz.Aprendiz;
import radar_de_aprendiz.model.area.Area;
import radar_de_aprendiz.model.radar.Radar;
import radar_de_aprendiz.usecase.creararea.CrearAreaUseCase;
import radar_de_aprendiz.usecase.crearradar.CrearRadarUseCase;
import radar_de_aprendiz.usecase.listarradar.ListarRadarUseCase;
import radar_de_aprendiz.usecase.listarradares.ListarRadaresUseCase;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import radar_de_aprendiz.model.liga.Liga;
import radar_de_aprendiz.usecase.crearliga.CrearLigaUseCase;
import radar_de_aprendiz.usecase.listarligas.ListarLigasUseCase;
import radar_de_aprendiz.usecase.traerliga.TraerLigaUseCase;


import reactor.core.publisher.Mono;



import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
public class Handler {

    private final WebClient webClient;
    private final CrearLigaUseCase crearLigaUseCase;
    private final ListarLigasUseCase listarLigasUseCase;
    private final TraerLigaUseCase traerLigaUseCase;
    private final CrearAreaUseCase crearAreaUseCase;
    private final CrearRadarUseCase crearRadarUseCase;
    private final ListarRadaresUseCase listarRadaresUseCase;
    private final ListarRadarUseCase listarRadarUseCase;

    public Handler(WebClient.Builder webClientBuilder, CrearLigaUseCase crearLigaUseCase,
                   ListarLigasUseCase listarLigasUseCase, TraerLigaUseCase traerLigaUseCase,
                   CrearAreaUseCase crearAreaUseCase, CrearRadarUseCase crearRadarUseCase,
                   ListarRadaresUseCase listarRadaresUseCase, ListarRadarUseCase listarRadarUseCase) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8090").build();
        this.crearLigaUseCase = crearLigaUseCase;
        this.listarLigasUseCase = listarLigasUseCase;
        this.traerLigaUseCase = traerLigaUseCase;
        this.crearAreaUseCase = crearAreaUseCase;
        this.crearRadarUseCase = crearRadarUseCase;
        this.listarRadaresUseCase = listarRadaresUseCase;
        this.listarRadarUseCase = listarRadarUseCase;

    }

    static Mono<ServerResponse> notFound = ServerResponse.notFound().build();

    public Mono<ServerResponse> AgregarArea(ServerRequest serverRequest) {
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
    public Mono<ServerResponse> getAprendices(ServerRequest serverRequest) {
        var obj = this.webClient.get().uri("/api/collections/aprendices/records")
        .retrieve().bodyToMono(Object.class);
            return obj.flatMap(aprendices ->
                ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue(aprendices)));
    }

}
