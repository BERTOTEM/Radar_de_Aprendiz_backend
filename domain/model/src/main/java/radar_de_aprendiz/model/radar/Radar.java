package radar_de_aprendiz.model.radar;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import radar_de_aprendiz.model.area.Area;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Radar {

    private String nombre;
    private List<Area> areas;

}
