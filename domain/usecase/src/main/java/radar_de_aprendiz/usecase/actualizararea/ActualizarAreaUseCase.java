package radar_de_aprendiz.usecase.actualizararea;

import lombok.RequiredArgsConstructor;
import radar_de_aprendiz.model.area.Area;
import radar_de_aprendiz.model.radar.Radar;
import radar_de_aprendiz.model.radar.gateways.RadarRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarAreaUseCase {
    private final RadarRepository radarRepository;

    public Mono<Radar> ActualizarArea( Area area, String numero)
    {
        return  radarRepository.ActualizarArea(area.getRadarNombre(),area,numero);
    }
}
