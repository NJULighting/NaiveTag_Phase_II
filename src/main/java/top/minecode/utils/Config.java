package top.minecode.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created on 2018/4/15.
 * Description:
 * @author Liao
 */
public enum Config {
    INSTANCE;

    private JsonObject configuration;
    private Gson gson = new Gson();

    Config() {
        JsonParser parser = new JsonParser();
        Resource resource = new ClassPathResource("config.json");
        try {
            Reader reader = new InputStreamReader(resource.getInputStream());
            configuration = parser.parse(reader).getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRawFileName() {
        return configuration.get("rawFilePath").getAsString();
    }

    public String getUnZipFileBasePath() {
        return configuration.get("unZipFileBasePath").getAsString();
    }

    public List<String> getSupportFormats() {
        Type type = new TypeToken<List<String>>() {}.getType();
        return gson.fromJson(configuration.get("supportFormats"), type);
    }

    public boolean isWithClassesType(int type) {
        return getWithClassesTypes().contains(type);
    }

    public List<Integer> getWithClassesTypes() {
        return getTaskTypes("withClassesTask");
    }

    public List<Integer> getWithoutClassesTypes() {
        return getTaskTypes("withoutClassesTask");
    }

    public String getLogicPath(String absolutePath) {
        int index = absolutePath.indexOf(getRawFileName());
        return absolutePath.substring(index);
    }

    public int getThirdLevelTaskImagesNum() {
        return configuration.get("thirdLevelTaskImagesNum").getAsInt();
    }

    private List<Integer> getTaskTypes(String category) {
        Type type = new TypeToken<List<Integer>>() {}.getType();
        return gson.fromJson(configuration.get(category), type);
    }
}
