package radar_de_aprendiz.model.aprendiz;
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
public class Aprendiz {
    private String id;
    private String collectionId;
    private String collectionName;
    private String created;
    private String updated;

    private String nombre;
    private List<?> calificaciones;
}
