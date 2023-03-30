package radar_de_aprendiz.usecase.listarradares;

import lombok.RequiredArgsConstructor;
import radar_de_aprendiz.model.radar.Radar;
import radar_de_aprendiz.model.radar.gateways.RadarRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ListarRadaresUseCase {
    private final RadarRepository radarRepository;

    public Flux<Radar> apply() {
        return radarRepository.ListarRadares();
    }
}
