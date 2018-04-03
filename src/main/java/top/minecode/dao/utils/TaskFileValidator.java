package top.minecode.dao.utils;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;

/**
 * Created on 2018/4/3.
 * Description:
 *
 * @author iznauy
 */
public class TaskFileValidator {

    private JsonArray json;

    public TaskFileValidator(File taskFile) {
        try {
            JsonParser parser = new JsonParser();
            json = parser.parse(new FileReader(taskFile)).getAsJsonArray();
        } catch (Exception e) {
            e.printStackTrace();
            json = null;
        }
    }

    public boolean validTask() {
        if (json == null)
            return false;
        return true;
    }

}
