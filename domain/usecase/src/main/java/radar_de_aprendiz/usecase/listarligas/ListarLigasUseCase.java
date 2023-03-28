package radar_de_aprendiz.usecase.listarligas;

import lombok.RequiredArgsConstructor;
import radar_de_aprendiz.model.liga.Liga;
import radar_de_aprendiz.model.liga.gateways.LigaRepository;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarLigasUseCase {
    private final LigaRepository ligaRepository;
    public Flux<Liga> listLigas() {
        return ligaRepository.getAll();
    }
}
