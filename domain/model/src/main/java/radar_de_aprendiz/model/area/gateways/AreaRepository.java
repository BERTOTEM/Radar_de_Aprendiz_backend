package radar_de_aprendiz.model.area.gateways;

import radar_de_aprendiz.model.area.Area;
import radar_de_aprendiz.model.radar.Radar;
import reactor.core.publisher.Mono;

public interface AreaRepository {
    Mono<Area> createArea(Area area);
}
