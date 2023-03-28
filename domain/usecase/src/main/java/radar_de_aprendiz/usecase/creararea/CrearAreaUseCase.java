package radar_de_aprendiz.usecase.creararea;

import lombok.RequiredArgsConstructor;
import radar_de_aprendiz.model.area.Area;
import radar_de_aprendiz.model.radar.Radar;
import radar_de_aprendiz.model.radar.gateways.RadarRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearAreaUseCase {

    private final RadarRepository radarRepository;

    public Mono<Radar>crearArea(Area area)
    {
        return  radarRepository.AgregarArea(area.getRadarNombre(), area);
    }
}
