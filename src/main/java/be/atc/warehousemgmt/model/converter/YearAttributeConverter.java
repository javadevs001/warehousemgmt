package be.atc.warehousemgmt.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Year;


/**
 * @author aidoumhaidi
 * @since 29/01/2016
 */

@Converter(autoApply = true)
public class YearAttributeConverter implements AttributeConverter<Year, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Year year) {
        return year.getValue();
    }

    @Override
    public Year convertToEntityAttribute(Integer year) {
        return Year.of(year);
    }
}
