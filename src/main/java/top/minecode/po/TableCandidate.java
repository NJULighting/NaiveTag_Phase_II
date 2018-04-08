package top.minecode.po;

import com.google.gson.reflect.TypeToken;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import top.minecode.json.JsonConfig;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/7.
 * Description:
 * @author Liao
 */
public class TableCandidate<PO> {

    private List<PO> pos;
    private static final String CLASS_PATH = TableCandidate.class.getResource("/").getPath();
    private final String filePath;

    TableCandidate(String fileName) {
        filePath = CLASS_PATH + fileName + ".json";
        load();
    }

    public int size() {
        return pos.size();
    }

    public int getNextId() {
        return pos.size() + 1;
    }

    public List<PO> getAll() {
        return pos;
    }

    public <T> PO getBy(T condition, Function<PO, T> function) {
        return pos.stream().filter(e -> function.apply(e).equals(condition))
                .findFirst().orElse(null);
    }

    public List<PO> filter(Predicate<PO> filter) {
        return pos.stream().filter(filter).collect(Collectors.toList());
    }

    private void write(String json) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filePath));
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load() {
        Resource resource = new FileSystemResource(filePath);

        try {
            // Check whether the file exists
            if (!resource.exists()) {
                pos = new ArrayList<>();
                //noinspection ResultOfMethodCallIgnored
                resource.getFile().createNewFile();
                return;
            }

            // Read the file
            InputStreamReader reader = new InputStreamReader(resource.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder builder = new StringBuilder();

            // Begin reading
            String tmp;
            while ((tmp = bufferedReader.readLine()) != null)
                builder.append(tmp);

            // Parse to List<PO>
            Type poType = new TypeToken<List<PO>>() {
            }.getType();
            pos = JsonConfig.getGson().fromJson(builder.toString(), poType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(PO po) {
        // Add to the collection and update to the file
        pos.add(po);
        write(JsonConfig.getGson().toJson(pos));
    }
}
