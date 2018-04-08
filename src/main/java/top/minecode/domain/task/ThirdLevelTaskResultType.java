package top.minecode.domain.task;

/**
 * Created on 2018/4/3.
 * Description:
 *
 * @author iznauy
 */
public enum ThirdLevelTaskResultType {

    fail, //表示在结束时间之前没做完
    finish,
    doing, //正在进行中
    expired;

}
