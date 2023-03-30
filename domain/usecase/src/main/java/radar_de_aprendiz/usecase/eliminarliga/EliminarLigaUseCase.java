package radar_de_aprendiz.usecase.eliminarliga;

import lombok.RequiredArgsConstructor;
import radar_de_aprendiz.model.liga.Liga;
import radar_de_aprendiz.model.liga.gateways.LigaRepository;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RequiredArgsConstructor
public class EliminarLigaUseCase {

    private final LigaRepository ligaRepository;

    public Mono<Void> eliminarLiga(String id) {
        Objects.requireNonNull(id, "Id is required");
        return ligaRepository.deleteById(id);
    }
}





