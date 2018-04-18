package top.minecode.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on 2018/3/17.
 * Description:
 * @author iznauy
 */
public class TaskConfigFileValidator {

    private static final int TOTAL_MARK = 100;
    private static final int SINGLE_SQUARE_MARK = 200;
    private static final int MULTI_SQUARE_MARK = 300;
    private static final int AREA_MARK = 400;
    private static final int TOTAL_DESCRIBE = 101;
    private static final int SINGLE_SQUARE_DESCRIBE = 201;
    private static final int MULTI_SQUARE_DESCRIBE = 301;
    private static final int AREA_DESCRIBE = 401;
    private static final String TASK_TYPE = "taskType";
    private static final String FORMAT = "format";
    private static final String DESCRIPTION = "description";
    private static final String CLASSES = "classes";
    private static final Set<Integer> WITH_CLASS_PROBLEMS = new HashSet<>();
    private static final Set<Integer> WITHOUT_CLASS_PROBLEMS = new HashSet<>();

    static {
        WITH_CLASS_PROBLEMS.add(TOTAL_MARK);
        WITH_CLASS_PROBLEMS.add(SINGLE_SQUARE_MARK);
        WITH_CLASS_PROBLEMS.add(MULTI_SQUARE_MARK);

        WITHOUT_CLASS_PROBLEMS.add(AREA_MARK);
        WITHOUT_CLASS_PROBLEMS.add(TOTAL_DESCRIBE);
        WITHOUT_CLASS_PROBLEMS.add(SINGLE_SQUARE_DESCRIBE);
        WITHOUT_CLASS_PROBLEMS.add(MULTI_SQUARE_DESCRIBE);
        WITHOUT_CLASS_PROBLEMS.add(AREA_DESCRIBE);
    }

    private JsonObject json;

    public TaskConfigFileValidator(Reader reader) {
        JsonParser parser = new JsonParser();
        json = parser.parse(reader).getAsJsonObject();
    }

    public Result checkResult() {
        if (json == null)
            return Result.invalid;

        // If there're more than one tasks which mean the requester
        // want to have multiple second level tasks
        if (json.isJsonArray()) {
            for (JsonElement jsonElement : json.getAsJsonArray()) {
                if (!isValid(jsonElement.getAsJsonObject()))
                    return Result.invalid;
            }
        } else if (isValid(json.getAsJsonObject())){
            // Only one type of task needed
            return Result.valid;
        }

        return Result.invalid;
    }

    private boolean isValid(JsonObject json) {
        // Check whether the file lacks some property
        if (getString(json, FORMAT) == null || getString(json, DESCRIPTION) == null)
            return false;

        int taskType = getInteger(json, TASK_TYPE);

        // Check whether the task type is valid, and if it's a task with classes, check
        // if it contains classes
        return WITHOUT_CLASS_PROBLEMS.contains(taskType) ||
                (WITH_CLASS_PROBLEMS.contains(taskType) && getStringList(json, CLASSES) != null);

    }

    private String getString(JsonObject json, String key) {
        return json.get(key).getAsString();
    }

    private int getInteger(JsonObject json, String key) {
        return json.get(key).getAsInt();
    }

    private List<String> getStringList(JsonObject json, String key) {
        JsonArray array = json.getAsJsonArray(key);
        List<String> list = new ArrayList<>();
        for (JsonElement element : array)
            list.add(element.getAsString());
        return list;
    }

    public enum Result {
        valid,
        invalid
    }
}
