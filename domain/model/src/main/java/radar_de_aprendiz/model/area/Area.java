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
    private String descriptor;
    private int factual;
    private int conceptual;
    private int procedimental;
    private int metacognitivo;
    private int nivel;
}
