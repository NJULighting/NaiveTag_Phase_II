package top.minecode.domain.task;

import java.util.List;

/**
 * Created on 2018/4/4.
 * Description:
 *
 * @author iznauy
 */
public class ProvideLabelsTaskInfo extends TaskInfo {

    private List<String> labels;

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}
