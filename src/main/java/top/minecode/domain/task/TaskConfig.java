package top.minecode.domain.task;

import com.google.gson.*;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

/**
 * Created on 2018/3/17.
 * Description:
 * @author iznauy
 */
public class TaskConfig implements Iterable<TaskInfo> {

    private static final int TOTAL_MARK = 100;
    private static final int SINGLE_SQUARE_MARK = 200;
    private static final int MULTI_SQUARE_MARK = 300;
    private static final int AREA_MARK = 400;
    private static final int TOTAL_DESCRIBE = 101;
    private static final int SINGLE_SQUARE_DESCRIBE = 201;
    private static final int MULTI_SQUARE_DESCRIBE = 301;
    private static final int AREA_DESCRIBE = 401;
    private static final int INVALID_TASK_TYPE = -1; // This'll be used when the file doesn't contain a taskType
    private static final String TASK_TYPE = "taskType";
    private static final String DESCRIPTION = "description";
    private static final String CLASSES = "classes";
    private static final Set<Integer> WITH_CLASS_PROBLEMS = new HashSet<>();
    private static final Set<Integer> WITHOUT_CLASS_PROBLEMS = new HashSet<>();

    static {
        WITH_CLASS_PROBLEMS.add(TOTAL_MARK);
        WITH_CLASS_PROBLEMS.add(SINGLE_SQUARE_MARK);
        WITH_CLASS_PROBLEMS.add(MULTI_SQUARE_MARK);
        WITH_CLASS_PROBLEMS.add(AREA_MARK);

        WITHOUT_CLASS_PROBLEMS.add(TOTAL_DESCRIBE);
        WITHOUT_CLASS_PROBLEMS.add(SINGLE_SQUARE_DESCRIBE);
        WITHOUT_CLASS_PROBLEMS.add(MULTI_SQUARE_DESCRIBE);
        WITHOUT_CLASS_PROBLEMS.add(AREA_DESCRIBE);
    }

    private JsonElement json;

    public TaskConfig(Reader reader) {
        JsonParser parser = new JsonParser();
        try {
            json = parser.parse(reader);
            reader.close();
        } catch (RuntimeException e) {
            json = null; // If there's syntax mistake
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TaskConfig(String filePath) throws FileNotFoundException {
        this(new FileReader(filePath));
    }

    public Result check() {
        if (json == null)
            return Result.invalid;

        // If there're more than one tasks which mean the requester
        // want to have multiple second level tasks
        if (json.isJsonArray()) {
            for (JsonElement jsonElement : json.getAsJsonArray()) {
                if (notValid(jsonElement.getAsJsonObject()))
                    return Result.invalid;
            }
        } else if (notValid(json.getAsJsonObject())) {
            // Only one type of task needed
            return Result.invalid;
        }

        return Result.valid;
    }

    private boolean notValid(JsonObject json) {
        // Check whether the file lacks some property
        if (getString(json, DESCRIPTION) == null)
            return true;

        int taskType = getInteger(json, TASK_TYPE);

        // Check whether the task type is valid, and if it's a task with classes, check
        // if it contains classes
        return !WITHOUT_CLASS_PROBLEMS.contains(taskType) &&
                (!WITH_CLASS_PROBLEMS.contains(taskType) || getStringList(json, CLASSES) == null);

    }

    private String getString(JsonObject json, String key) {
        return Optional.ofNullable(json.get(key)).map(JsonElement::getAsString).orElse(null);
    }

    private int getInteger(JsonObject json, String key) {
        return Optional.ofNullable(json.get(key)).map(JsonElement::getAsInt).orElse(INVALID_TASK_TYPE);
    }

    private List<String> getStringList(JsonObject json, String key) {
        JsonArray array = json.getAsJsonArray(key);
        if (array == null) return null;
        List<String> list = new ArrayList<>();
        for (JsonElement element : array)
            list.add(element.getAsString());
        return list;
    }

    public int size() {
        if (json.isJsonArray()) return json.getAsJsonArray().size();
        return 1;
    }

    @NotNull
    @Override
    public Iterator<TaskInfo> iterator() {
        return new Iterator<TaskInfo>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public TaskInfo next() {
                JsonObject next;
                if (json.isJsonArray()) {
                    next = json.getAsJsonArray().get(index++).getAsJsonObject();
                } else {
                    next = json.getAsJsonObject();
                    index++;
                }
                TaskInfo nextInfo;
                // Create TaskInfo according to different task type
                int type = getInteger(next, TASK_TYPE);
                String description = getString(next, DESCRIPTION);
                if (WITH_CLASS_PROBLEMS.contains(type)) {
                    List<String> labels = getStringList(next, CLASSES);
                    nextInfo = new TaskInfo(type, description, labels);
                } else
                    nextInfo = new TaskInfo(type, description);

                return nextInfo;
            }

        };
    }

    public enum Result {
        valid,
        invalid
    }
}
