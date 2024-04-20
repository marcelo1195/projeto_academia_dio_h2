package dio.projeto_academia_dio_h2_test.infra.sers;



import dio.projeto_academia_dio_h2_test.infra.sers.deser.LocalDateDeserializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import dio.projeto_academia_dio_h2_test.infra.sers.deser.LocalDateTimeDeserializer;
import dio.projeto_academia_dio_h2_test.infra.sers.ser.LocalDateSerializer;
import dio.projeto_academia_dio_h2_test.infra.sers.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * @author Venilton Falvo Jr
 */
@Configuration
public class ObjectMapperConfig implements Jackson2ObjectMapperBuilderCustomizer {

    @Override
    public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
        jacksonObjectMapperBuilder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .serializerByType(LocalDate.class, new LocalDateSerializer())
                .serializerByType(LocalDateTime.class, new LocalDateSerializer())
                .deserializerByType(LocalDate.class, new LocalDateDeserializer())
                .deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer());
    }
}