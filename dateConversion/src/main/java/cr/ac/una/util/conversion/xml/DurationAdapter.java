package cr.ac.una.util.conversion.xml;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.Duration;

/**
 *
 * @author Georges Alfaro S.
 */
public class DurationAdapter extends XmlAdapter<String, Duration> {

    @Override
    public Duration unmarshal(String v) throws Exception {
        return Duration.parse(v);
    }

    @Override
    public String marshal(Duration v) throws Exception {
        return v.toString();
    }

}
