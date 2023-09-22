package cr.ac.una.util.conversion.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Georges Alfaro S.
 */
public class SqlDateTypeAdapter implements JsonSerializer<java.sql.Date>, JsonDeserializer<java.sql.Date> {

    @Override
    public JsonElement serialize(final java.sql.Date date, final Type typeOfSrc,
            final JsonSerializationContext context) {
        return new JsonPrimitive(FMT.format(date));
    }

    @Override
    public java.sql.Date deserialize(final JsonElement json, final Type typeOfT,
            final JsonDeserializationContext context) throws JsonParseException {
        try {
            return new java.sql.Date(FMT.parse(json.getAsString()).getTime());
        } catch (ParseException ex) {
            throw new JsonParseException(ex.getMessage());
        }
    }

    private static final DateFormat FMT = new SimpleDateFormat("yyyy-MM-dd");
}
