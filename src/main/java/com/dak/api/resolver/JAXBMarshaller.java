package com.dak.api.resolver;

import com.dak.api.dto.WeatherReportDTO;
import com.dak.domain.WeatherReport;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.InputStream;

/**
 * @author Saji
 */
public class JAXBMarshaller {

    private JAXBContext context;
    private Class[] types = { WeatherReportDTO.class};

    public JAXBMarshaller() throws Exception {
        this.context = JAXBContext.newInstance(types);
    }

    public Object unmarshal(InputStream entityStream) {
        try {
            return context.createUnmarshaller().unmarshal(entityStream);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}
