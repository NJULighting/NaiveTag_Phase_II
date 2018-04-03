package top.minecode.po;

import top.minecode.domain.TagResult;
import top.minecode.domain.task.ThirdLevelTaskResultType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Created on 2018/4/1.
 * Description:
 * @author iznauy
 */
public class ThirdLevelTaskResultPO {

    private Integer id;

    private Integer thirdLevelTaskId;

    private Map<String, TagResult> tagResults;

    private Integer doerId;

    private Double actualScore;

    private LocalDateTime acceptTime;

    private LocalDateTime expireTime;

    private ThirdLevelTaskResultType state;

    public LocalDateTime getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(LocalDateTime acceptTime) {
        this.acceptTime = acceptTime;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public ThirdLevelTaskResultType getState() {
        return state;
    }

    public void setState(ThirdLevelTaskResultType state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getThirdLevelTaskId() {
        return thirdLevelTaskId;
    }

    public void setThirdLevelTaskId(Integer thirdLevelTaskId) {
        this.thirdLevelTaskId = thirdLevelTaskId;
    }

    public Map<String, TagResult> getTagResults() {
        return tagResults;
    }

    public void setTagResults(Map<String, TagResult> tagResults) {
        this.tagResults = tagResults;
    }

    public Integer getDoerId() {
        return doerId;
    }

    public void setDoerId(Integer doerId) {
        this.doerId = doerId;
    }

    public Double getActualScore() {
        return actualScore;
    }

    public void setActualScore(Double actualScore) {
        this.actualScore = actualScore;
    }
}