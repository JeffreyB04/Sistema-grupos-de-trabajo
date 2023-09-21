package cr.ac.una.util.conversion.xml;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Georges Alfaro S.
 */
public class SqlDateAdapter extends XmlAdapter<String, java.sql.Date> {

    @Override
    public String marshal(java.sql.Date date) {
        return FMT.format(date);
    }

    @Override
    public java.sql.Date unmarshal(String date) throws ParseException {
        return new java.sql.Date(FMT.parse(date).getTime());
    }

    private static final DateFormat FMT = new SimpleDateFormat("yyyy-MM-dd");
}
