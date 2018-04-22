package top.minecode.json;

import com.google.gson.*;
import top.minecode.domain.statistic.TimeNumberGraph;
import top.minecode.domain.statistic.TimeNumberGraph.GraphPoint;
import top.minecode.domain.statistic.WebStatisticInfo;

import java.lang.reflect.Type;

/**
 * Created on 2018/4/22.
 * Description:
 * @author Liao
 */
public class TimeNumberGraphSerializer implements JsonSerializer<GraphPoint> {

    @Override
    public JsonElement serialize(GraphPoint graphPoint, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();
        result.addProperty(graphPoint.getDate().toString(), graphPoint.getNumber());
        return result;
    }
}
