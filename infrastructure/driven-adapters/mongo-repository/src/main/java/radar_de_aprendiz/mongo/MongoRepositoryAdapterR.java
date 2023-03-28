package radar_de_aprendiz.mongo;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;
import radar_de_aprendiz.model.area.Area;


import org.springframework.stereotype.Repository;
import radar_de_aprendiz.model.radar.Radar;
import radar_de_aprendiz.model.radar.gateways.RadarRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapterR implements RadarRepository

{
    private final ReactiveMongoTemplate template;

    public MongoRepositoryAdapterR(ReactiveMongoTemplate template) {
        this.template = template;
    }

    @Override
    public Mono<Radar> createRadar(Radar radar) {
        return template.save(radar);
    }


    @Override
    public Mono<Radar> AgregarArea(String nombre, Area area) {
        Query query = new Query(Criteria.where("nombre").is(nombre));
        Update update = new Update().addToSet("areas", area);
        return template.updateFirst(query, update, Radar.class)
                .flatMap(result -> template.findOne(query, Radar.class));
    }

    @Override
    public Mono<Radar> ListarRadar(String nombre) {
        var query = new Query(Criteria.where("nombre").is(nombre));
        return template.findOne(query,Radar.class);
    }

    @Override
    public Flux<Radar> ListarRadares() {
        return template.findAll(Radar.class);
    }

}
