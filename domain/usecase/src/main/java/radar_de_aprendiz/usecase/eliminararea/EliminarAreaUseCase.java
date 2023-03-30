package radar_de_aprendiz.usecase.eliminararea;

import lombok.RequiredArgsConstructor;
import radar_de_aprendiz.model.radar.gateways.RadarRepository;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RequiredArgsConstructor
public class EliminarAreaUseCase {

    private final RadarRepository radarRepository;

    public Mono<Void> EliminarArea(String nombre,String index) {
        Objects.requireNonNull(nombre, "nombre is required");
        return radarRepository.EliminarArea(index,nombre);
    }
}
