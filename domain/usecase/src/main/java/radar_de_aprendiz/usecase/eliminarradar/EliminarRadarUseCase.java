package radar_de_aprendiz.usecase.eliminarradar;

import lombok.RequiredArgsConstructor;
import radar_de_aprendiz.model.radar.gateways.RadarRepository;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RequiredArgsConstructor
public class EliminarRadarUseCase {
    private final RadarRepository radarRepository;
    public Mono<Void> EliminarRadar(String nombre) {
        Objects.requireNonNull(nombre, "nombre is required");
        return radarRepository.EliminarRadares(nombre);
    }

}
