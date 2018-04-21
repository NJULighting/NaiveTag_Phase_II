package top.minecode.po;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import top.minecode.json.JsonConfig;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class Table<PO> {

    private List<PO> pos;
    private static final String CLASS_PATH = Table.class.getResource("/").getPath();
    private final String filePath;

    Table(String fileName) {
        filePath = CLASS_PATH + fileName + ".table";
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

    public <T> PO getPOBy(T condition, Function<PO, T> function) {
        return pos.stream().filter(e -> {
            T target = function.apply(e);
            return target != null && target.equals(condition);
        }).findFirst().orElse(null);
    }

    public <T> List<PO> getPOsBy(T condition, Function<PO, T> function) {
        return filter(e -> {
            T target = function.apply(e);
            return target != null && target.equals(condition);
        });
    }

    public <T, R> List<R> getAttributesBy(T condition, Function<PO, T> function, Function<PO, R> mapper) {
        return pos.stream().filter(e -> {
            T target = function.apply(e);
            return target != null && target.equals(condition);
        }).map(mapper).collect(Collectors.toList());
    }

    public List<PO> filter(Predicate<PO> filter) {
        return pos.stream().filter(filter).collect(Collectors.toList());
    }

    private void load() {
        Resource resource = new FileSystemResource(filePath);

        try {
            // Check whether the file exists
            if (!resource.exists()) {
                pos = new ArrayList<>();
                //noinspection ResultOfMethodCallIgnored
                resource.getFile().createNewFile();
                save();
                return;
            }

            ObjectInputStream objectInputStream = new ObjectInputStream(resource.getInputStream());
            //noinspection unchecked
            pos = (List<PO>) objectInputStream.readObject();

            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            pos = new ArrayList<>();
        }
    }

    public void add(PO po) {
        // Add to the collection and update to the file
        pos.add(po);
        save();
    }


    public void save() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(pos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printContent() {
        pos.forEach(po -> System.out.println(JsonConfig.getGson().toJson(po)));
    }
}
