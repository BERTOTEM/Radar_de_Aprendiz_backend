package radar_de_aprendiz.usecase.crearaprendiz;

import lombok.RequiredArgsConstructor;
import radar_de_aprendiz.model.aprendiz.Aprendiz;
import radar_de_aprendiz.model.liga.gateways.LigaRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearAprendizUseCase {
    private final LigaRepository ligaRepository;
    public Mono<Aprendiz> crearAprendiz(Aprendiz aprendiz){
        return ligaRepository.crearAprendiz(aprendiz);
    }
}
