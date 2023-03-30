package radar_de_aprendiz.model.radar.gateways;

import radar_de_aprendiz.model.area.Area;
import radar_de_aprendiz.model.radar.Radar;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RadarRepository {
    Mono<Radar> createRadar(Radar radar);
    Mono<Radar> AgregarArea(String nombre,Area area);
    Mono<Radar> ListarRadar(String nombre);
    Flux<Radar> ListarRadares();
    Mono<Void> EliminarRadares(String nombre);
    Mono<Void> EliminarArea(String index,String nombreRadar);
    Mono<Radar>ActualizarArea(String nombreRadar, Area area, String numero);

}
