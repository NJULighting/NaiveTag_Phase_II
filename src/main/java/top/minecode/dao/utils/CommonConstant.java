package top.minecode.dao.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 2018/4/3.
 * Description:
 *
 * @author iznauy
 */
public class CommonConstant {

    public static final int TOTAL_MARK = 100;

    public static final int SINGLE_SQUARE_MARK = 200;

    public static final int MULTI_SQUARE_MARK = 300;

    public static final int AREA_MARK = 400;

    public static final int TOTAL_DESCRIBE = 101;

    public static final int SINGLE_SQUARE_DESCRIBE = 201;

    public static final int MULTI_SQUARE_DESCRIBE = 301;

    public static final int AREA_DESCRIBE = 401;

    static final String TASK_TYPE = "taskType";

    static final String FORMAT = "format";

    static final String DESCRIPTION = "description";

    static final String CLASSES = "classes";

    // 文件解压器buffer的大小
    public static final int UNZIPPER_BUFFER_SIZE = 1024;

    public static final Set<Integer> WITH_CLASS_PROBLEMS = new HashSet<Integer>();

    public static final Set<Integer> WITHOUT_CLASS_PROBLEMS = new HashSet<Integer>();

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

}
