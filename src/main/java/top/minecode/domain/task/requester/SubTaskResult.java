package top.minecode.domain.task.requester;

import top.minecode.domain.tag.TagResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2018/4/14.
 * Description:
 *
 * @author iznauy
 */
public class SubTaskResult {

    private Map<String, TagResult> results;

    public SubTaskResult() {
        results = new HashMap<>();
    }

    public SubTaskResult(Map<String, TagResult> results) {
        this.results = results;
    }

    public Map<String, TagResult> getResults() {
        return results;
    }

    public void setResults(Map<String, TagResult> results) {
        this.results = results;
    }

    public void extendResult(Map<String, TagResult> newResults) {
        results.putAll(newResults);
    }
}
