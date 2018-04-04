package top.minecode.domain.tag;

import top.minecode.utils.Pair;

/**
 * Created on 2018/4/2.
 * Description:
 * @author Liao
 */
public class SingleSquareTagResult extends TagResult {

    private String label;
    private Pair<Point, Point> points;

    public SingleSquareTagResult(Integer id, String dataUrl, String label, Pair<Point, Point> points) {
        super(id, dataUrl);
        this.label = label;
        this.points = points;
    }

    public String getLabel() {
        return label;
    }

    public Pair<Point, Point> getPoints() {
        return points;
    }
}
