package top.minecode.domain;

import top.minecode.utils.Pair;

import java.util.Map;

/**
 * Created on 2018/4/1.
 * Description:
 * @author Liao
 */
public class MultiSquareTagResult extends TagResult{
    private Map<String, Pair<Point, Point>> labelPointsTable;

    public MultiSquareTagResult(Integer id, String dataUrl, Map<String, Pair<Point, Point>> labelPointsTable) {
        super(id, dataUrl);
        this.labelPointsTable = labelPointsTable;
    }

    public Map<String, Pair<Point, Point>> getLabelPointsTable() {
        return labelPointsTable;
    }
}
