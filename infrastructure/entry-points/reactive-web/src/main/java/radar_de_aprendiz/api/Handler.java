package radar_de_aprendiz.api;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;


import radar_de_aprendiz.model.aprendiz.Aprendiz;
import radar_de_aprendiz.model.area.Area;
import radar_de_aprendiz.model.radar.Radar;
import radar_de_aprendiz.usecase.actualizararea.ActualizarAreaUseCase;
import radar_de_aprendiz.usecase.agregaraprendiz.AgregarAprendizUseCase;
import radar_de_aprendiz.usecase.crearaprendiz.CrearAprendizUseCase;
import radar_de_aprendiz.usecase.creararea.CrearAreaUseCase;
import radar_de_aprendiz.usecase.crearradar.CrearRadarUseCase;

import radar_de_aprendiz.usecase.eliminarradar.EliminarRadarUseCase;

import radar_de_aprendiz.usecase.eliminarliga.EliminarLigaUseCase;

import radar_de_aprendiz.usecase.listaraprendices.ListarAprendicesUseCase;
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


import java.util.List;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@AllArgsConstructor
@Component
public class Handler {

    private final CrearLigaUseCase crearLigaUseCase;
    private final ListarLigasUseCase listarLigasUseCase;
    private final TraerLigaUseCase traerLigaUseCase;

    private final EliminarLigaUseCase eliminarLigaUseCase;
    private final AgregarAprendizUseCase agregarAprendizUseCase;
    private final CrearAprendizUseCase crearAprendizUseCase;
    private final ListarAprendicesUseCase listarAprendicesUseCase;
    private final CrearAreaUseCase crearAreaUseCase;
    private final CrearRadarUseCase crearRadarUseCase;
    private final ListarRadaresUseCase listarRadaresUseCase;
    private final ListarRadarUseCase listarRadarUseCase;
    private  final EliminarRadarUseCase eliminarRadarUseCase;

    private  final ActualizarAreaUseCase actualizarAreaUseCase;

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

    public Mono<ServerResponse> updateLiga(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        Mono<Liga> updatedLiga = serverRequest.bodyToMono(Liga.class).log()
                .flatMap(liga -> traerLigaUseCase.traerLiga(String.valueOf(id)).log()
                        .flatMap(oldliga ->{
                            oldliga.setCoach(liga.getCoach());
                            oldliga.setAnio(liga.getAnio());
                            return crearLigaUseCase.save(oldliga).log();
                        }));
        return updatedLiga.flatMap(liga -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue(liga)))
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> deleteLiga(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(eliminarLigaUseCase.eliminarLiga(id), Void.class);
    }

    public Mono<ServerResponse> AgregarAprendiz(ServerRequest serverRequest) {
        String nombre = serverRequest.pathVariable("nombre");
        Mono<Aprendiz> aprendizMono = serverRequest.bodyToMono(Aprendiz.class);
        return aprendizMono.flatMap(aprendiz -> ServerResponse.
                status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON)
                .body(agregarAprendizUseCase.agregarAprendiz(nombre, aprendiz), Aprendiz.class));
    }
    public Mono<ServerResponse> crearAprendiz(ServerRequest serverRequest) {
        Mono<Aprendiz> aprendizMono = serverRequest.bodyToMono(Aprendiz.class);
        return aprendizMono.flatMap(aprendiz ->
                ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearAprendizUseCase.crearAprendiz(aprendiz), Aprendiz.class));
    }
    public Mono<ServerResponse> listarAprendices(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listarAprendicesUseCase.listar(), Aprendiz.class);
    }

    public Mono<ServerResponse> EliminarRadar(ServerRequest serverRequest) {
        String nombre = serverRequest.pathVariable("nombre");

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(eliminarRadarUseCase.EliminarRadar(nombre), Void.class);

    }

    public Mono<ServerResponse> ActualizarArea(ServerRequest serverRequest) {
        String numero = serverRequest.pathVariable("numero");
        Mono<Area> areaMono = serverRequest.bodyToMono(Area.class);
        return areaMono.flatMap(area -> ServerResponse.
                status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON)
                .body(actualizarAreaUseCase.ActualizarArea(area,numero), Area.class));
    }



}
