package com.dak.api.dto;

import com.dak.domain.Coordinates;
import com.dak.api.resolver.DateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Saji
 */
@XmlRootElement(name = "report")
public class WeatherReportDTO implements Serializable {
    private Date time;
    private CoordinatesDTO coords;
    private String code;
    private String message;
    private String rating;

    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public CoordinatesDTO getCoords() {
        return coords;
    }

    public void setCoords(CoordinatesDTO coords) {
        this.coords = coords;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @XmlElement(name = "varX-Rating")
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "WeatherReport{" +
                "time=" + time +
                ", coords=" + coords +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
