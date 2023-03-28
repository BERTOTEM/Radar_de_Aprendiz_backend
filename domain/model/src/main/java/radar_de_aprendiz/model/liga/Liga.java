package radar_de_aprendiz.model.liga;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private List<?> aprendices;
    private String coach;
    private String año;
    private String radar;
}
