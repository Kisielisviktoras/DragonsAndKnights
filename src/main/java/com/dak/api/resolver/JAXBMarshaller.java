package com.dak.api.resolver;

import com.dak.api.dto.WeatherReportDTO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.InputStream;

/**
 * @author Saji
 */
public class JAXBMarshaller {

    private JAXBContext context;
    private Class[] types = {WeatherReportDTO.class};

    public JAXBMarshaller() throws Exception {
        this.context = JAXBContext.newInstance(types);
    }

    public Object unmarshall(InputStream entityStream) {
        try {
            return context.createUnmarshaller().unmarshal(entityStream);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}
