package radar_de_aprendiz.usecase.listaraprendices;

import lombok.RequiredArgsConstructor;
import radar_de_aprendiz.model.aprendiz.Aprendiz;
import radar_de_aprendiz.model.liga.gateways.LigaRepository;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarAprendicesUseCase {
    private final LigaRepository ligaRepository;

    public Flux<Aprendiz> listar(){
        return ligaRepository.listarAprendices();
    }
}
