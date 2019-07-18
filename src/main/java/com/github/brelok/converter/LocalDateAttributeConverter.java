package com.github.brelok.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate locDate) {
        return locDate == null ? null : Date.valueOf(locDate);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date sqlDate) {
        return sqlDate == null ? null : sqlDate.toLocalDate();
    }
}

//@Override
//    public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
//        return locDateTime == null ? null : Timestamp.valueOf(locDateTime);
//    }
//
//    @Override
//    public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
//        return sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime();
//    }


