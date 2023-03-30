package radar_de_aprendiz.usecase.agregaraprendiz;

import lombok.RequiredArgsConstructor;
import radar_de_aprendiz.model.aprendiz.Aprendiz;
import radar_de_aprendiz.model.liga.Liga;
import radar_de_aprendiz.model.liga.gateways.LigaRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AgregarAprendizUseCase {
    private final LigaRepository ligaRepository;
    public Mono<Liga> agregarAprendiz(String nombre, Aprendiz aprendiz){
        return ligaRepository.addAprendiz(nombre, aprendiz);
    }
}
