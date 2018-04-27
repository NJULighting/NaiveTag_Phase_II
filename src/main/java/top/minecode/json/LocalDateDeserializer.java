package top.minecode.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalDate;

/**
 * Created on 2018/4/27.
 * Description:
 * @author Liao
 */
public class LocalDateDeserializer implements JsonDeserializer<LocalDate> {
    @Override
    public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        String time = jsonElement.getAsString();
        String[] times = time.split("-");
        int year = Integer.getInteger(times[0]);
        int month = Integer.getInteger(times[1]);
        int day = Integer.getInteger(times[2]);
        return LocalDate.of(year, month, day);
    }
}
