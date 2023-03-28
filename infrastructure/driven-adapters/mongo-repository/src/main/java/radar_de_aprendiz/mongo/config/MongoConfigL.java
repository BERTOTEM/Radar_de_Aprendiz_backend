package radar_de_aprendiz.mongo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.ReactiveMongoClientFactory;
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.autoconfigure.mongo.MongoPropertiesClientSettingsBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongoConfigL {

    @Bean
    public MongoDBSecretL dbSecret(@Value("${spring.data.mongodb.uri}") String uri) {
        return MongoDBSecretL.builder()
                .uri(uri)
                .build();
    }

    @Bean
    public ReactiveMongoClientFactory mongoProperties(MongoDBSecretL secret) {
        MongoProperties properties = new MongoProperties();
        properties.setUri(secret.getUri());

        List<MongoClientSettingsBuilderCustomizer> list = new ArrayList<>();
        list.add(new MongoPropertiesClientSettingsBuilderCustomizer(properties));
        return new ReactiveMongoClientFactory(list);
    }
}
