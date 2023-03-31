package radar_de_aprendiz.model.liga.gateways;

import radar_de_aprendiz.model.aprendiz.Aprendiz;
import radar_de_aprendiz.model.liga.Liga;
import radar_de_aprendiz.model.radar.Radar;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LigaRepository {
    Mono<Liga> findById(String id);
    Mono<Liga> save(Liga liga);
    Mono<Void> deleteById(String id);
    Flux<Liga> getAll();
    Mono<Liga> addAprendiz(String nombreLiga, Aprendiz aprendiz);

    Mono<Liga> addRadar(String nombre, Radar radar);

    Mono<Aprendiz> crearAprendiz(Aprendiz aprendiz);
    Flux<Aprendiz> listarAprendices();
}
