package radar_de_aprendiz.usecase.crearradar;

import lombok.RequiredArgsConstructor;
import radar_de_aprendiz.model.area.Area;
import radar_de_aprendiz.model.radar.Radar;
import radar_de_aprendiz.model.radar.gateways.RadarRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearRadarUseCase {
    private final RadarRepository radarRepository;

    public Mono<Radar> crearRadar(Radar radar)
    {
        return radarRepository.createRadar(radar);
    }
}
