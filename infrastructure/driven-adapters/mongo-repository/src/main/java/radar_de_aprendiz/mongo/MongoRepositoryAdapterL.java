package radar_de_aprendiz.mongo;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import radar_de_aprendiz.model.aprendiz.Aprendiz;
import radar_de_aprendiz.model.liga.Liga;
import radar_de_aprendiz.model.liga.gateways.LigaRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public class MongoRepositoryAdapterL implements LigaRepository {
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
    public Mono<Void> deleteById(String id) {
        var query = new Query(Criteria.where("id").is(id));
        if(id!=null){
            return template.remove(query, Liga.class).then();
        }else{
            return Mono.empty();
        }
    }

    @Override
    public Flux<Liga> getAll(){
        return template.findAll(Liga.class);
    }
    @Override
    public Mono<Liga> addAprendiz(String nombreLiga, Aprendiz aprendiz){
        Query query = new Query(Criteria.where("nombre").is(nombreLiga));
        return template.findOne(query, Liga.class).flatMap(liga -> {
            if(liga!=null){
                Update update = new Update().addToSet("aprendices", aprendiz);
                return template.updateFirst(query, update, Liga.class).then(template.findOne(query, Liga.class));
            }else{
                return Mono.empty();
            }
        });
    }
    @Override
    public Mono<Aprendiz> crearAprendiz(Aprendiz aprendiz) {
        return template.save(aprendiz);
    }
    @Override
    public Flux<Aprendiz> listarAprendices() {
        return template.findAll(Aprendiz.class);
    }
}
