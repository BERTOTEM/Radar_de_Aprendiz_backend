package radar_de_aprendiz.usecase.listarradar;

import lombok.RequiredArgsConstructor;
import radar_de_aprendiz.model.radar.Radar;
import radar_de_aprendiz.model.radar.gateways.RadarRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ListarRadarUseCase {
    private final RadarRepository radarRepository;

    public Mono<Radar> apply(String name) {
        return radarRepository.ListarRadar(name);

    }

}
