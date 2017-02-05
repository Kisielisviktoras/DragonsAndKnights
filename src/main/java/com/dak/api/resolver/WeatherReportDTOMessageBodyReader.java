package com.dak.api.resolver;

import com.dak.api.dto.WeatherReportDTO;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @author Saji
 */
public class WeatherReportDTOMessageBodyReader implements MessageBodyReader<WeatherReportDTO> {

    private JAXBMarshaller marshaller;

    public WeatherReportDTOMessageBodyReader() throws Exception {
        marshaller = new JAXBMarshaller();
    }

    public boolean isReadable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return type == WeatherReportDTO.class;
    }

    public WeatherReportDTO readFrom(Class<WeatherReportDTO> aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> multivaluedMap, InputStream inputStream) throws IOException, WebApplicationException {
        return (WeatherReportDTO) marshaller.unmarshal(inputStream);
    }
}
