package radar_de_aprendiz.model.radar.gateways;

import radar_de_aprendiz.model.radar.Radar;
import reactor.core.publisher.Mono;

public interface RadarRepository {
    Mono<Radar> createPerson(Radar radar);
}
