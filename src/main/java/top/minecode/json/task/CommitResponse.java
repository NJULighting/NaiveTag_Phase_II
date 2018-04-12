package top.minecode.json.task;

/**
 * Created on 2018/4/12.
 * Description:
 *
 * @author iznauy
 */
public class CommitResponse {

    private boolean result;

    public CommitResponse(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
