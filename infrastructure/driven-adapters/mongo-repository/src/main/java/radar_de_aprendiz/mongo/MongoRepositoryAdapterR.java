package radar_de_aprendiz.mongo;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import radar_de_aprendiz.model.area.Area;
import radar_de_aprendiz.model.area.gateways.AreaRepository;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapterR implements AreaRepository

{
    private final ReactiveMongoTemplate template;

    public MongoRepositoryAdapterR(ReactiveMongoTemplate template) {
        this.template = template;
    }

    @Override
    public Mono<Area> createArea(Area area) {
        return template.save(area);
    }
}
