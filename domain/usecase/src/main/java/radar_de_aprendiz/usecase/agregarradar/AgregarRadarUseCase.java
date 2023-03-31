package radar_de_aprendiz.usecase.agregarradar;

import lombok.RequiredArgsConstructor;
import radar_de_aprendiz.model.aprendiz.Aprendiz;
import radar_de_aprendiz.model.liga.Liga;
import radar_de_aprendiz.model.liga.gateways.LigaRepository;
import radar_de_aprendiz.model.radar.Radar;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AgregarRadarUseCase {

    private final LigaRepository ligaRepository;
    public Mono<Liga> agregarRadar(String nombre, Radar radar){
        return ligaRepository.addRadar(nombre, radar);
    }
}
