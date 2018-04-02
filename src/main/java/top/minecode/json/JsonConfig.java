package top.minecode.json;

import com.google.gson.Gson;

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
            gson = new Gson();
        return gson;
    }

}
