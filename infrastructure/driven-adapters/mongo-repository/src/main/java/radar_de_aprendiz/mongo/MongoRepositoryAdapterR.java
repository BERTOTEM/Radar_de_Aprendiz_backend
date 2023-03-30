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
        //Update update = new Update().addToSet("areas", area);
        return template.findOne(query, Radar.class)
                .flatMap(radar -> {
                    if (radar != null) {
                        // El radar existe, se agrega el área
                        Update update = new Update().addToSet("areas", area);
                        return template.updateFirst(query, update, Radar.class)
                                .then(template.findOne(query, Radar.class));
                    } else {
                        // El radar no existe, se devuelve un Mono vacío
                        return Mono.empty();
                    }
                });
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

    @Override
    public Mono<Void> EliminarRadares(String nombre) {
        var query = new Query(Criteria.where("nombre").is(nombre));
        return template.remove(query, Radar.class).then();
    }

}
