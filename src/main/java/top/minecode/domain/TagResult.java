package top.minecode.domain;

import top.minecode.utils.Pair;

import java.util.List;

/**
 * Created on 2018/4/1.
 * Description:
 * @author Liao
 */
public class TagResult {

    private Integer id;
    private String url;
    private String label;
    private List<Pair<Integer, Integer>> positions;

    public TagResult(String url, String label, List<Pair<Integer, Integer>> positions) {
        this.url = url;
        this.label = label;
        this.positions = positions;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Pair<Integer, Integer>> getPositions() {
        return positions;
    }

    public void setPositions(List<Pair<Integer, Integer>> positions) {
        this.positions = positions;
    }
}
