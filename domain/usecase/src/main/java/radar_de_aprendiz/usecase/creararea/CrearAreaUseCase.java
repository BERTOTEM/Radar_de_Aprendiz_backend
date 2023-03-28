package radar_de_aprendiz.usecase.creararea;

import lombok.RequiredArgsConstructor;
import radar_de_aprendiz.model.area.Area;
import radar_de_aprendiz.model.area.gateways.AreaRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearAreaUseCase {

    private final AreaRepository areaRepository;

    public Mono<Area>crearArea(Area area)
    {
        return areaRepository.createArea(area);
    }
}
