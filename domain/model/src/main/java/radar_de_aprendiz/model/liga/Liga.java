package radar_de_aprendiz.model.liga;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import radar_de_aprendiz.model.aprendiz.Aprendiz;
import radar_de_aprendiz.model.radar.Radar;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Liga {
    private String id;
    private String nombre;
    private String periodo;
    private List<Aprendiz> aprendices;
    private String coach;
    private String anio;
    private Radar radar;
}
