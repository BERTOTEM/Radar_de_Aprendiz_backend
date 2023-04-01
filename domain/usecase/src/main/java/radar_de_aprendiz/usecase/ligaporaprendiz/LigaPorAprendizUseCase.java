package radar_de_aprendiz.usecase.ligaporaprendiz;

import lombok.RequiredArgsConstructor;
import radar_de_aprendiz.model.aprendiz.Aprendiz;
import radar_de_aprendiz.model.liga.Liga;
import radar_de_aprendiz.model.liga.gateways.LigaRepository;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class LigaPorAprendizUseCase {
    private final LigaRepository ligaRepository;

    public Flux<Liga> LigaPorAprendiz(String correo){
        return ligaRepository.ligaPorAprendiz(correo);
    }
}
