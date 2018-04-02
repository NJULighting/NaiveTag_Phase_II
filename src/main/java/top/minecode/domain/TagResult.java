package top.minecode.domain;

/**
 * Created on 2018/4/1.
 * Description:
 * @author Liao
 */
public abstract class TagResult {

    private Integer id;
    private String dataUrl;


    public TagResult(Integer id, String dataUrl) {
        this.id = id;
        this.dataUrl = dataUrl;
    }

    public Integer getId() {
        return id;
    }

    public String getDataUrl() {
        return dataUrl;
    }
}
