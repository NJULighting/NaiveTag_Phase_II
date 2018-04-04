package top.minecode.domain.tag;

/**
 * Created on 2018/4/2.
 * Description:
 * @author Liao
 */
public class GlobalTagResult extends TagResult {

    private String label;

    public GlobalTagResult(Integer id, String dataUrl, String label) {
        super(id, dataUrl);
    }

    public String getLabel() {
        return label;
    }
}
