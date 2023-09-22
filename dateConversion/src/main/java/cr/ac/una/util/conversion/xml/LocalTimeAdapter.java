package cr.ac.una.util.conversion.xml;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Georges Alfaro S.
 */
public class LocalTimeAdapter extends XmlAdapter<String, LocalTime> {

    @Override
    public LocalTime unmarshal(String v) throws Exception {
        return LocalTime.parse(v, DateTimeFormatter.ISO_TIME);
    }

    @Override
    public String marshal(LocalTime v) throws Exception {
        return v.format(DateTimeFormatter.ISO_TIME);
    }

}
