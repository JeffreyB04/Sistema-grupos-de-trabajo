package cr.ac.una.util.conversion.xml;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author Georges Alfaro S.
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v, DATE_FORMAT);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.format(DATE_FORMAT);
    }

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final Locale CR_LOCALE = new Locale("es", "CR");
    public static final DateTimeFormatter DATE_FORMAT
            = DateTimeFormatter.ofPattern(DATE_PATTERN, CR_LOCALE);
}
