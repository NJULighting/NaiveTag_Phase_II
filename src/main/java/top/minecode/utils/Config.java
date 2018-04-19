package top.minecode.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created on 2018/4/15.
 * Description:
 * @author Liao
 */
public enum Config {
    INSTANCE;

    private JsonObject json;

    Config() {
        JsonParser parser = new JsonParser();
        Resource resource = new ClassPathResource("config.json");
        try {
            Reader reader = new InputStreamReader(resource.getInputStream());
            json = parser.parse(reader).getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRawFilePath() {
        return json.get("rawFilePath").getAsString();
    }

    public String getUnZipFileBasePath() {
        return json.get("unZipFileBasePath").getAsString();
    }
}
