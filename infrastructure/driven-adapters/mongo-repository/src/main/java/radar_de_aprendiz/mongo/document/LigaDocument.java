package radar_de_aprendiz.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "liga")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LigaDocument {
    @Id
    private String id;
    private String nombre;
    private String periodo;
    private List<?> aprendices;
    private String coach;
    private String año;
    private String radar;
}
