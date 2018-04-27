package top.minecode.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import top.minecode.domain.statistic.TimeNumberGraph;
import top.minecode.domain.tag.TagDeserializer;
import top.minecode.domain.tag.TagResult;
import top.minecode.domain.tag.TagSerializer;

import java.time.LocalDate;

/**
 * Created on 2018/4/2.
 * Description:
 *
 * @author iznauy
 */
public class JsonConfig {

    private static Gson gson;

    public static Gson getGson() {
        if (gson == null)
            gson = new GsonBuilder()
                    .serializeNulls()
                    .setPrettyPrinting()
                    .registerTypeAdapter(TagResult.class, new TagSerializer())
                    .registerTypeAdapter(TagResult.class, new TagDeserializer())
                    .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                    .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                    .registerTypeAdapter(TimeNumberGraph.GraphPoint.class, new TimeNumberGraphSerializer())
                    .create();
        return gson;
    }

}
