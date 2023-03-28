package radar_de_aprendiz.usecase.traerliga;

import lombok.RequiredArgsConstructor;
import radar_de_aprendiz.model.liga.Liga;
import radar_de_aprendiz.model.liga.gateways.LigaRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class TraerLigaUseCase {
    private final LigaRepository ligaRepository;
    public Mono<Liga> traerLiga(String id){
        return ligaRepository.findById(id);
    }

}
