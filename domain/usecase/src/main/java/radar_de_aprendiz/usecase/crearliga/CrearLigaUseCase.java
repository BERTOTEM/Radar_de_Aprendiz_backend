package radar_de_aprendiz.usecase.crearliga;

import lombok.RequiredArgsConstructor;
import radar_de_aprendiz.model.liga.Liga;
import radar_de_aprendiz.model.liga.gateways.LigaRepository;
import radar_de_aprendiz.model.radar.Radar;
import radar_de_aprendiz.model.radar.gateways.RadarRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearLigaUseCase {
    private final LigaRepository ligaRepository;
    public Mono<Liga> save(Liga liga){
        return ligaRepository.save(liga);
    }
}
