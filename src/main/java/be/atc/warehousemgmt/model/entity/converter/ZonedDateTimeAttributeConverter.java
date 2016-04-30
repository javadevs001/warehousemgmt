package be.atc.warehousemgmt.model.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author ahmed idoumhaidi
 * @since 24/04/16
 */

@Converter(autoApply = true)
public class ZonedDateTimeAttributeConverter implements AttributeConverter<ZonedDateTime, Timestamp> {

    @Override
    public java.sql.Timestamp convertToDatabaseColumn(ZonedDateTime entityValue) {
        return Timestamp.from(entityValue.toInstant());
    }

    @Override
    public ZonedDateTime convertToEntityAttribute(java.sql.Timestamp databaseValue) {
        LocalDateTime localDateTime = databaseValue.toLocalDateTime();
        return localDateTime.atZone(ZoneId.systemDefault());
    }
}
