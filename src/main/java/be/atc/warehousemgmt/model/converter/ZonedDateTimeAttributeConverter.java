package be.atc.warehousemgmt.model.converter;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author aidoumhaidi
 * @since 27/01/16
 */

@Converter(autoApply = true)
public class ZonedDateTimeAttributeConverter implements AttributeConverter<ZonedDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(ZonedDateTime zonedDateTime) {
        return Timestamp.from(zonedDateTime.toInstant());
    }

    @Override
    public ZonedDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
        LocalDateTime localDateTime = sqlTimestamp.toLocalDateTime();
        return localDateTime.atZone(ZoneId.systemDefault());
    }
}
