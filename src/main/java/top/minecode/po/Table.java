package top.minecode.po;

import java.io.*;

/**
 * Created on 2018/4/2.
 * Description:
 * @author iznauy
 */
@Deprecated
public abstract class Table {

    // 存放所有数据库表位置
    protected static final String GENERAL_FILE_PATH = Table.class.getResource("/").getPath();

    protected abstract String getFileName();

    protected Table() {
        load();
    }

    // 把json字符串写到文件
    protected void writeToFile(String json) {
        String filePath = GENERAL_FILE_PATH + getFileName();
        File file = new File(filePath);

        try {
            if (!file.exists())
                file.createNewFile();
            PrintWriter writer = new PrintWriter(new FileWriter(file));
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 加载一个json字符串
    protected String loadFromFile() {
        // 加载完整文件名
        String filePath = GENERAL_FILE_PATH + getFileName();
        File file = new File(filePath);

        if (!file.exists())
            return null; //文件不存在，意味着此前没有存储过数据

        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String temp = null;
            while ((temp = bufferedReader.readLine()) != null)
                sb.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return sb.toString();
    }

    protected abstract void load();

    protected abstract void save();

}
