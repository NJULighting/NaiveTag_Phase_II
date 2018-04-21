package top.minecode.json;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

/**
 * Created on 2018/4/21.
 * Description:
 *
 * @author iznauy
 */
public class LocalDateSerializer implements JsonSerializer<LocalDate> {

    @Override
    public JsonElement serialize(LocalDate localDate, Type type, JsonSerializationContext jsonSerializationContext) {
        StringBuilder sb = new StringBuilder();
        sb.append(localDate.getYear());
        sb.append(" ");
        sb.append(localDate.getMonthValue());
        sb.append(" ");
        sb.append(localDate.getDayOfMonth());
        return new JsonPrimitive(sb.toString());
    }


}