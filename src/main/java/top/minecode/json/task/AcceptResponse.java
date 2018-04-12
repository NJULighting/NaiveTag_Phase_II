package top.minecode.json.task;

/**
 * Created on 2018/4/12.
 * Description:
 *
 * @author iznauy
 */
public class AcceptResponse {

    private boolean result;

    public AcceptResponse(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
