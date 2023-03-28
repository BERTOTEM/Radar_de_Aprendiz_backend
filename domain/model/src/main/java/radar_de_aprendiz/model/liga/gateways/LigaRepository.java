package radar_de_aprendiz.model.liga.gateways;

import radar_de_aprendiz.model.liga.Liga;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LigaRepository {
    Mono<Liga> findById(String id);
    Mono<Liga> save(Liga liga);
    Flux<Liga> getAll();
}
