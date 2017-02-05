package com.dak.api.resolver;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Saji
 */
public class DateAdapter extends XmlAdapter<String, Date> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'z '('Z')'", Locale.ENGLISH);

    public Date unmarshal(String v) throws Exception {
        return dateFormat.parse(v);
    }

    public String marshal(Date v) throws Exception {
        return dateFormat.format(v);
    }
}
