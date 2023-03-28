package radar_de_aprendiz.mongo;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import radar_de_aprendiz.model.liga.Liga;
import radar_de_aprendiz.model.liga.gateways.LigaRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapterL implements LigaRepository
// implements ModelRepository from domain
{
    private final ReactiveMongoTemplate template;
    public MongoRepositoryAdapterL(ReactiveMongoTemplate template) {
        this.template = template;
    }
    @Override
    public Mono<Liga> findById(String id) {
        var query = new Query(Criteria.where("id").is(id));
        return template.findOne(query,Liga.class);
    }
    @Override
    public Mono<Liga> save(Liga liga) {
        return template.save(liga);
    }
    @Override
    public Flux<Liga> getAll(){
        return template.findAll(Liga.class);
    }
}
