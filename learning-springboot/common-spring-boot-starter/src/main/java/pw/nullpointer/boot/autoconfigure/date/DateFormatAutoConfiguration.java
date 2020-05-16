package pw.nullpointer.boot.autoconfigure.date;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.PackageVersion;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.TimeZone;

@Configuration
@EnableConfigurationProperties(DateFormatProperties.class)
@ConditionalOnProperty(prefix = "common.date-format", name = "enabled", matchIfMissing = false, havingValue = "true")
public class DateFormatAutoConfiguration {
    private DateFormatProperties dateFormatProperties;
    public DateFormatAutoConfiguration(DateFormatProperties dateFormatProperties) {
        this.dateFormatProperties = dateFormatProperties;
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return builder -> {
            builder.locale(Locale.CHINA);
            builder.timeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
            builder.simpleDateFormat(dateFormatProperties.getDatePattern());
            builder.modules(new JavaTimeModule());
        };
    }

    class JavaTimeModule extends SimpleModule {
        JavaTimeModule() {
            super(PackageVersion.VERSION);
            DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern(dateFormatProperties.getLocalDateTimePattern());
            DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern(dateFormatProperties.getLocalDatePattern());
            DateTimeFormatter localTimeFormatter = DateTimeFormatter.ofPattern(dateFormatProperties.getLocalTimePattern());

            this.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(localDateTimeFormatter));
            this.addSerializer(LocalDate.class, new LocalDateSerializer(localDateFormatter));
            this.addSerializer(LocalTime.class, new LocalTimeSerializer(localTimeFormatter));
            this.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(localDateTimeFormatter));
            this.addDeserializer(LocalDate.class, new LocalDateDeserializer(localDateFormatter));
            this.addDeserializer(LocalTime.class, new LocalTimeDeserializer(localTimeFormatter));
        }
    }
}
