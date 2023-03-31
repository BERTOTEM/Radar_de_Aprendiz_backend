package radar_de_aprendiz.model.area;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Area {
    private String area;
    private String radarNombre;
    private String descriptor;
    private Double factual;
    private Double conceptual;
    private Double procedimental;
    private Double metacognitivo;
    private Double nivel;
}
