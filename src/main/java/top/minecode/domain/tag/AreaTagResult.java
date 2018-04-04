package top.minecode.domain.tag;

import java.util.List;

/**
 * Created on 2018/4/2.
 * Description:
 * @author Liao
 */
public class AreaTagResult extends TagResult {

    private String label;
    private List<Point> points;

    public AreaTagResult(Integer id, String dataUrl, String label, List<Point> points) {
        super(id, dataUrl);
        this.label = label;
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public String getLabel() {
        return label;
    }
}
